package com.nateyolles.sling.publick.components.foundation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.script.Bindings;

import org.apache.commons.lang.StringUtils;
import org.apache.jackrabbit.JcrConstants;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.scripting.sightly.pojo.Use;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.essomenic.cms.CMSConstants;

/**
 * Backing for Sightly CommentsView component. Returns collection of comments
 * two levels deep. Each comment has an author, comment, and display date.
 */
public class CommentsView implements Use {

    /**
     * Logger to log errors.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentsView.class);

    /**
     * Date format for comments.
     */
    private static final String DISPLAY_DATE_FORMAT = "MMMM dd, yyyy 'at' hh:mm a";

    /**
     * Resource Resolver to get resources.
     */
    private ResourceResolver resolver;

    /**
     * The current blog post resource.
     */
    private Resource blogResource;

    /**
     * The collection of comments.
     */
    private List<HashMap<String, Object>> comments;

    /**
     * The number of comments
     */
    private int count = 0;

    /**
     * Initialize the Sightly component.
     *
     * Get the resource and resolver. The entry point to the component.
     *
     * @param bindings The current execution context.
     */
    @Override
    public void init(Bindings bindings) {
        blogResource = (Resource)bindings.get(SlingBindings.RESOURCE);
        resolver = blogResource.getResourceResolver();

        Resource commentsResource = resolver.getResource(blogResource.getPath().replace(CMSConstants.BLOG_PATH, CMSConstants.COMMENTS_PATH));
        comments = getCommentList(commentsResource, true);
    }

    /**
     * Create the comment list by getting the passed in resource's children and collecting
     * their author, comment, and jcr:created properties. Replies are a recursive call to
     * this methods with the children of the resource passed in resource.
     *
     * @param resource The root comments resource or the first level comment.
     * @param getReplies True to get the next level of comments.
     * @return The collection of comments.
     */
    private List<HashMap<String, Object>> getCommentList(Resource resource, boolean getReplies) {
        List<HashMap<String, Object>> comments = new ArrayList<HashMap<String, Object>>();

        if (resource != null && resource.hasChildren()) {
            Iterator<Resource> iterator = resource.listChildren();

            while (iterator.hasNext()) {
                count++;

                Resource commentResource = iterator.next();
                ValueMap properties = commentResource.adaptTo(ValueMap.class);
                HashMap<String, Object> commentProperties = new HashMap<String, Object>();

                String author = properties.get("author", String.class);
                String comment = properties.get("comment", String.class);
                String date = getDate(properties.get(JcrConstants.JCR_CREATED, Date.class), DISPLAY_DATE_FORMAT);

                if (StringUtils.isNotBlank(author) && StringUtils.isNotBlank(comment) && StringUtils.isNotBlank(date)) {
                    commentProperties.put("author", author);
                    commentProperties.put("comment", comment);
                    commentProperties.put("date", date);
                    commentProperties.put("path", commentResource.getPath());
                    if (getReplies) {
                        commentProperties.put("replies", getCommentList(commentResource, false));
                    }
                    comments.add(commentProperties);
                }
            }
        }

        return comments;
    }

    /**
     * Format date in selected format.
     *
     * @param date The date.
     * @param format The format.
     * @return The formatted date.
     */
    private String getDate(final Date date, final String format) {
        String formattedDate = null;

        if (date != null) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
            formattedDate = dateFormatter.format(date);
        }

        return formattedDate;
    }

    /**
     * Get the comments list.
     *
     * @return The comment list.
     */
    public List<HashMap<String, Object>> getComments() {
        return comments;
    }

    /**
     * Get the number of comments.
     *
     * @return The number of comments.
     */
    public int getCount() {
        return count;
    }
}