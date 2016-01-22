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
 * @author	������
 * @date	2015-11-07
 * @tip		member Controller
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-07
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
@Controller
public class ManagerCon {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	// ����¡
	Paging paging = new Paging();
	// �ý��� ���� ����
	@Resource(name="SystemService")
	private SystemSvc systemService;
	// ���� ���� ���� ����
	@Resource(name="UserService")
	private UserSvc userService;
	
	
	/**
	 * ���� ���� Ȯ�� ȭ��
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
		
		// ����¡ ó��
		int totalcnt = userService.userTotalcnt("user.userTotalcnt");
		paramMap = paging.pagegingsetting(pageNo, pageSize, totalcnt, paramMap);
		
		List<UserVo> userList = userService.selectUserList("user.selectUserList", paramMap);
		
		List<SystemVo> serchMap = systemService.list("systemValue.codeList", "userSerch");
		
		
		// ȭ��� ������ ����
		mv.addObject("search",  Function.sysOption(serchMap, ""));
		mv.addObject("pageNo",pageNo);
		mv.addObject("pageSize",pageSize);
		mv.addObject("paging",paging);
		mv.addObject("userList", userList);
		mv.setViewName("/manager/userManager");
		return mv;
	}
	
	
	/**
	 * ���ٰ��� ȭ��
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
