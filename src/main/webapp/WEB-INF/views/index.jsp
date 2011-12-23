<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:url var="readUrl" value="/gtdcontexts/read.json" />
<spring:url var="createUrl" value="/gtdcontexts/create.json" />
<spring:url var="updateUrl" value="/gtdcontexts/update.json" />
<spring:url var="deleteUrl" value="/gtdcontexts/delete.json" />

<spring:url var="gtdcontextsJsonSaveUrl" value="/gtdcontexts/save.json" />

<spring:url var="contextjs" value="/app/context.js" />

<script type="text/javascript">
var GLOBAL={};
GLOBAL.context={};
GLOBAL.context.readUrl   = '${readUrl}';
GLOBAL.context.updateUrl = '${updateUrl}';
GLOBAL.context.deleteUrl = '${deleteUrl}';
GLOBAL.context.createUrl = '${createUrl}';
</script>

<script src="${contextjs}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script type="text/javascript">
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
</script>