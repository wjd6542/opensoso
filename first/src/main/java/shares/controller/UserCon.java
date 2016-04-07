package shares.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import shares.service.AccessSvc;
import shares.service.BorderSvc;
import shares.service.EmailSvc;
import shares.service.FileSvc;
import shares.service.NoteSvc;
import shares.service.SystemSvc;
import shares.service.UserSvc;
import shares.util.Function;
import shares.util.Mail;
import shares.var.Var;
import shares.vo.BorderVo;
import shares.vo.NoteVo;
import shares.vo.SystemVo;
import shares.vo.UserVo;

/**
 * 
 * @author	강정권
 * @date	2015-10-17
 * @tip		user Controller
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-10-17
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Controller
public class UserCon {
	// 로거
	Logger logs = Logger.getLogger(this.getClass());
	
	// 유저 서비스 연결
	@Resource(name="UserSvc")
	private UserSvc userSvc;
	
	// 시스템 서비스 연결
	@Resource(name="SystemSvc")
	private SystemSvc systemSvc;
	
	// 게시판 서비스 연결
	@Resource(name="BorderSvc")
	private BorderSvc borderSvc;
	
	// 이메일 서비스 연결
	@Resource(name="EmailSvc")
	private EmailSvc emailSvc;
	
	// 파일 서비스 연결
	@Resource(name="FileSvc")
	private FileSvc fileSvc;
	
	// 접근관리 서비스 연결
	@Resource(name="AccessSvc")
	private AccessSvc accessSvc;
	
	// 쪽지 서비스 연결
	@Resource(name="NoteSvc")
	private NoteSvc noteSvc;
	
	
	/**
	 * 설명 메인화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/index.do")
	public ModelAndView main(@RequestParam HashMap<String,String> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		paramMap.put("borderType", "B01");
		List<BorderVo> borderList1 = borderSvc.borderList(Var.borderMainList, paramMap);
		paramMap.put("borderType", "B02");
		List<BorderVo> borderList2 = borderSvc.borderList(Var.borderMainList, paramMap);
		paramMap.put("borderType", "B03");
		List<BorderVo> borderList3 = borderSvc.borderList(Var.borderMainList, paramMap);
		paramMap.put("borderType", "B04");
		List<BorderVo> borderList4 = borderSvc.borderList(Var.borderMainList, paramMap);
		
		mv.addObject("borderList1", borderList1);
		mv.addObject("borderList2", borderList2);
		mv.addObject("borderList3", borderList3);
		mv.addObject("borderList4", borderList4);
		
		mv.setViewName("/index");
		return mv;
	}
	
	
	/**
	 * 설명 : 로그인화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login.do")
	public ModelAndView login(@RequestParam Map<String,Object> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		mv.setViewName("/user/login");
		return mv;
	}
	
	
	/**
	 * 설명 : 개인설정 화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/myConf.do")
		public ModelAndView myConf(@RequestParam Map<String,Object> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		mv.setViewName("/user/myConf");
		return mv;
	}
	
	
	/**
	 * 설명 : my 페이지
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/myPage.do")
	public ModelAndView myPage(@RequestParam HashMap<String, String> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		paramMap.put("id", (String) session.getAttribute("userId"));
		UserVo user = userSvc.userData(Var.selectUserData, paramMap);
		List<BorderVo> borderList = borderSvc.borderList(Var.borderUserList, paramMap);
		List<NoteVo> noteList = noteSvc.list(Var.noteList, paramMap);
		
		mv.addObject("imgPath", Var.filePath);
		mv.addObject("user", user);
		mv.addObject("borderList", borderList);
		mv.addObject("noteList", noteList);
		mv.setViewName("/user/myPages");
		return mv;
	}
	
	
	/**
	 * 설명 : 로그인 Action
	 * @param paramMap
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/loginAction.do")
	public ModelAndView loginAction(@RequestParam Map<String, String> paramMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		HashMap<String, String> map = new HashMap<String, String>();
		
		try{
			UserVo member = userSvc.userData(Var.selectUser, paramMap);
			if(member == null)
			{
				mv.addObject("code", "FAIL");
				mv.addObject("msg", "계정 정보를 확인해 주세요.");
				
				map.put("ip", request.getLocalAddr());
				map.put("type", "로그인 실패");
				map.put("path", (String)request.getAttribute("javax.servlet.forward.request_uri"));
				accessSvc.accessInsert(Var.accessInsert, map);
			}
			else
			{
				// 세션 등록
				mv.addObject("code", "SUCC");
				HttpSession session = request.getSession();
				session.setAttribute("user", member);
				session.setAttribute("userId", member.getId());
				session.setMaxInactiveInterval(1800);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "오류가 발생하였습니다 잠시후 다시 시도해 주세요.");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : ID/PW 찾기 화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/idpwSearch.do" )
	public ModelAndView idpwSearch(@RequestParam HashMap<String, String> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		mv.setViewName("/user/idpwSearch");
		return mv;
	}
	
	
	/**
	 * 설명 : 약관동의 화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/consent.do")
	public ModelAndView consent(@RequestParam HashMap<String, String> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		mv.setViewName("/user/consent");
		return mv;
	}
	
	
	/**
	 * 설명 : 비밀번호 변경화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/pwChangView.do")
	public ModelAndView pwChangView(@RequestParam HashMap<String, String> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		mv.setViewName("/user/pwChangView");
		return mv;
	}
	
	
	/**
	 * 설명 : 회원가입 화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/join.do")
	public ModelAndView join(@RequestParam HashMap<String, String> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		List<SystemVo> sexMap = systemSvc.list(Var.sysValueCodeList, "gender");
		List<SystemVo> emailMap = systemSvc.list(Var.sysValueCodeList, "email");
		// select box 생성
		mv.addObject("gender",  Function.sysOption(sexMap, ""));
		mv.addObject("emails",  Function.sysOption(emailMap, ""));
		mv.setViewName("/user/join");
		return mv;
	}
	
	
	/**
	 * 설명 : 간편 회원가입
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/simpleJoin.do")
	public ModelAndView simpleJoin(@RequestParam HashMap<String, String> paramMap, ModelAndView mv, HttpServletRequest request) throws Exception{
		List<SystemVo> sexMap = systemSvc.list(Var.sysValueCodeList, "gender");
		List<SystemVo> emailMap = systemSvc.list(Var.sysValueCodeList, "email");
		// select box 생성
		mv.addObject("gender",  Function.sysOption(sexMap, ""));
		mv.addObject("emails",  Function.sysOption(emailMap, ""));
		mv.setViewName("/user/simpleJoin");
		return mv;
	}
	
	
	/**
	 * 설명 : 회원가입 Action
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userInsert.do")
	public ModelAndView userInsert(@RequestParam HashMap<String, String> paramMap, HttpServletRequest request) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		HttpSession session = request.getSession();
		try{
			userSvc.userInsert(Var.insertUser, paramMap);
			UserVo user = userSvc.userData(Var.selectUserData, paramMap);
			
			session.setAttribute("user", user);
			session.setAttribute("userId", paramMap.get("id"));
			session.setMaxInactiveInterval(1800);
			
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "회원가입되었습니다.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "회원 등록에 실패하였습니다.");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : id, pwSearch
	 * @param paramMap
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/idpwSearchAction.do")
	public ModelAndView idpwSearchAction(@RequestParam HashMap<String, String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		String type = paramMap.get("type");
		Mail mail = new Mail();
		String citation = String.valueOf(System.currentTimeMillis());
		try
		{
			UserVo user = userSvc.userData(Var.selectUser, paramMap);
			if(user != null)
			{
				switch (type) {
				case "id":
					paramMap.put("type", "아이디");
					paramMap.put("title", "OpenSoSo ID 찾기 결과 입니다.");
					paramMap.put("toAddr", user.getEmail());
					paramMap.put("userNo", user.getNo());
					paramMap.put("memo", user.getName() + "님의 아이디는  " + user.getId() + " 입니다.");
					mail.sendMail(paramMap);
					emailSvc.insert(Var.emailInsert, paramMap);
					break;
				case "pw":
					paramMap.put("type", "비밀번호");
					paramMap.put("citation", citation);
					paramMap.put("title", "OpenSoSo 비밀번호 찾기 결과 입니다.");
					paramMap.put("toAddr", user.getEmail());
					paramMap.put("userNo", user.getNo());
					paramMap.put("memo", "http://localhost:8080/pwChangView.do 로 이동하셔서 인증번호 입력후  비밀번호를 변경해 주시기 바랍니다. \n 인증번호는 " + citation + " 입니다.");
					mail.sendMail(paramMap);
					userSvc.userUpdate(Var.updateUser, paramMap);
					emailSvc.insert(Var.emailInsert, paramMap);
					break;
				default:
					break;
				}
				mv.addObject("code", "SUCC");
				mv.addObject("msg", "이메일로 발송되었습니다.");
			}
			else
			{
				mv.addObject("code", "FAIL");
				mv.addObject("msg", "이메일을 다시 확인해 주세요.");
			}
		}catch(Exception e)	{
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "시스템 에러 입니다.");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 유저 아이디 중복검사
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userIdCheck.do")
	public ModelAndView userIdCheck(@RequestParam HashMap<String, String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			String id = userSvc.idCheck(Var.userIdCheck, paramMap.get("id"));
			
			// 존재 유무 확인
			if(id == null)
			{
				mv.addObject("code", "SUCC");
				mv.addObject("msg", "사용가능한 아이디 입니다.");
			}
			else
			{
				mv.addObject("code", "FAIL");
				mv.addObject("msg", "아이디가 존재 합니다.");
			}
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "시스템 에러 입니다.");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 로그아웃
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/logOut.do")
	public ModelAndView logOut(@RequestParam HashMap<String, String> paramMap,  ModelAndView mv, HttpServletRequest request) throws Exception
	{
		HttpSession session = request.getSession();
		session.invalidate();
		mv.setViewName("/index");
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
	@RequestMapping(value="/profileUpload.do")
	public ModelAndView profileUpload(@RequestParam HashMap<String,String> paramMap,
			MultipartHttpServletRequest multiRequest) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<MultipartFile> mf = multiRequest.getFiles("file");
		MultipartFile file = mf.get(0);
		
		String oName = file.getOriginalFilename();
		String back = oName.substring(oName.indexOf("."), oName.length());
		String fileName = String.valueOf(System.currentTimeMillis()) + back;
		try{
			
			// 파일 action
			if(mf.size() != 0 || !mf.get(0).getOriginalFilename().equals(""))
			{
				paramMap.put("oName", oName);
				paramMap.put("imgName", fileName);
				userSvc.userData(Var.updateUser, paramMap);
				
				map.put("fileName", fileName);
				map.put("userNo", paramMap.get("no"));
				fileSvc.fileInsert(Var.fileInsert, map, multiRequest);
				mv.addObject("code", "SUCC");
				mv.addObject("msg", "업로드 되었습니다.");
			}
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "사진 업로드에 실패하였습니다.");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 삭제 처리
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
	 * 섦영 : 비밀번호 변경
	 * @param paramMap
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/passwordChang.do")
	public ModelAndView passwordChang(@RequestParam HashMap<String, String> paramMap, HttpServletRequest request) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			userSvc.userUpdate(Var.userPwChang, paramMap);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "비밀번호가 변경되었습니다. 수정된 비밀번호로 로그인 하세요.");
			HttpSession session = request.getSession();
			session.invalidate();
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "비밀번호 변경에 실패 하였습니다.");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 탈퇴 처리
	 * @param paramMap
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/leave.do")
	public ModelAndView leave(@RequestParam HashMap<String, String> paramMap, HttpServletRequest request) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			userSvc.userUpdate(Var.userLeave, paramMap);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "탈퇴되었습니다.");
			HttpSession session = request.getSession();
			session.invalidate();
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "시스템 에러 입니다.");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 쪽지 발송여부 확인
	 * @param paramMap
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/noteCk.do")
	public ModelAndView noteCk(@RequestParam HashMap<String, String> paramMap, HttpServletRequest request) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		UserVo user = userSvc.userData(Var.selectUserData, paramMap);
		
		if(user.getNoteStatus() != null && user.getNoteStatus() == "Y")
		{
			mv.addObject("code", "SUCC");
		}
		else
		{
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "상대발이 쪽지 송신 불가 상태입니다.");
		}
		return mv;
	}
	
}
