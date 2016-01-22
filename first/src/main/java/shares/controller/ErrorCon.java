package shares.controller;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @author	강정권
 * @date	2015-11-07
 * @tip		에러 Controller
 * <pre>
 * -------- 수정이력 ----------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-23
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Controller
public class ErrorCon {
	// 로거
	Logger log = Logger.getLogger(this.getClass());
	
	
	/**
	 * 404 에러 페이지
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/error/404.do")
	public ModelAndView error404(HttpServletRequest request, ModelAndView mv ) throws Exception
	{
		System.out.println("경로 이탈");
		mv.setViewName("/error/404");
		return mv;
	}
	
	
	/**
	 * 500 에러 페이지
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/error/500.do")
	public ModelAndView error500(HttpServletRequest request, ModelAndView mv) throws Exception
	{
		System.out.println("내부오류 개발자 멍청이");
		mv.setViewName("/error/500");
		return mv;
	}
	
	
	/**
	 * 405 에러 페이지
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/error/405.do")
	public ModelAndView error405(HttpServletRequest request, ModelAndView mv) throws Exception
	{
		System.out.println("불법접근");
		mv.setViewName("/error/405");
		return mv;
	}
}
