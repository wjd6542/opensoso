package shares.controller;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shares.service.SystemSvc;
import shares.service.UserSvc;
import shares.util.Function;
import shares.util.Paging;
import shares.vo.SystemVo;
import shares.vo.UserVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-07
 * @tip		member Controller
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-07
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Controller
public class ManagerCon {
	// 로거
	Logger log = Logger.getLogger(this.getClass());
	// 페이징
	Paging paging = new Paging();
	// 시스템 서비스 연결
	@Resource(name="SystemService")
	private SystemSvc systemService;
	// 유저 정보 서비스 연결
	@Resource(name="UserService")
	private UserSvc userService;
	
	
	/**
	 * 유저 정보 확인 화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userManager.do")
	public ModelAndView userManager(
		@RequestParam HashMap<String,String> paramMap,
		@RequestParam(value="pageNo", defaultValue = "0") int pageNo,
		@RequestParam(value="pageSize", defaultValue = "10") int pageSize,
		ModelAndView mv) throws Exception
	{
		
		System.out.println(paramMap.toString());
		
		// 페이징 처리
		int totalcnt = userService.userTotalcnt("user.userTotalcnt");
		paramMap = paging.pagegingsetting(pageNo, pageSize, totalcnt, paramMap);
		
		List<UserVo> userList = userService.selectUserList("user.selectUserList", paramMap);
		
		List<SystemVo> serchMap = systemService.list("systemValue.codeList", "userSerch");
		
		
		// 화면단 데이터 생성
		mv.addObject("search",  Function.sysOption(serchMap, ""));
		mv.addObject("pageNo",pageNo);
		mv.addObject("pageSize",pageSize);
		mv.addObject("paging",paging);
		mv.addObject("userList", userList);
		mv.setViewName("/manager/userManager");
		return mv;
	}
	
	
	/**
	 * 접근관리 화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/accessManager.do")
	public ModelAndView accessManager(@RequestParam HashMap<String,Object> paramMap, ModelAndView mv) throws Exception
	{
		mv.setViewName("/manager/accessManager");
		return mv;
	}
	
}
