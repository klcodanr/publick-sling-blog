<%--
  Copyright 2017 - Essomenic Systems
  All Rights Reserved.
--%><%@page session="false" %><%@taglib prefix="sling" uri="http://sling.apache.org/taglibs/sling" %><%
%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%
%><%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%
%><%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><%
%><sling:defineObjects /><sling:adaptTo var="properties" adaptable="${resource}" adaptTo="org.apache.sling.api.resource.ValueMap" />
<sling:adaptTo var="ra" adaptable="${slingRequest}" adaptTo="co.essomenic.cms.api.models.RedirectAttribute" />
