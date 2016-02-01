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
 * @author	강정권
 * @date	2015-11-11
 * @tip		부서관리 Controller
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
public class BranchCon {
	// 로그
	Logger log = Logger.getLogger(this.getClass());
	
	// DAO 연결
	@Resource(name="BranchSvc")
	private BranchSvc branchSvc;
	
	
	/**
	 * 부서관리 화면
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
