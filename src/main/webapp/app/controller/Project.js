Ext.define('GTD.controller.Projects', {
    extend: 'Ext.app.Controller',
    stores: ['Projects'],
    models: ['Project'],
    views: ['project.Edit', 'project.List'],
    refs: [{
            ref: 'projectsPanel',
            selector: 'panel'
        },{
            ref: 'projectlist',
            selector: 'projectlist'
        }
    ],
    init: function() {
        this.control({
            'projectlist': {
                itemdblclick: this.editProject
            },
            'projectlist button[action=add]': {
                click: this.editProject
            },
            'projectlist button[action=delete]': {
                click: this.deleteProject
            },
            'projectedit button[action=save]': {
                click: this.updateProject
            }
        });
    },
    editProject: function(grid, record) {
        var edit = Ext.create('GTD.view.project.Edit').show();
        
        if(record){
            edit.down('form').loadRecord(this.getProjectsStore().getById(record.get("id")));
        }
    },
    
    updateProject: function(button) {
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();
        
        
        if (values.id > 0){
            record.set(values);
        } else{
            record = Ext.create('GTD.model.Project');
            record.set(values);
            record.setId(0);
            this.getProjectsStore().add(record);
        }
        
        win.close();
        this.getProjectsStore().sync();
    },
    
    deleteProject: function(button) {
        
        var grid = this.getProjectlist(),
        record = grid.getSelectionModel().getSelection(), 
        store = this.getProjectsStore();

        store.remove(record);
        this.getProjectsStore().sync();
    }
});
