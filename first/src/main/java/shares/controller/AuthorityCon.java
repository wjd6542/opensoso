package shares.controller;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shares.service.AuthoritySvc;
import shares.service.SystemSvc;
import shares.util.Function;
import shares.vo.SystemVo;

/**
 * 
 * @author	강정권
 * @date	2015-10-17
 * @tip		member Controller
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
public class AuthorityCon {
	// 로거
	Logger log = Logger.getLogger(this.getClass());
	// 시스템 서비스 연결
	@Resource(name="SystemService")
	private SystemSvc systemService;
	// 권한 서비스 연결
	@Resource(name="AuthorityService")
	private AuthoritySvc authorityService;
	
	/**
	 * 권한관리 화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/authorityManager.do")
	public ModelAndView authorityManager(@RequestParam HashMap<String,String> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		String eventType = paramMap.get("eventType");
		
		// 처리
		if("Insert".equals(eventType))
		{
			authorityService.authorityInsert("insertAuthority", paramMap);
		}
		else if("Update".equals(eventType))
		{
			authorityService.authorityUpdate("updateAuthority", paramMap);
		}
		else
		{
			authorityService.authorityDelete("deleteAuthority", paramMap);
		}
		
		// 권한 리스트 생성
		//ArrayList<HashMap<String,String>> authorityList = authorityService.selectAuthorityList("authority.selectAuthorityList", paramMap);
		
		// select box 생성
		List<SystemVo> searchMap = systemService.list("system.selectList", "asearch");
		mv.addObject("search", Function.sysOption(searchMap, paramMap.get("search")));
		
		// 화면단 데이터 생성
		//mv.addObject("authorityList", authorityList);
		mv.addObject("idx", paramMap.get("idx"));
		mv.addObject("searchString", paramMap.get("searchString"));
		mv.setViewName("/manager/authorityManager");
		return mv;
	}
	
	
	
}
