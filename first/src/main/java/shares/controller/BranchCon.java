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
		List<BranchVo> branchList = branchSvc.list(Var.branchList, paramMap);
		mv.addObject("branchList", branchList);
		mv.setViewName("/admin/baranchManager");
		return mv;
	}
	
	
	/**
	 * ���� : �μ�����
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
	 * ���� : �μ�ó��
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
					msg = "�μ� �� �߰��Ǿ����ϴ�.";
					break;
				case "update":
					branchSvc.insert(Var.branchUpdate, paramMap);
					msg = "�μ� ������ �����Ǿ����ϴ�.";
					break;
				default:
					branchSvc.insert(Var.deleteUser, paramMap);
					msg = "�μ� ������ �����Ǿ����ϴ�.";
					break;
			}
			mv.addObject("code", "SUCC");
			mv.addObject("msg", msg);
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "ó���� ���� �Ͽ����ϴ�.");
		}
		return mv;
	}
	
	
	/**
	 * ���� : ä������
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
