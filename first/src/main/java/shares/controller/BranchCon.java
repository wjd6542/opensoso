package shares.controller;
import java.util.HashMap;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shares.service.BranchSvc;

/**
 * 
 * @author	������
 * @date	2015-11-11
 * @tip		�μ����� Controller
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
public class BranchCon {
	// �α�
	Logger log = Logger.getLogger(this.getClass());
	
	// DAO ����
	@Resource(name="BranchSvc")
	private BranchSvc branchSvc;
	
	
	/**
	 * �μ����� ȭ��
	 * @param paramMap
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/baranchManager.do")
	public ModelAndView baranchManager(@RequestParam HashMap<String, String> paramMap, ModelAndView mv) throws Exception{
		//ArrayList<HashMap<String,String>> baranchList = branchService.selectBranchList("branch.selectBranchList", paramMap);
		//mv.addObject("baranchList", baranchList);
		mv.setViewName("/manager/baranchManager");
		return mv;
	}
}
