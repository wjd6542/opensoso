package shares.controller;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shares.service.AuthoritySvc;
import shares.service.SystemSvc;


/**
 * 
 * @author	강정권
 * @date	2015-10-17
 * @tip		member Controller
 * <pre>
 * -------- 수정이력 --------------
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
	@Resource(name="SystemSvc")
	private SystemSvc systemService;
	
	// 권한 서비스 연결
	@Resource(name="AuthoritySvc")
	private AuthoritySvc authorityService;
	
	
	/**
	 * 설명 : 권한관리 화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/authorityManager.do")
	public ModelAndView authorityManager(@RequestParam HashMap<String,String> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		
		mv.setViewName("/admin/authorityManager");
		return mv;
	}
	
	
	
}
