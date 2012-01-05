Ext.define('GTD.model.Project',{
    extend: 'Ext.data.Model',
    fields:[{name:'id', type:'string'},{name:'name', type:'string'}, 
            {name:'startDate', type:'date', dateFormat:'c'}, {name:'completedDate', type:'date', dateFormat:'c'},
            {name:'isDone', type:'boolean'}, {name:'version', type:'string'}]
});