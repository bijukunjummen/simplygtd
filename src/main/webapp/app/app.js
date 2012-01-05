Ext.JSON.encodeDate = function(o)
{
   return '"' + Ext.Date.format(o, 'c') + '"';
};

Ext.application({
    name: 'GTD',
    controllers: [
        'Contexts',
        'Projects'
    ],    
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'border',
            items: [Ext.create('Ext.panel.Panel',{
            	region:'west',
            	margins:'5 0 5 5',
                split:true,
                width: 210,            	
            	items:[ { xtype:'contextlist' }, { xtype:'projectlist' } ]
                }),
                {
                    region:'center',
                    margins:'5 5 5 0',
                    cls:'empty',
                    bodyStyle:'background:#f1f1f1',
                    html:'<br/><br/>&lt;empty center panel&gt;'
                }      
            ]
        });
    }
});