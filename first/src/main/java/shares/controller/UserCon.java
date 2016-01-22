package shares.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shares.service.SystemSvc;
import shares.service.UserSvc;
import shares.util.Function;
import shares.util.SearchTest;
import shares.vo.SystemVo;
import shares.vo.UserVo;

/**
 * 
 * @author	강정권
 * @date	2015-10-17
 * @tip		user Controller
 * <pre>
 * -------- 수정이력 ----------
 * 수정자	:	강정권
 * 수정일자	:	2015-10-17
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Controller
public class UserCon {
	// 로거
	Logger logs = Logger.getLogger(this.getClass());
	
	
	// 유저 서비스 연결
	@Resource(name="UserService")
	private UserSvc userService;
	
	// 시스템 서비스 연결
	@Resource(name="SystemService")
	private SystemSvc systemService;
	
	/**
	 * 메인화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/index.do")
	public ModelAndView main(@RequestParam HashMap<String,String> paramMap, ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception{
		SearchTest.setUp(request, response);
		mv.setViewName("/index");
		return mv;
	}
	
	/**
	 * 로그인화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login.do")
	public ModelAndView login(@RequestParam Map<String,Object> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		mv.setViewName("/user/login");
		return mv;
	}
	
	/**
	 * 로그인 Action
	 * @param paramMap
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/loginAction.do")
	public ModelAndView loginAction(UserVo vo) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			UserVo member = userService.selectUser("user.selectUser", vo);
			if(member == null)
			{
				mv.addObject("code", "FAIL");
				mv.addObject("msg", "계정 정보를 확인해 주세요.");
			}
			else
			{
				// 세션 등록
				mv.addObject("code", "SUCC");
				mv.addObject("member", member);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * ID/PW 찾기 화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/idpwSearch.do" )
	public ModelAndView idpwSearch(@RequestParam HashMap<String, String> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		mv.setViewName("/user/idpwSearch");
		return mv;
	}
	
	/**
	 * 약관동의 화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/consent.do")
	public ModelAndView consent(@RequestParam HashMap<String, String> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		mv.setViewName("/user/consent");
		return mv;
	}
	
	
	/**
	 * 회원가입 화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/join.do")
	public ModelAndView join(@RequestParam HashMap<String, String> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		
		List<SystemVo> sexMap = systemService.list("systemValue.codeList", "gender");
		List<SystemVo> emailMap = systemService.list("systemValue.codeList", "email");
		// select box 생성
		mv.addObject("gender",  Function.sysOption(sexMap, ""));
		mv.addObject("emails",  Function.sysOption(emailMap, ""));
		
		mv.setViewName("/user/join");
		return mv;
	}
	
	/**
	 * 회원가입 Action
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userInsert.do")
	public ModelAndView userInsert(@RequestParam HashMap<String, String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			userService.userInsert("user.insertUser", paramMap);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "회원가입되었습니다.");
		}catch(Exception e){
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "회원 등록에 실패하였습니다.");
			System.out.println(e);
		}
		return mv;
	}
	
	

	
}
