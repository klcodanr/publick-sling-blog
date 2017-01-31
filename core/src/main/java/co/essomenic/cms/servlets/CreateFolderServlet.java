package co.essomenic.cms.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.jackrabbit.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.jcr.resource.JcrResourceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.essomenic.cms.CMSConstants;
import co.essomenic.cms.api.models.RedirectAttribute;
import co.essomenic.cms.api.models.RedirectAttribute.LEVEL;

/**
 * Servlet for creating a folder
 * 
 * @author danklco
 */
@SlingServlet(paths = CMSConstants.SERVLET_PATH_ADMIN + "/foldercreate")
public class CreateFolderServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = -5528294838383339934L;

	/**
	 * The logger.
	 */
	private static final Logger log = LoggerFactory.getLogger(CreateFolderServlet.class);

	/**
	 * Creates a folder
	 */
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		ResourceResolver resolver = request.getResourceResolver();

		final String path = request.getParameter("path");
		final String name = request.getParameter("name");
		final String returnUrl = request.getParameter("return");

		Resource parent = resolver.getResource(path);
		try {
			if (parent != null) {
				log.debug("Creating folder {} under {}", name, parent);

				Map<String, Object> folderProperties = new HashMap<String, Object>();
				folderProperties.put(JcrConstants.JCR_PRIMARYTYPE, JcrResourceConstants.NT_SLING_ORDERED_FOLDER);
				resolver.create(parent, name, folderProperties);

				RedirectAttribute.setMessage(request, LEVEL.success, "Folder created successfully!");
			} else {

				RedirectAttribute.setMessage(request, LEVEL.warning,
						"Failed to create folder, parent folder does not exist!");
			}
			resolver.commit();
			resolver.close();

			if (returnUrl.startsWith(CMSConstants.ADMIN_PATH)) {
				response.sendRedirect(returnUrl);
			} else {
				response.sendRedirect(CMSConstants.ADMIN_PATH + ".html");
			}
		} catch (PersistenceException e) {
			RedirectAttribute.setMessage(request, LEVEL.danger, "Failed to create folder, unexpected exception!");
			log.error("Could not create folder", e);
			response.sendRedirect(request.getHeader("referer"));
		}
	}
}