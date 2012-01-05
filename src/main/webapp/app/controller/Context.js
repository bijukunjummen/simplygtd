Ext.define('GTD.controller.Contexts', {
    extend: 'Ext.app.Controller',
    stores: ['Contexts'],
    models: ['Context'],
    views: ['context.Edit', 'context.List'],
    refs: [{
            ref: 'contextedit',
            selector: 'contextedit'
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
