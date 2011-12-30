<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:url var="contextReadUrl" value="/gtdcontexts/read.json" />
<spring:url var="contextCreateUrl" value="/gtdcontexts/create.json" />
<spring:url var="contextUpdateUrl" value="/gtdcontexts/update.json" />
<spring:url var="contextDeleteUrl" value="/gtdcontexts/delete.json" />

<spring:url var="projectReadUrl" value="/gtdprojects/read.json" />
<spring:url var="projectCreateUrl" value="/gtdprojects/create.json" />
<spring:url var="projectUpdateUrl" value="/gtdprojects/update.json" />
<spring:url var="projectDeleteUrl" value="/gtdprojects/delete.json" />


<spring:url var="gtdcontextsJsonSaveUrl" value="/gtdcontexts/save.json" />

<spring:url var="mainApp" value="/app/app.js" />
<spring:url var="datecustom" value="/app/view/date-custom.js" />

<spring:url var="contextController" value="/app/controller/Context.js" />
<spring:url var="contextModel" value="/app/model/Context.js" />
<spring:url var="contextStore" value="/app/store/Contexts.js" />
<spring:url var="contextViewEdit" value="/app/view/context/Edit.js" />
<spring:url var="contextViewList" value="/app/view/context/List.js" />

<spring:url var="projectController" value="/app/controller/Project.js" />
<spring:url var="projectModel" value="/app/model/Project.js" />
<spring:url var="projectStore" value="/app/store/Projects.js" />
<spring:url var="projectViewEdit" value="/app/view/project/Edit.js"/>
<spring:url var="projectViewList" value="/app/view/project/List.js"/>


<script type="text/javascript">
var GLOBAL={};
GLOBAL.context={};
GLOBAL.project={};
GLOBAL.context.readUrl   = '${contextReadUrl}';
GLOBAL.context.updateUrl = '${contextUpdateUrl}';
GLOBAL.context.deleteUrl = '${contextDeleteUrl}';
GLOBAL.context.createUrl = '${contextCreateUrl}';
GLOBAL.project.readUrl   = '${projectReadUrl}';
GLOBAL.project.updateUrl = '${projectUpdateUrl}';
GLOBAL.project.deleteUrl = '${projectDeleteUrl}';
GLOBAL.project.createUrl = '${projectCreateUrl}';

</script>
<script src="${datecustom}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${contextModel}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${contextStore}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${contextViewEdit}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${contextViewList}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${contextController}" type="text/javascript"><!-- /required for FF3 and Opera --></script>

<script src="${projectModel}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${projectStore}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${projectViewEdit}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${projectViewList}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${projectController}" type="text/javascript"><!-- /required for FF3 and Opera --></script>

<script src="${mainApp}" type="text/javascript"><!-- /required for FF3 and Opera --></script>

