<%@include file="/libs/cms/global.jsp"%>
<c:if test="${slingRequest.requestPathInfo.suffix != null}">
	<sling:getResource path="/content${slingRequest.requestPathInfo.suffix}" var="siteResource" />
	<sling:adaptTo var="site" adaptable="${siteResource}" adaptTo="co.essomenic.cms.api.models.Site" />
</c:if>
<div data-ng-controller="AssetController" class="asset-controller">

  <input type="hidden" name="selectedAsset" class="selected-asset" data-ng-value="selectedAsset">
  
  <input type="hidden" name="basePath" class="base-path" value="${site.resource.path}/assets" />

  <ol class="breadcrumb">
    <li data-ng-repeat="crumb in breadcrumbs track by $index" data-ng-class="{'active' : $last}">
      <a href="#" data-ng-if="!$last" data-ng-click="navigate($index, true)">{{crumb}}</a>
      <span data-ng-if="$last">{{crumb}}</span>
    </li>
    <li>
	  <form style="display:inline-block" method="get" action="/admin/site/createfolder.html${slingRequest.requestPathInfo.suffix}">
	  	<input type="hidden" name="path" value="${site.resource.path}/assets" />
	  	<input type="hidden" name="return" value="/admin/site/assets.html${slingRequest.requestPathInfo.suffix}" />
	  	<button type="submit" class="btn btn-primary btn-xs"><i class="fa fa-plus"></i> Folder</button>
	  </form>
    </li>
  </ol>
  
  <br/><br/>

  <div class="row">

    <div class="col-xs-6 col-sm-4 col-md-2" data-ng-if="breadcrumbs.length > 1">
      <a class="thumbnail asset-thumbnail asset-folder" data-ng-click="navigate(-1, true)">
        <i class="fa fa-folder"></i>
        <div class="caption">
          <h6>../</h6>
        </div>
      </a>
    </div>

    <div class="col-xs-6 col-sm-4 col-md-2" data-ng-repeat="folder in folders | orderBy">
      <a class="thumbnail asset-thumbnail asset-folder" data-ng-click="navigate(folder, false)">
        <i class="fa fa-folder"></i>
        <div class="caption">
          <h6>{{folder}}</h6>
        </div>
      </a>
    </div>

    <div class="col-xs-6 col-sm-4 col-md-2" data-ng-repeat="asset in assets | orderBy">
      <a class="thumbnail asset-thumbnail asset-asset" data-ng-click="selectAsset($event)">
        <img data-ng-src="{{getImagePath(asset)}}" alt="{{asset}}">
        <div class="caption">
          <h6>{{asset}}</h6>
        </div>
      </a>
    </div>

    <div class="col-xs-6 col-sm-4 col-md-2" ngf-drop="" ngf-select="" ng-model="files" ng-model-rejected="rejFiles" ngf-drag-over-class="{accept:'hover', reject:'hover-error', delay:100}" ngf-multiple="true" ngf-allow-dir="true" ngf-accept="'image/*,application/pdf'" ngf-drop-available="dropAvailable">
      <a class="thumbnail asset-thumbnail asset-folder asset-upload">
        <i class="fa fa-upload"></i>
        <div class="caption">
          <h6>click/drag to upload</h6>
        </div>
      </a>
    </div>

  </div>
</div>