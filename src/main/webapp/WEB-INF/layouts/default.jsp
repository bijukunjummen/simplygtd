<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util" %>

<html>  
	<head>
	<util:load-scripts/>
    <spring:message code="application_name" var="app_name"/>
	
	<title><spring:message code="welcome_h3" arguments="${app_name}" /></title>
	</head>
	
  	<body>
   		<div class="container">
   			<div class="span-24">
		    	<tiles:insertAttribute name="header" ignore="true" />
		    </div>
		    <div class="span-5 border" >
		    	<tiles:insertAttribute name="sidebar" ignore="true" />
		    </div> 
		    <div class="span-18 border" > 
    			<tiles:insertAttribute name="body"/> 
    		</div>
    		<div class="span-24">
	    		<tiles:insertAttribute name="footer" ignore="true"/>
	    	</div>
		</div>
	</body>
</html>
