<%@include file="/libs/cms/global.jsp"%>
<c:if test="${slingRequest.requestPathInfo.suffix != null}">
	<sling:getResource path="/content${slingRequest.requestPathInfo.suffix}" var="siteResource" />
	<sling:adaptTo var="site" adaptable="${siteResource}" adaptTo="co.essomenic.cms.api.models.Site" />
</c:if>
<form action="/admin/bin/deletesite" method="post">
	<input type="hidden" name="path" value="/content${slingRequest.requestPathInfo.suffix}" />
	<div class="alert alert-danger">
		Are you sure you want to delete <sling:encode value="${site.name}" default="${slingRequest.requestPathInfo.suffix}" mode="HTML" />?
	</div>
	<div class="row">
		<div class="col-lg-12 col-md-12">
			<div class="form-group">
				<input type="submit" value="Delete" class="btn btn-danger" />
				&nbsp;
				<a href="/admin/sites.html" class="btn btn-default">
					Cancel
				</a>
			</div>
		</div>
	</div>
</form>