<%@include file="/libs/cms/global.jsp"%>
<c:if test="${slingRequest.requestPathInfo.suffix != null}">
	<sling:getResource path="/content${slingRequest.requestPathInfo.suffix}" var="siteResource" />
	<sling:adaptTo var="site" adaptable="${siteResource}" adaptTo="co.essomenic.cms.api.models.Site" />
</c:if>
<div class="row">
    <div class="col-lg-12">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th class="column-small">#</th>
                    <th>Content</th>
                    <th class="column-small">Edit</th>
                    <th class="column-small">Delete</th>
                </tr>
            </thead>
            <tbody data-sly-list="${list.blogs}">
                <tr>
                    <td data-sly-text="${itemList.count}"></td>
                    <td><a href="${item.path}.html" target="_blank">${item.name}</a></td>
                    <td><a href="edit.html${item.path}"><i class="glyphicon glyphicon-pencil"></i></a></td>
                    <td><i class="glyphicon glyphicon-trash"></i></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>