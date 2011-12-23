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