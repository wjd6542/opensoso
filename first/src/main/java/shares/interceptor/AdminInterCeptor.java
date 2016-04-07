package shares.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 
 * @author	������
 * @date	2016-02-27
 * @tip		������ ���� �������̽�
 * <pre>
 * -------- �����̷� ----------
 * ������	:	������
 * ��������	:	2016-02-27
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public class AdminInterCeptor extends HandlerInterceptorAdapter {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		String accessId = (String) session.getAttribute("userId");
		// ���� Ȯ�� �� �̷α��ν� �α����������� �̵�
		if(accessId == null || !accessId.equals("admin") )
		{
			response.sendRedirect("/index.do");
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
}
