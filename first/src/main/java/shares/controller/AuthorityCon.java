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
 * @author	������
 * @date	2015-10-17
 * @tip		member Controller
 * <pre>
 * -------- �����̷� --------------
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
	@Resource(name="SystemSvc")
	private SystemSvc systemService;
	
	// ���� ���� ����
	@Resource(name="AuthoritySvc")
	private AuthoritySvc authorityService;
	
	
	/**
	 * ���� : ���Ѱ��� ȭ��
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
