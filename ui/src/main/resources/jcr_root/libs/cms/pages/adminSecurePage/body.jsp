<%@include file="/libs/cms/global.jsp"%>
<body data-ng-app="publick">
  <div id="wrapper">
    <sling:call script="navigation.jsp" />

    <div id="page-wrapper">
      <div class="row">
        <div class="col-lg-12">
          <h1 class="page-header"><c:out value="${properties.title}" default="${properties['jcr:title']}" /></h1>
        </div>
      </div>

		<sling:include path="jcr:content/mainContent" />

    </div>
  </div>
  <sling:call script="scripts.jsp" />
</body>