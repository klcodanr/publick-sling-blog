<%@include file="/libs/cms/global.jsp"%>
<form action="/admin/bin/foldercreate" method="post" enctype="multipart/form-data">
	<input type="hidden" name="path"  value="${param.path}" />
	<input type="hidden" name="return"  value="${param.return}" />
	<div class="row">
		<div class="col-lg-6 col-md-6">
			<div class="form-group">
				<label for="name">Folder Name <span class="text-danger">*</span></label>
				<input type="text" name="name" class="form-control" required="required" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12 col-md-12">
			<div class="form-group">
				<input type="submit" value="Create" class="btn btn-success" />
				&nbsp;
				<a href="${param.return}" class="btn btn-default">
					Cancel
				</a>
			</div>
		</div>
	</div>
</form>