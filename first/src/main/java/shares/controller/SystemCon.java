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
import shares.vo.SystemTableVo;
import shares.vo.SystemVo;

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
public class SystemCon {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	// �ý��� ���� ����
	@Resource(name="SystemService")
	private SystemSvc systemService;
	
	
	/**
	 * ���� : ���̺� ����
	 * @param vo
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/tableManager.do")
	public ModelAndView tableManager(SystemTableVo vo , ModelAndView mv) throws Exception{
		List<SystemTableVo> tableList = systemService.list("systemTable.tableList", vo);
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
		List<SystemVo> codeList = systemService.list("systemCode.list", system);
		// �Һз� �˻� ������
		List<SystemVo> valueList = null;
		// ���� ��з� �˻� �ڵ尡 �ִ°��
		if(system.getSystemCode() != null)
			valueList = systemService.list("systemValue.list", system);
		
		// select box ����
		//List<SystemVo> psmaps = systemService.list("systemValue.codeList", "systemCode");
		//List<SystemVo> csmap = systemService.list("systemValue.codeList", "ccode");
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
			systemService.insert("systemCode.codeInsert", system);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "���� ����!");
		}
		else if("codeUpdate".equals(system.getActionType()))
		{
			systemService.update("systemCode.update", system);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "���� ����!");
		}
		else if("valueInsert".equals(system.getActionType()))
		{
			systemService.insert("systemValue.insert", system);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "���� ����!");
		}
		else if("codeUpdate".equals(system.getActionType()))
		{
			systemService.update("systemValue.update", system);
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
			sqlId = "systemCode.codeCheck";
		else
			sqlId = "systemValue.codeCheck";
		
		String result = systemService.check(sqlId, system.getCode());
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
			sqlId = "systemCode.delete";
		else
			sqlId = "systemValue.delete";
		try{
			systemService.delete(sqlId, system);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "�ڵ尡 �����Ǿ����ϴ�.");
		}catch(Exception e){
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "�ڵ������ ���� �Ͽ����ϴ�.");
		}
		return mv;
	}
}
