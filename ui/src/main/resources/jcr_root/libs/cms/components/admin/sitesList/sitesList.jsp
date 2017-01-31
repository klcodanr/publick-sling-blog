<%@include file="/libs/cms/global.jsp"%>
<div data-ng-controller="SiteController" class="site-controller">
	<div class="row">
		<div class="col-xs-12">
			<a class="btn btn-primary" href="/admin/site/create.html" role="button"><span class="fa fa-plus"></span> Add Site</a>
		</div>
	</div>
	<br/>
	<div class="row">
		<div class="col-xs-6 col-sm-4 col-md-2" data-ng-repeat="site in sites | orderBy">
			<div class="well">
				<div class="text-center">
					<i class="fa fa-sitemap fa-3x"></i>
					<h4>
						<a href="/admin/site/home.html/{{site}}">
							{{site}}
						</a>
					</h4>
				</div>
				<a class="btn btn-default btn-sm" title="Edit Site" href="/admin/site/home.html/{{site}}">
					<i class="fa fa-pencil"><span class="sr-only">Edit</span></i>
				</a>
				<a class="btn btn-default btn-sm" title="Configure Site" href="/admin/site/edit.html/{{site}}">
					<i class="fa fa-gear"><span class="sr-only">Configure</span></i>
				</a>
				<a class="btn btn-sm btn-danger" title="Delete Site" href="/admin/site/delete.html/{{site}}">
					<i class="fa fa-trash"><span class="sr-only">Delete</span></i>
				</a>
			</div>
		</div>
	</div>
</div>