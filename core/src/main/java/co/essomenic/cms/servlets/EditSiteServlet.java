package co.essomenic.cms.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.jackrabbit.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.essomenic.cms.CMSConstants;
import co.essomenic.cms.api.models.RedirectAttribute;
import co.essomenic.cms.api.models.RedirectAttribute.LEVEL;
import co.essomenic.cms.api.models.Site;

/**
 * Servlet for editing sites
 * 
 * @author danklco
 */
@SlingServlet(paths = CMSConstants.SERVLET_PATH_ADMIN + "/siteedit")
public class EditSiteServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = -5528294838383339934L;

	/**
	 * The logger.
	 */
	private static final Logger log = LoggerFactory.getLogger(EditSiteServlet.class);

	/**
	 * Updates a site
	 */
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		ResourceResolver resolver = request.getResourceResolver();

		String id = request.getParameter("id");
		final String name = request.getParameter("name");
		final String description = request.getParameter("description");

		if (StringUtils.isEmpty(id)) {
			id = name.toLowerCase().replaceAll("[^a-z\\d]", "-");
		}

		Resource site = resolver.getResource("/content/" + id);
		Resource contentRoot = resolver.getResource("/content");
		try {
			if (site == null) {
				log.debug("Creating site {}", id);
				Map<String, Object> siteProperties = new HashMap<String, Object>();
				siteProperties.put(JcrConstants.JCR_PRIMARYTYPE, CMSConstants.NODE_TYPE_SITE);
				siteProperties.put(Site.PN_NAME, name);
				siteProperties.put(Site.PN_DESCRIPTION, description);
				siteProperties.put(Site.PN_NAME, name);
				siteProperties.put(Site.PN_DESCRIPTION, description);
				Resource siteResource = resolver.create(contentRoot, id, siteProperties);

				Map<String, Object> siteConfigProperties = new HashMap<String, Object>();
				siteProperties.put(JcrConstants.JCR_PRIMARYTYPE, JcrConstants.NT_UNSTRUCTURED);
				resolver.create(siteResource, "config", siteConfigProperties);
				
				Map<String, Object> assetsFolderProperties = new HashMap<String, Object>();
				assetsFolderProperties.put(JcrConstants.JCR_PRIMARYTYPE, JcrConstants.NT_UNSTRUCTURED);
				resolver.create(siteResource, "assets", assetsFolderProperties);

				Map<String, Object> clientLibsFolderProperties = new HashMap<String, Object>();
				clientLibsFolderProperties.put(JcrConstants.JCR_PRIMARYTYPE, JcrConstants.NT_UNSTRUCTURED);
				resolver.create(siteResource, "clientlibs", clientLibsFolderProperties);

				RedirectAttribute.setMessage(request, LEVEL.success, "Site updated successfully!");
			} else {
				log.debug("Updating site {}", id);

				ModifiableValueMap siteProperties = site.adaptTo(ModifiableValueMap.class);
				siteProperties.put(Site.PN_NAME, name);
				siteProperties.put(Site.PN_DESCRIPTION, description);

				RedirectAttribute.setMessage(request, LEVEL.success, "Site created successfully!");
			}
			resolver.commit();
			resolver.close();

			response.sendRedirect(CMSConstants.ADMIN_SITES_PATH + ".html");
		} catch (PersistenceException e) {
			RedirectAttribute.setMessage(request, LEVEL.danger, "Failed to update site!");
			log.error("Could not edit site", e);
			response.sendRedirect(request.getHeader("referer"));
		}
	}
}