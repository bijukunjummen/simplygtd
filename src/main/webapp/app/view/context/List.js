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