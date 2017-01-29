<%@include file="/libs/cms/global.jsp"%>
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            <li class="sidebar-search">
                <div class="input-group custom-search-form full-width">
                    <a class="btn btn-primary btn-block" href="/admin/edit.html" role="button">Create new blog post!</a>
                </div>
            </li>
            <li class="sidebar-link">
                <a href="/admin/home.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
            </li>
            <c:if test="${slingRequest.requestPathInfo.suffix == null}">
	            <li class="sidebar-link">
	                <a href="/admin/sites.html"><i class="fa fa-sitemap fa-fw"></i> Sites</a>
	            </li>
	        </c:if>
            <c:if test="${slingRequest.requestPathInfo.suffix != null}">
	            <li class="sidebar-link">
	                <a href="/admin/sites.html"><i class="fa fa-sitemap fa-fw"></i> Change Site</a>
	            </li>
	            <li class="sidebar-link">
	                <a href="/admin/edit.html"><i class="fa fa-pencil fa-fw"></i> New Page</a>
	            </li>
	            <li class="sidebar-link">
	                <a href="/admin/list.html"><i class="fa fa-list-alt fa-fw"></i> Content</a>
	            </li>
	            <li class="sidebar-link">
	                <a href="/admin/assets.html"><i class="fa fa-image fa-fw"></i> Assets</a>
	            </li>
	            <li class="sidebar-link">
	                <a href="/admin/assets.html"><i class="fa fa-image fa-fw"></i> ClientLibs</a>
	            </li>
	        </c:if>
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
        </ul>
    </div>
</div>