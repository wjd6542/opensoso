package shares.controller;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shares.service.AccessSvc;
import shares.var.Var;

/**
 * 
 * @author	강정권
 * @date	2015-11-07
 * @tip		에러 Controller
 * <pre>
 * -------- 수정이력 --------------
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
	
	// 접근관리 서비스 연결
	@Resource(name="AccessSvc")
	private AccessSvc accessSvc;
	
	
	/**
	 * 설명 : 400 에러 페이지
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/error/400.do")
	public ModelAndView error400(HttpServletRequest request, ModelAndView mv ) throws Exception
	{
		HashMap<String, String> map = new HashMap<String, String>();
		try{
			map.put("ip", request.getLocalAddr());
			map.put("type", "400");
			map.put("path", (String)request.getAttribute("javax.servlet.forward.request_uri"));
			accessSvc.accessInsert(Var.accessInsert, map);
		}catch(Exception e){
			e.printStackTrace();
		}
		mv.setViewName("/error/400");
		return mv;
	}
	
	
	/**
	 * 설명 : 404 에러 페이지
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/error/404.do")
	public ModelAndView error404(HttpServletRequest request, ModelAndView mv ) throws Exception
	{
		HashMap<String, String> map = new HashMap<String, String>();
		try{
			map.put("ip", request.getLocalAddr());
			map.put("type", "404");
			map.put("path", (String)request.getAttribute("javax.servlet.forward.request_uri"));
			accessSvc.accessInsert(Var.accessInsert, map);
		}catch(Exception e){
			e.printStackTrace();
		}
		mv.setViewName("/error/404");
		return mv;
	}
	
	
	/**
	 * 설명 : 500 에러 페이지
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/error/500.do")
	public ModelAndView error500(HttpServletRequest request, ModelAndView mv) throws Exception
	{
		HashMap<String, String> map = new HashMap<String, String>();
		try{
			map.put("ip", request.getLocalAddr());
			map.put("type", "500");
			map.put("path", (String)request.getAttribute("javax.servlet.forward.request_uri"));
			accessSvc.accessInsert(Var.accessInsert, map);
		}catch(Exception e){
			e.printStackTrace();
		}
		mv.setViewName("/error/500");
		return mv;
	}
	
	
	/**
	 * 설명 : 405 에러 페이지
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/error/405.do")
	public ModelAndView error405(HttpServletRequest request, ModelAndView mv) throws Exception
	{
		HashMap<String, String> map = new HashMap<String, String>();
		try{
			map.put("ip", request.getLocalAddr());
			map.put("type", "405");
			map.put("path", (String)request.getAttribute("javax.servlet.forward.request_uri"));
			accessSvc.accessInsert(Var.accessInsert, map);
		}catch(Exception e){
			e.printStackTrace();
		}
		mv.setViewName("/error/405");
		return mv;
	}
}
