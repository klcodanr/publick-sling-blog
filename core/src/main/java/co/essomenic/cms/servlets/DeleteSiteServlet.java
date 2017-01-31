/*
 * Copyright 2017 - Essomenic Systems
 * All Rights Reserved
 */
package co.essomenic.cms.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.essomenic.cms.CMSConstants;
import co.essomenic.cms.api.models.RedirectAttribute;
import co.essomenic.cms.api.models.RedirectAttribute.LEVEL;

/**
 * Servlet for deleting sites
 * 
 * @author danklco
 */
@SlingServlet(paths = CMSConstants.SERVLET_PATH_ADMIN + "/deletesite")
public class DeleteSiteServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = -3692808908468376557L;
	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(DeleteSiteServlet.class);

	/**
	 * Deletes a site
	 */
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		ResourceResolver resolver = request.getResourceResolver();

		final String path = request.getParameter("path");
		Resource site = resolver.getResource(path);
		try {
			if (site != null) {
				resolver.delete(site);
			} else {
				LOGGER.warn("Attempting to delete non-existant site " + path);
			}
			resolver.commit();
			resolver.close();

			RedirectAttribute.setMessage(request, LEVEL.success, "Site deleted successfully!");
			response.sendRedirect(CMSConstants.ADMIN_SITES_PATH + ".html");
		} catch (PersistenceException e) {
			RedirectAttribute.setMessage(request, LEVEL.danger, "Failed to delete site!");
			LOGGER.error("Could not delete site", e);
			response.sendRedirect(request.getHeader("referer"));
		} finally {
			if (resolver != null && resolver.isLive()) {
				resolver.close();
				resolver = null;
			}
		}
	}
}