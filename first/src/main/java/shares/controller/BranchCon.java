package shares.controller;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shares.service.BranchSvc;
import shares.var.Var;
import shares.vo.BranchVo;

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
		List<BranchVo> branchList = branchSvc.list(Var.branchList, paramMap);
		mv.addObject("branchList", branchList);
		mv.setViewName("/admin/baranchManager");
		return mv;
	}
	
	
	/**
	 * 섦명 : 부서정보
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/branchData.do")
	public ModelAndView branchData(@RequestParam HashMap<String, String> paramMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		BranchVo branch = branchSvc.data(Var.branchData, paramMap);
		mv.addObject("branchVo", branch);
		return mv;
	}
	
	
	/**
	 * 섦명 : 부서처리
	 * @param paramMap
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/branchActoin.do")
	public ModelAndView branchActoin(@RequestParam HashMap<String, String> paramMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		String actionType = paramMap.get("actionType");
		String msg = "";
		try{
			switch (actionType)
			{
				case "insert":
					branchSvc.insert(Var.branchInsert, paramMap);
					msg = "부서 가 추가되었습니다.";
					break;
				case "update":
					branchSvc.insert(Var.branchUpdate, paramMap);
					msg = "부서 정보가 수정되었습니다.";
					break;
				default:
					branchSvc.insert(Var.deleteUser, paramMap);
					msg = "부서 정보가 삭제되었습니다.";
					break;
			}
			mv.addObject("code", "SUCC");
			mv.addObject("msg", msg);
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "처리에 실패 하였습니다.");
		}
		return mv;
	}
	
	
	/**
	 * 섦영 : 채번진행
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/branchNum.do")
	public ModelAndView branchNum(@RequestParam HashMap<String, String> paramMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		String depthNo = branchSvc.dataNum(Var.branchNum, paramMap);
		mv.addObject("depthNo", depthNo);
		return mv;
	}

}
