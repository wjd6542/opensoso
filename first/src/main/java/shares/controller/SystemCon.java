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
import shares.var.Var;
import shares.vo.SystemTableVo;
import shares.vo.SystemVo;

/**
 * 
 * @author	������
 * @date	2015-11-07
 * @tip		system Controller
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
public class SystemCon {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	// �ý��� ���� ����
	@Resource(name="SystemSvc")
	private SystemSvc systemSvc;
	
	
	/**
	 * ���� : ���̺� ����
	 * @param vo
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/tableManager.do")
	public ModelAndView tableManager(SystemTableVo vo , ModelAndView mv) throws Exception{
		List<SystemTableVo> tableList = systemSvc.list(Var.sysTableList, vo);
		mv.addObject("tableList", tableList);
		mv.setViewName("manager/system/tableManager");
		return mv;
	}
	
	
	/**
	 * ���� : �ý��� �ڵ� ���� ȭ��
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/codeManager.do")
	public ModelAndView codeManager(SystemVo system, ModelAndView mv) throws Exception{
		
		// ��з� �˻� ������
		List<SystemVo> codeList = systemSvc.list(Var.sysCodeList, system);
		// �Һз� �˻� ������
		List<SystemVo> valueList = null;
		// ���� ��з� �˻� �ڵ尡 �ִ°��
		if(system.getSystemCode() != null)
			valueList = systemSvc.list(Var.sysValueList, system);
		
		// select box ����
		//List<SystemVo> psmaps = systemSvc.list("systemValue.codeList", "systemCode");
		//List<SystemVo> csmap = systemSvc.list("systemValue.codeList", "ccode");
		//mv.addObject("pSearch", Function.sysOption(psmaps, system.getSerchType()));
		//mv.addObject("cSearch", Function.sysOption(csmap, system.getSerchType()));
		//mv.addObject("pString", system.getSerchString());
		//mv.addObject("cString", system.getSerchString());
		
		// ȭ��� ������ ����
		mv.addObject("codeNo", system.getNo());
		mv.addObject("systemCode", system.getSystemCode());
		mv.addObject("codeList", codeList);
		mv.addObject("valueList", valueList);
		mv.setViewName("/manager/system/codeManager");
		return mv;
	}
	
	
	/**
	 * ���� : �ڵ� ����
	 * @param paramMap
	 * @param system
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/systemAction.do")
	public ModelAndView systemAction(@RequestParam HashMap<String,String> paramMap, SystemVo system) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String actionType =  system.getActionType();
		if("codeInsert".equals(actionType))
		{
			systemSvc.insert(Var.sysCodeInsert, system);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "���� ����!");
		}
		else if("codeUpdate".equals(system.getActionType()))
		{
			systemSvc.update(Var.sysCodeUpdate, system);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "���� ����!");
		}
		else if("valueInsert".equals(system.getActionType()))
		{
			systemSvc.insert(Var.sysValueInsert, system);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "���� ����!");
		}
		else if("codeUpdate".equals(system.getActionType()))
		{
			systemSvc.update(Var.sysValueUpdate, system);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "���� ����!");
		}
		return mv;
	}
	
	
	/**
	 * ���� : �ߺ� Ȯ�� Action
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/overlapCheck.do")
	public ModelAndView overlapCheck(SystemVo system) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		String sqlId = "";
		
		if("code".equals(system.getActionType()))
			sqlId = Var.sysCodeCheck;
		else
			sqlId = Var.sysValueCheck;
		
		String result = systemSvc.check(sqlId, system.getCode());
		if(result == null || result == "")
		{
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "��밡���� �ڵ� �Դϴ�.");
		}
		else
		{
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "�̹� ��ϵ� �ڵ� �Դϴ�.");
		}
		return mv;
	}
	
	
	/**
	 * ���� : �ڵ� ����
	 * @param system
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteCode.do")
	public ModelAndView deleteCode(SystemVo system) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		String sqlId = "";
		if("codeDelete".equals(system.getActionType()))
			sqlId = Var.sysCodeDelete;
		else
			sqlId = Var.sysValueDelete;
		try{
			systemSvc.delete(sqlId, system);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "�ڵ尡 �����Ǿ����ϴ�.");
		}catch(Exception e){
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "�ڵ������ ���� �Ͽ����ϴ�.");
		}
		return mv;
	}
}
