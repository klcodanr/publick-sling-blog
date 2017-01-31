package co.essomenic.cms.api.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class Site {

	public static final String PN_NAME = "name";
	public static final String PN_DESCRIPTION = "description";

	@Inject
	@Optional
	private Resource config;

	@Inject
	@Optional
	private String description;

	@Inject
	private String name;
	
	private Resource resource;

	public Site(Resource resource){
		this.resource = resource;
	}

	public Resource getConfig() {
		return config;
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return resource.getName();
	}

	public String getName() {
		return name;
	}

	public Resource getResource() {
		return resource;
	}

	public void setConfig(Resource config) {
		this.config = config;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}
