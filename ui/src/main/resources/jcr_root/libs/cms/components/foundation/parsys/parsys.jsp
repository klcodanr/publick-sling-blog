<%@include file="/libs/cms/global.jsp"%>
<c:forEach var="child" items="${sling:listChildren(resource)}">
	<sling:include resource="${child}" />
</c:forEach>