Ext.application({
    name: 'GTD',
    controllers: [
        'Contexts'
    ],    
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
                {
                    xtype:'contextlist'
                }
            ]
        });
    }
});