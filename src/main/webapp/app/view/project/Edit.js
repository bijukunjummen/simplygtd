Ext.define('GTD.view.project.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.projectedit',
    requires: ['Ext.form.Panel','Ext.form.field.Text'],
    title : 'Edit Project',
    layout: 'fit',
    autoShow: true,
    width: 350,    
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
                    },                    
                    {
                        xtype: 'datetimefield',
                        itemId:'startDate',
                        name : 'startDate',
                        fieldLabel: 'Start Date'
                    },                    
                    {
                        xtype: 'datetimefield',
                        itemId:'completedDate',
                        name : 'completedDate',
                        fieldLabel: 'Completed Date'
                    },                    
                    {
                        xtype: 'checkboxfield',
                        name : 'isDone',
                        fieldLabel: 'Done?'
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