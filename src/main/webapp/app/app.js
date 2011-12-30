Ext.application({
    name: 'GTD',
    controllers: [
        'Contexts',
        'Projects'
    ],    
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [Ext.create('Ext.tab.Panel',{
            	items:[
            	       {
            	    	   xtype:'contextlist'
            	       },{
            	    	   xtype:'projectlist'
            	       }
            		]
            	})
            ]
        });
    }
});