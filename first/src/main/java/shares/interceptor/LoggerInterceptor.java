package shares.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import shares.interceptor.LoggerInterceptor;


/**
 * 
 * @author	������
 * @date	2015-10-17
 * @tip		log ���� ���ͼ���
 * <pre>
 * -------- �����̷� ----------
 * ������	:	������
 * ��������	:	2015-10-17
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public class LoggerInterceptor extends HandlerInterceptorAdapter {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
		
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("======================================          START         ======================================");
			log.debug(" Request URI \t: " + request.getRequestURI());
			log.debug(" Request name \t: " + request.getLocalName());
			log.debug(" Request IP \t: " + request.getRemoteAddr());
		}
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("======================================           END          ======================================\n");
		}
	}
}