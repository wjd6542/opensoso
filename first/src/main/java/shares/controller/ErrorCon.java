package shares.controller;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @author	������
 * @date	2015-11-07
 * @tip		���� Controller
 * <pre>
 * -------- �����̷� ----------
 * ������	:	������
 * ��������	:	2015-11-23
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
@Controller
public class ErrorCon {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	
	
	/**
	 * 404 ���� ������
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/error/404.do")
	public ModelAndView error404(HttpServletRequest request, ModelAndView mv ) throws Exception
	{
		System.out.println("��� ��Ż");
		mv.setViewName("/error/404");
		return mv;
	}
	
	
	/**
	 * 500 ���� ������
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/error/500.do")
	public ModelAndView error500(HttpServletRequest request, ModelAndView mv) throws Exception
	{
		System.out.println("���ο��� ������ ��û��");
		mv.setViewName("/error/500");
		return mv;
	}
	
	
	/**
	 * 405 ���� ������
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/error/405.do")
	public ModelAndView error405(HttpServletRequest request, ModelAndView mv) throws Exception
	{
		System.out.println("�ҹ�����");
		mv.setViewName("/error/405");
		return mv;
	}
}
