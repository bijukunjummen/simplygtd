function formatDate(value){
   return value ? Ext.Date.dateFormat(value, 'M d, Y') : '';
}

Ext.define('GTD.view.project.List',{
	extend:'Ext.grid.Panel',
	alias: 'widget.projectlist',
	iconCls: 'icon-grid',
	title: 'Projects',
	store:'Projects',
	columns: [{
        header: 'Name',
        width: 250,
        sortable:false,
        dataIndex:'name',
        field: {
            xtype: 'textfield',
            allowBlank: false
        }
    },{
        header: 'Start Date',
        width: 250,
        sortable:false,
        dataIndex:'startDate',
        renderer: formatDate
    },{
        header: 'End Date',
        width: 250,
        sortable:false,
        dataIndex:'completedDate',
        renderer: formatDate
    },{
        header: 'Done?',
        width: 250,
        sortable:false,
        dataIndex:'isDone'
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
            store: 'Projects',
            displayInfo: true,
            displayMsg: 'Displaying projects {0} - {1} of {2}',
            emptyMsg: "No projects to display"
        }];
        
        this.callParent(arguments);
    }
});