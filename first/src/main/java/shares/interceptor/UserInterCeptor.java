package shares.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 
 * @author	강정권
 * @date	2016-02-27
 * @tip		유저접근 인터페이스
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2016-02-27
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public class UserInterCeptor extends HandlerInterceptorAdapter {
	// 로거
	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		// 세션 확인 후 미로그인시 로그인페이지로 이동
		if(session.getAttribute("userId") == null || session.getAttribute("userId") == "" )
		{
			
			response.sendRedirect("/login.do");
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
}
