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
import shares.service.systemBorderSvc;
import shares.util.Function;
import shares.util.Paging;
import shares.var.Var;
import shares.vo.SystemBorderVo;
import shares.vo.SystemVo;
import shares.vo.UserVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-07
 * @tip		member Controller
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
public class ManagerCon {
	// 로거
	Logger log = Logger.getLogger(this.getClass());
	
	// 페이징
	Paging paging = new Paging();
	
	// 시스템 서비스 연결
	@Resource(name="SystemSvc")
	private SystemSvc systemSvc;
	
	// 유저 정보 서비스 연결
	@Resource(name="UserSvc")
	private UserSvc userSvc;
	
	// 게시판 관리 서비스 연결
	@Resource(name="systemBorderSvc")
	private systemBorderSvc borderSvc;
	
	
	/**
	 * 설명 : 유저 정보 확인 화면
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
		
		// 페이징 처리
		int totalcnt = userSvc.userTotalcnt(Var.userTotalcnt, paramMap);
		paramMap = paging.setting(pageNo, pageSize, totalcnt, paramMap);
		
		List<UserVo> userList = userSvc.selectUserList(Var.selectUserList, paramMap);
		List<SystemVo> serchMap = systemSvc.list(Var.sysValueCodeList, "userSerch");
		List<SystemVo> genderMap = systemSvc.list(Var.sysValueCodeList, "gender");
		List<SystemVo> statusMap = systemSvc.list(Var.sysValueCodeList, "userStatus");
		
		
		for(UserVo userVo : userList){
			userVo.setGender(Function.sysMapping(genderMap, userVo.getGender()));
			userVo.setStatus(Function.sysMapping(statusMap, userVo.getStatus()));
		}
		
		// 화면단 데이터 생성
		mv.addObject("search",  Function.sysOption(serchMap, paramMap.get("search")));
		mv.addObject("gender",  Function.sysOption(genderMap, ""));
		mv.addObject("status",  Function.sysOption(statusMap, ""));
		mv.addObject("searchString", paramMap.get("searchString"));
		
		mv.addObject("pageNo", pageNo);
		mv.addObject("pageSize", pageSize);
		mv.addObject("paging", paging);
		mv.addObject("userList", userList);
		mv.setViewName("/manager/userManager");
		return mv;
	}
	
	/**
	 * 설명 : 고객 관리 고객정보 검색
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userData.do")
	public ModelAndView userData(@RequestParam HashMap<String,String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		UserVo userVo = userSvc.userData(Var.selectUserData, paramMap);
		mv.addObject("userVo", userVo);
		return mv;
	}
	
	
	/**
	 * 설명 : 고객정보 수정
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userUpdate.do")
	public ModelAndView userUpdate(@RequestParam HashMap<String,String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			userSvc.userData(Var.updateUser, paramMap);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "고객정보 수정에 성공하였습니다.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "고객정보 수정에 실패하였습니다.");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 고객정보 수정
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userDelete.do")
	public ModelAndView userDelete(@RequestParam HashMap<String,String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			userSvc.userData(Var.deleteUser, paramMap);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "고객정보 가 삭제 되었습니다.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "고객정보 삭제에 실패하였습니다.");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 게시판 관리 화면
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/borderManager.do")
	public ModelAndView borderManager(@RequestParam HashMap<String,String> paramMap, ModelAndView mv) throws Exception
	{
		List<SystemBorderVo> borderList = borderSvc.borderList(Var.sysBorderList, paramMap);
		
		/* selsect box setting */
		List<SystemVo> type = systemSvc.list(Var.sysValueCodeList, "borderType");
		List<SystemVo> fileUser = systemSvc.list(Var.sysValueCodeList, "fileUser");
		List<SystemVo> rippleUser = systemSvc.list(Var.sysValueCodeList, "rippleUser");
		List<SystemVo> authority = systemSvc.list(Var.sysValueCodeList, "authority");
		
		for(SystemBorderVo borderVo : borderList){
			borderVo.setType(Function.sysMapping(type, borderVo.getType()));
			borderVo.setFileUser(Function.sysMapping(fileUser, borderVo.getFileUser()));
			borderVo.setRippleUser(Function.sysMapping(rippleUser, borderVo.getRippleUser()));
			borderVo.setAuthority(Function.sysMapping(authority, borderVo.getAuthority()));
		}
		
		mv.addObject("type",  Function.sysOption(type, ""));
		mv.addObject("fileUser",  Function.sysOption(fileUser, ""));
		mv.addObject("rippleUser",  Function.sysOption(rippleUser, ""));
		mv.addObject("authority",  Function.sysOption(authority, ""));
		mv.addObject("borderList", borderList);
		mv.setViewName("/manager/borderManager");
		return mv;
	}
	
	
	/**
	 * 설명 : 게시판 정보 검색
	 * @param paramMap
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/borderData.do")
	public ModelAndView borderData(@RequestParam HashMap<String,String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		SystemBorderVo borderVo = borderSvc.borderData(Var.sysBorderData, paramMap);
		mv.addObject("borderVo", borderVo);
		return mv;
	}
	
	
	/**
	 * 설명 : 게시판 삽입
	 * @param paramMap
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertBorder.do")
	public ModelAndView insertBorder(@RequestParam HashMap<String,String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			borderSvc.borderInsert(Var.sysBorderInsert, paramMap);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "게시판 설정 등록 성공");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "게시판 설정 등록 실패");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 게시판 수정
	 * @param paramMap
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateBorder.do")
	public ModelAndView updateBorder(@RequestParam HashMap<String,String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			borderSvc.borderUpdate(Var.sysBorderUpdate, paramMap);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "게시판 설정 수정 성공");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "게시판 설정 수정 실패");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 게시판 삭제
	 * @param paramMap
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteBorder.do")
	public ModelAndView deleteBorder(@RequestParam HashMap<String,String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			borderSvc.borderDelete(Var.sysBorderDelete, paramMap);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "게시판 삭제 성공");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "게시판 삭제 실패");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 접근관리 화면
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
