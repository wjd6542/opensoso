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
 * @author	강정권
 * @date	2015-11-07
 * @tip		system Controller
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
public class SystemCon {
	// 로거
	Logger log = Logger.getLogger(this.getClass());
	// 시스템 서비스 연결
	@Resource(name="SystemSvc")
	private SystemSvc systemSvc;
	
	
	/**
	 * 설명 : 테이블 관리
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
	 * 설명 : 시스템 코드 관리 화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/codeManager.do")
	public ModelAndView codeManager(SystemVo system, ModelAndView mv) throws Exception{
		
		// 대분류 검색 데이터
		List<SystemVo> codeList = systemSvc.list(Var.sysCodeList, system);
		// 소분류 검색 데이터
		List<SystemVo> valueList = null;
		// 만약 대분류 검색 코드가 있는경우
		if(system.getSystemCode() != null)
			valueList = systemSvc.list(Var.sysValueList, system);
		
		// select box 생성
		//List<SystemVo> psmaps = systemSvc.list("systemValue.codeList", "systemCode");
		//List<SystemVo> csmap = systemSvc.list("systemValue.codeList", "ccode");
		//mv.addObject("pSearch", Function.sysOption(psmaps, system.getSerchType()));
		//mv.addObject("cSearch", Function.sysOption(csmap, system.getSerchType()));
		//mv.addObject("pString", system.getSerchString());
		//mv.addObject("cString", system.getSerchString());
		
		// 화면단 데이터 생성
		mv.addObject("codeNo", system.getNo());
		mv.addObject("systemCode", system.getSystemCode());
		mv.addObject("codeList", codeList);
		mv.addObject("valueList", valueList);
		mv.setViewName("/manager/system/codeManager");
		return mv;
	}
	
	
	/**
	 * 설명 : 코드 실행
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
			mv.addObject("msg", "삽입 성공!");
		}
		else if("codeUpdate".equals(system.getActionType()))
		{
			systemSvc.update(Var.sysCodeUpdate, system);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "수정 성공!");
		}
		else if("valueInsert".equals(system.getActionType()))
		{
			systemSvc.insert(Var.sysValueInsert, system);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "삽입 성공!");
		}
		else if("codeUpdate".equals(system.getActionType()))
		{
			systemSvc.update(Var.sysValueUpdate, system);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "수정 성공!");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 중복 확인 Action
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
			mv.addObject("msg", "사용가능한 코드 입니다.");
		}
		else
		{
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "이미 등록된 코드 입니다.");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 코드 삭제
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
			mv.addObject("msg", "코드가 삭제되었습니다.");
		}catch(Exception e){
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "코드삭제에 실패 하였습니다.");
		}
		return mv;
	}
}
