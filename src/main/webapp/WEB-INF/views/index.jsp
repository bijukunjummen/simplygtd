<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:url var="readUrl" value="/gtdcontexts/read.json" />
<spring:url var="createUrl" value="/gtdcontexts/create.json" />
<spring:url var="updateUrl" value="/gtdcontexts/update.json" />
<spring:url var="deleteUrl" value="/gtdcontexts/delete.json" />

<spring:url var="gtdcontextsJsonSaveUrl" value="/gtdcontexts/save.json" />

<spring:url var="contextApp" value="/app/app.js" />
<spring:url var="contextController" value="/app/controller/Context.js" />
<spring:url var="contextModel" value="/app/model/Context.js" />
<spring:url var="contextStore" value="/app/store/Contexts.js" />
<spring:url var="contextViewEdit" value="/app/view/context/Edit.js" />
<spring:url var="contextViewList" value="/app/view/context/List.js" />


<script type="text/javascript">
var GLOBAL={};
GLOBAL.context={};
GLOBAL.context.readUrl   = '${readUrl}';
GLOBAL.context.updateUrl = '${updateUrl}';
GLOBAL.context.deleteUrl = '${deleteUrl}';
GLOBAL.context.createUrl = '${createUrl}';
</script>

<script src="${contextModel}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${contextStore}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${contextViewEdit}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${contextViewList}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${contextController}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${contextApp}" type="text/javascript"><!-- /required for FF3 and Opera --></script>