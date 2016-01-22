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
 * @author	������
 * @date	2015-10-17
 * @tip		member Controller
 * <pre>
 * -------- �����̷� ----------
 * ������	:	������
 * ��������	:	2015-10-17
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
@Controller
public class AuthorityCon {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	// �ý��� ���� ����
	@Resource(name="SystemService")
	private SystemSvc systemService;
	// ���� ���� ����
	@Resource(name="AuthorityService")
	private AuthoritySvc authorityService;
	
	/**
	 * ���Ѱ��� ȭ��
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/authorityManager.do")
	public ModelAndView authorityManager(@RequestParam HashMap<String,String> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		String eventType = paramMap.get("eventType");
		
		// ó��
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
		
		// ���� ����Ʈ ����
		//ArrayList<HashMap<String,String>> authorityList = authorityService.selectAuthorityList("authority.selectAuthorityList", paramMap);
		
		// select box ����
		List<SystemVo> searchMap = systemService.list("system.selectList", "asearch");
		mv.addObject("search", Function.sysOption(searchMap, paramMap.get("search")));
		
		// ȭ��� ������ ����
		//mv.addObject("authorityList", authorityList);
		mv.addObject("idx", paramMap.get("idx"));
		mv.addObject("searchString", paramMap.get("searchString"));
		mv.setViewName("/manager/authorityManager");
		return mv;
	}
	
	
	
}
