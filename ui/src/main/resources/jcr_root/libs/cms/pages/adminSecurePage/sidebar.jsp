<%@include file="/libs/cms/global.jsp"%>
<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<c:if test="${slingRequest.requestPathInfo.suffix == null}">
				<li class="sidebar-link">
					<a href="/admin/home.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
				</li>
				<li class="sidebar-link">
					<a href="/admin/sites.html"><i class="fa fa-sitemap fa-fw"></i> Sites</a>
				</li>
				<li class="sidebar-link">
					<a href="/admin/users.html"><i class="fa fa-user fa-fw"></i> Users</a>
				</li>
				<li class="sidebar-link">
					<a href="#"><i class="fa fa-wrench fa-fw"></i> Configuration<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li>
							<a href="/admin/config/system.html"> System Settings</a>
						</li>
						<li>
							<a href="/admin/config/recaptcha.html"> reCAPTCHA</a>
						</li>
						<li>
							<a href="/admin/config/email.html"> email</a>
						</li>
					</ul>
				</li>
			</c:if>
			<c:if test="${slingRequest.requestPathInfo.suffix != null}">
				<li class="sidebar-link">
					<a href="/admin/sites.html"><i class="fa fa-angle-left fa-fw"></i> Change Site</a>
				</li>
				<li class="sidebar-link">
					<a href="/admin/site/home.html${slingRequest.requestPathInfo.suffix}"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
				</li>
				<li class="sidebar-link">
					<sling:getResource path="/content${slingRequest.requestPathInfo.suffix}/jcr:content" var="site" />
					<sling:adaptTo var="siteProperties" adaptable="${site}" adaptTo="org.apache.sling.api.resource.ValueMap" />
					<a href="#"><i class="fa fa-sitemap fa-fw"></i> <c:out value="${siteProperties['jcr:title']}" default="${slingRequest.requestPathInfo.suffix}"/></a>
					<ul class="nav nav-second-level collapse in">
						<li class="sidebar-link">
							<a href="/admin/site/content.html${slingRequest.requestPathInfo.suffix}"><i class="fa fa-list-alt fa-fw"></i> Content</a>
						</li>
						<li class="sidebar-link">
							<a href="/admin/assets.html${slingRequest.requestPathInfo.suffix}"><i class="fa fa-image fa-fw"></i> Assets</a>
						</li>
						<li class="sidebar-link">
							<a href="/admin/clientlibs.html${slingRequest.requestPathInfo.suffix}"><i class="fa fa-paint-brush fa-fw"></i> ClientLibs</a>
						</li>
						<li class="sidebar-link">
							<a href="/admin/users.html${slingRequest.requestPathInfo.suffix}"><i class="fa fa-users fa-fw"></i> Site Users</a>
						</li>
					</ul>
			</c:if>
		</ul>
	</div>
</div>