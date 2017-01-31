package co.essomenic.cms;

/**
 * Constants used throughout the application.
 */
public class CMSConstants {

    /**
     * Private constructor to prevent instantiation of class.
     */
    private CMSConstants() {
    }

    /**
     * JCR root path.
     */
    public static final String ROOT_PATH = "/";

    /**
     * Content path.
     */
    public static final String CONTENT_PATH = "/content";

    /**
     * Blog path.
     */
    public static final String BLOG_PATH = CONTENT_PATH + "/blog";

    /**
     * Comments path.
     */
    public static final String COMMENTS_PATH = CONTENT_PATH + "/comments";

    /**
     * Admin path.
     */
    public static final String ADMIN_PATH = "/admin";
    

    /**
     * Admin path.
     */
    public static final String ADMIN_SITES_PATH = ADMIN_PATH + "/sites";

    /**
     * Assets path.
     */
    public static final String ASSET_PATH = CONTENT_PATH + "/assets";

    /**
     * Images path.
     */
    public static final String IMAGE_PATH = ASSET_PATH + "/images";

    /**
     * PDF path.
     */
    public static final String PDF_PATH = ASSET_PATH + "/pdf";

    /**
     * Audio path.
     */
    public static final String AUDIO_PATH = ASSET_PATH + "/audio";

    /**
     * Video path.
     */
    public static final String VIDEO_PATH = ASSET_PATH + "/video";

    /**
     * Admin dashboard path.
     */
    public static final String ADMIN_LANDING_PATH = ADMIN_PATH + "/index";

    /**
     * Admin blog list path.
     */
    public static final String ADMIN_LIST_PATH = ADMIN_PATH + "/list";

    /**
     * Admin edit blog path;
     */
    public static final String ADMIN_EDIT_PATH = ADMIN_PATH + "/edit";

    /**
     * Admin assets blog path.
     */
    public static final String ADMIN_ASSETS_PATH = ADMIN_PATH + "/assets";

    /**
     * Admin config path.
     */
    public static final String ADMIN_CONFIG_PATH = ADMIN_PATH + "/config";

    /**
     * Admin reCAPTCHA config path.
     */
    public static final String RECAPTCHA_CONFIG_PATH = ADMIN_CONFIG_PATH + "/recaptcha";

    /**
     * Admin system config path.
     */
    public static final String SYSTEM_CONFIG_PATH = ADMIN_CONFIG_PATH + "/system";

    /**
     * Admin email config path.
     */
    public static final String EMAIL_CONFIG_PATH = ADMIN_CONFIG_PATH + "/email";

    /**
     * Node type base.
     */
    private static final String NODE_TYPE = "cms";
    

    /**
     * Site node type.
     */
    public static final String NODE_TYPE_SITE = NODE_TYPE + ":site";

    /**
     * Page node type.
     */
    public static final String NODE_TYPE_PAGE = NODE_TYPE + ":page";

    /**
     * Template node type.
     */
    public static final String NODE_TYPE_TEMPLATE = NODE_TYPE + ":template";

    /**
     * Component node type.
     */
    public static final String NODE_TYPE_COMPONENT = NODE_TYPE + ":component";

    /**
     * Comment node type.
     */
    public static final String NODE_TYPE_COMMENT = NODE_TYPE + ":comment";

    /**
     * Page base resource type.
     */
    private static final String PAGE_TYPE = "cms/pages";

    /**
     * Admin page resource type.
     */
    public static final String PAGE_TYPE_ADMIN = PAGE_TYPE + "/adminPage";

    /**
     * Basic page resource type.
     */
    public static final String PAGE_TYPE_BASIC = PAGE_TYPE + "/basicPage";

    /**
     * Blog page resource type.
     */
    public static final String PAGE_TYPE_BLOG = PAGE_TYPE + "/blogPage";

    /**
     * Config settings path.
     */
    public static final String CONFIG_PATH = "/etc/config";

    /**
     * reCAPTCHA config settings path.
     */
    public static final String CONFIG_RECAPTCHA_PATH = CONFIG_PATH + "/recaptcha";

    /**
     * System config settings path.
     */
    public static final String CONFIG_SYSTEM_PATH = CONFIG_PATH + "/system";

    /**
     * Email config settings path.
     */
    public static final String CONFIG_EMAIL_PATH =  CONFIG_PATH + "/email";

    /**
     * Authors group name.
     */
    public static final String GROUP_ID_AUTHORS = "authors";

    /**
     * Testers group name.
     */
    public static final String GROUP_ID_TESTERS = "testers";

    /**
     * Authors group display name.
     */
    public static final String GROUP_DISPLAY_AUTHORS = "Authors";

    /**
     * Testers group display name.
     */
    public static final String GROUP_DISPLAY_TESTERS = "Testers";

    /**
     * Servlet admin path
     */
    public static final String SERVLET_PATH_ADMIN = "/admin/bin";

    /**
     * Servlet public path
     */
    public static final String SERVLET_PATH_PUBLIC = "/bin/publick";
}