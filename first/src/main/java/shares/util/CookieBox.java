package shares.util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;

import org.apache.log4j.Logger;

import java.util.Map;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
/**
 * 
 * @author	������
 * @date	2015-10-19
 * @tip		��Ű class
 * <pre>
 * -------- �����̷� ----------
 * ������	:	������
 * ��������	:	2015-10-19
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public class CookieBox {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	
	private Map<String, Cookie> cookieMap = new java.util.HashMap<String, Cookie>();
	
	public CookieBox(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0 ; i < cookies.length ; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}
	
	
	public static Cookie createCookie(String name, String value) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "euc-kr"));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24*365);
		return cookie;
	}
	
	public Cookie getCookie(String name) {
		return (Cookie)cookieMap.get(name);
	}
	
	public String getValue(String name) throws IOException {
		Cookie cookie = (Cookie)cookieMap.get(name);
		if (cookie == null) return null;
		return URLDecoder.decode(cookie.getValue(), "euc-kr");
	}
}