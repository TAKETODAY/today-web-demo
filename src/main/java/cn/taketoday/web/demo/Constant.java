package cn.taketoday.web.demo;

import java.io.Serializable;

/**
 * 
 * @author Today <br>
 *         2018-10-27 10:13
 */
public interface Constant extends Serializable {

	String KEY_CONTEXT_PATH = "contextPath";

	String ADMIN_ARTICLES = "articles";
	String ADMIN_COMMENTS = "comments";
	// font
	String DEFAULT_FONT = "Verdana";

	String USER_IMAGE_PATH = "/user/head";
	// Session
	/** OtherFooterInfo */
	String OTHER_FOOTER_INFO = "OtherFooterInfo";
	String COPYRIGHT = "Copyright";
	/** icp备案号 */
	String ICP = "ICP";
	/** 关键字 */
	String KEYWORDS = "keywords";
	/** 描述 */
	String DESCRIPTION = "description";
	/** 百度统计代码 */
	String BAIDU_CODE = "baiduCode";
	/** https://www.yanghaijian.top */
	String HOST = "host";
	/** CDN */
	String CDN = "CDN";
	/** 网站名称 */
	String SITE_NAME = "siteName";
	/** 服务器启动时间 */
	String START_TIME = "startTime";
	/** 验证码 */
	String RAND_CODE = "randCode";
	/** 登录用户 */
	String USER_INFO = "USER_INFO";
	/** 文章详情页面article Session */
	String ARTICLE = "article";
	/** 上传文件根路径 */
	String UPLOAD_ROOT_PATH = "UPLOAD_ROOT_PATH";

	String SITE_ROOT_PATH = "UPLOAD_ROOT_PATH";

	/** 分页 */
	String PAGINATION = "pagination";

	String FORBIDDEN = "/Forbidden";

	String NotFound = "/NotFound";

	String ServerIsBusy = "/ServerIsBusy";

}
