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
 * @author	������
 * @date	2015-10-17
 * @tip		user Controller
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
public class UserCon {
	// �ΰ�
	Logger logs = Logger.getLogger(this.getClass());
	
	// ���� ���� ����
	@Resource(name="UserSvc")
	private UserSvc userSvc;
	
	// �ý��� ���� ����
	@Resource(name="SystemSvc")
	private SystemSvc systemSvc;
	
	// �Խ��� ���� ����
	@Resource(name="BorderSvc")
	private BorderSvc borderSvc;
	
	// �̸��� ���� ����
	@Resource(name="EmailSvc")
	private EmailSvc emailSvc;
	
	// ���� ���� ����
	@Resource(name="FileSvc")
	private FileSvc fileSvc;
	
	// ���ٰ��� ���� ����
	@Resource(name="AccessSvc")
	private AccessSvc accessSvc;
	
	// ���� ���� ����
	@Resource(name="NoteSvc")
	private NoteSvc noteSvc;
	
	
	/**
	 * ���� ����ȭ��
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
	 * ���� : �α���ȭ��
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
	 * ���� : ���μ��� ȭ��
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
	 * ���� : my ������
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
	 * ���� : �α��� Action
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
				mv.addObject("msg", "���� ������ Ȯ���� �ּ���.");
				
				map.put("ip", request.getLocalAddr());
				map.put("type", "�α��� ����");
				map.put("path", (String)request.getAttribute("javax.servlet.forward.request_uri"));
				accessSvc.accessInsert(Var.accessInsert, map);
			}
			else
			{
				// ���� ���
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
			mv.addObject("msg", "������ �߻��Ͽ����ϴ� ����� �ٽ� �õ��� �ּ���.");
		}
		return mv;
	}
	
	
	/**
	 * ���� : ID/PW ã�� ȭ��
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
	 * ���� : ������� ȭ��
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
	 * ���� : ��й�ȣ ����ȭ��
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
	 * ���� : ȸ������ ȭ��
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
		// select box ����
		mv.addObject("gender",  Function.sysOption(sexMap, ""));
		mv.addObject("emails",  Function.sysOption(emailMap, ""));
		mv.setViewName("/user/join");
		return mv;
	}
	
	
	/**
	 * ���� : ���� ȸ������
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
		// select box ����
		mv.addObject("gender",  Function.sysOption(sexMap, ""));
		mv.addObject("emails",  Function.sysOption(emailMap, ""));
		mv.setViewName("/user/simpleJoin");
		return mv;
	}
	
	
	/**
	 * ���� : ȸ������ Action
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
			mv.addObject("msg", "ȸ�����ԵǾ����ϴ�.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "ȸ�� ��Ͽ� �����Ͽ����ϴ�.");
		}
		return mv;
	}
	
	
	/**
	 * ���� : id, pwSearch
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
					paramMap.put("type", "���̵�");
					paramMap.put("title", "OpenSoSo ID ã�� ��� �Դϴ�.");
					paramMap.put("toAddr", user.getEmail());
					paramMap.put("userNo", user.getNo());
					paramMap.put("memo", user.getName() + "���� ���̵��  " + user.getId() + " �Դϴ�.");
					mail.sendMail(paramMap);
					emailSvc.insert(Var.emailInsert, paramMap);
					break;
				case "pw":
					paramMap.put("type", "��й�ȣ");
					paramMap.put("citation", citation);
					paramMap.put("title", "OpenSoSo ��й�ȣ ã�� ��� �Դϴ�.");
					paramMap.put("toAddr", user.getEmail());
					paramMap.put("userNo", user.getNo());
					paramMap.put("memo", "http://localhost:8080/pwChangView.do �� �̵��ϼż� ������ȣ �Է���  ��й�ȣ�� ������ �ֽñ� �ٶ��ϴ�. \n ������ȣ�� " + citation + " �Դϴ�.");
					mail.sendMail(paramMap);
					userSvc.userUpdate(Var.updateUser, paramMap);
					emailSvc.insert(Var.emailInsert, paramMap);
					break;
				default:
					break;
				}
				mv.addObject("code", "SUCC");
				mv.addObject("msg", "�̸��Ϸ� �߼۵Ǿ����ϴ�.");
			}
			else
			{
				mv.addObject("code", "FAIL");
				mv.addObject("msg", "�̸����� �ٽ� Ȯ���� �ּ���.");
			}
		}catch(Exception e)	{
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "�ý��� ���� �Դϴ�.");
		}
		return mv;
	}
	
	
	/**
	 * ���� : ���� ���̵� �ߺ��˻�
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
			
			// ���� ���� Ȯ��
			if(id == null)
			{
				mv.addObject("code", "SUCC");
				mv.addObject("msg", "��밡���� ���̵� �Դϴ�.");
			}
			else
			{
				mv.addObject("code", "FAIL");
				mv.addObject("msg", "���̵� ���� �մϴ�.");
			}
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "�ý��� ���� �Դϴ�.");
		}
		return mv;
	}
	
	
	/**
	 * ���� : �α׾ƿ�
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
	 * ���� : ������ ����
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
			mv.addObject("msg", "������ ������ �����Ͽ����ϴ�.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "������ ������ �����Ͽ����ϴ�.");
		}
		return mv;
	}
	
	
	/**
	 * ���� : ������ ����
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
			
			// ���� action
			if(mf.size() != 0 || !mf.get(0).getOriginalFilename().equals(""))
			{
				paramMap.put("oName", oName);
				paramMap.put("imgName", fileName);
				userSvc.userData(Var.updateUser, paramMap);
				
				map.put("fileName", fileName);
				map.put("userNo", paramMap.get("no"));
				fileSvc.fileInsert(Var.fileInsert, map, multiRequest);
				mv.addObject("code", "SUCC");
				mv.addObject("msg", "���ε� �Ǿ����ϴ�.");
			}
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "���� ���ε忡 �����Ͽ����ϴ�.");
		}
		return mv;
	}
	
	
	/**
	 * ���� : ���� ó��
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
			mv.addObject("msg", "������ �� ���� �Ǿ����ϴ�.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "������ ������ �����Ͽ����ϴ�.");
		}
		return mv;
	}
	
	
	/**
	 * ���� : ��й�ȣ ����
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
			mv.addObject("msg", "��й�ȣ�� ����Ǿ����ϴ�. ������ ��й�ȣ�� �α��� �ϼ���.");
			HttpSession session = request.getSession();
			session.invalidate();
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "��й�ȣ ���濡 ���� �Ͽ����ϴ�.");
		}
		return mv;
	}
	
	
	/**
	 * ���� : Ż�� ó��
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
			mv.addObject("msg", "Ż��Ǿ����ϴ�.");
			HttpSession session = request.getSession();
			session.invalidate();
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "�ý��� ���� �Դϴ�.");
		}
		return mv;
	}
	
	
	/**
	 * ���� : ���� �߼ۿ��� Ȯ��
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
			mv.addObject("msg", "������ ���� �۽� �Ұ� �����Դϴ�.");
		}
		return mv;
	}
	
}
