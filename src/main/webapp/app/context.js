Ext.define('GTD.model.Context',{
    extend: 'Ext.data.Model',
    fields: [{name: 'id', type: 'string'},{name: 'name', type: 'string'},{name: 'version', type: 'string'}]
}); 

Ext.define('GTD.store.Contexts', {
    extend: 'Ext.data.Store',
    model: 'GTD.model.Context',
    autoLoad: true,
    pageSize: 4,
    autoLoad: {start: 0, limit: 4},
    
    proxy: {
        type: 'ajax',
        api: {
            read: GLOBAL.context.readUrl,
            update: GLOBAL.context.updateUrl,
            destroy: GLOBAL.context.deleteUrl,
            create: GLOBAL.context.createUrl
        },
        reader: {
            type: 'json',
            root: 'data',
            totalProperty : 'totalSize'
        },
        writer: {
            type: 'json',
            writeAllFields: true,
            encode: false
        },
        listeners: {
            exception: function(proxy, response, operation){
                Ext.MessageBox.show({
                    title: 'No Response from Server',
                    msg: operation.getError(),
                    icon: Ext.MessageBox.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        }
    }
});

Ext.define('GTD.view.context.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.contextedit',
    requires: ['Ext.form.Panel','Ext.form.field.Text'],
    title : 'Edit Context',
    layout: 'fit',
    autoShow: true,
    width: 280,    
    iconCls: 'icon-user',
    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                padding: '5 5 0 5',
                border: false,
                style: 'background-color: #fff;',
                
                fieldDefaults: {
                    anchor: '100%',
                    labelAlign: 'left',
                    allowBlank: false,
                    combineErrors: true,
                    msgTarget: 'side'
                },

                items: [
                    {
                        xtype: 'textfield',
                        name : 'id',
                        fieldLabel: 'id',
                        hidden:true
                    },    
                    {
                        xtype: 'textfield',
                        name : 'name',
                        fieldLabel: 'Name'
                    }       
                ]
            }
        ];
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            id:'buttons',
            ui: 'footer',
            items: ['->', {
                iconCls: 'icon-save',
                itemId: 'save',
                text: 'Save',
                action: 'save'
            },{
                iconCls: 'icon-reset',
                text: 'Cancel',
                scope: this,
                handler: this.close
            }]
        }];

        this.callParent(arguments);
    }
});


Ext.define('GTD.view.context.List',{
	extend:'Ext.grid.Panel',
	alias: 'widget.contextlist',
	iconCls: 'icon-grid',
	title: 'Contexts',
	store:'Contexts',
	columns: [{
        header: 'Name',
        width: 250,
        sortable:false,
        dataIndex:'name',
        field: {
            xtype: 'textfield',
            allowBlank: false
        }
    }],
    initComponent: function() {
        this.dockedItems = [{
            xtype: 'toolbar',
            items: [{
                iconCls: 'icon-save',
                itemId: 'add',
                text: 'Add',
                action: 'add'
            },{
                iconCls: 'icon-delete',
                text: 'Delete',
                action: 'delete'
            }]
        },
        {
            xtype: 'pagingtoolbar',
            dock:'top',
            store: 'Contexts',
            displayInfo: true,
            displayMsg: 'Displaying contexts {0} - {1} of {2}',
            emptyMsg: "No contexts to display"
        }];
        
        this.callParent(arguments);
    }
	
});



Ext.define('GTD.controller.Contexts', {
    extend: 'Ext.app.Controller',
    stores: ['Contexts'],
    models: ['Context'],
    views: ['context.Edit', 'context.List'],
    refs: [{
            ref: 'contextsPanel',
            selector: 'panel'
        },{
            ref: 'contextlist',
            selector: 'contextlist'
        }
    ],
    init: function() {
        this.control({
            'contextlist': {
                itemdblclick: this.editContext
            },
            'contextlist button[action=add]': {
                click: this.editContext
            },
            'contextlist button[action=delete]': {
                click: this.deleteContext
            },
            'contextedit button[action=save]': {
                click: this.updateContext
            }
        });
    },

    editContext: function(grid, record) {
        var edit = Ext.create('GTD.view.context.Edit').show();
        
        if(record){
            edit.down('form').loadRecord(record);
        }
    },
    
    updateContext: function(button) {
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();
        
        
        if (values.id > 0){
            record.set(values);
        } else{
            record = Ext.create('GTD.model.Context');
            record.set(values);
            record.setId(0);
            this.getContextsStore().add(record);
        }
        
        win.close();
        this.getContextsStore().sync();
    },
    
    deleteContext: function(button) {
        
        var grid = this.getContextlist(),
        record = grid.getSelectionModel().getSelection(), 
        store = this.getContextsStore();

        store.remove(record);
        this.getContextsStore().sync();
    }
});
