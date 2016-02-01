package shares.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shares.service.BorderSvc;
import shares.service.SystemSvc;
import shares.service.UserSvc;
import shares.util.Function;
import shares.var.Var;
import shares.vo.BorderVo;
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
	
	
	/**
	 * ����ȭ��
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/index.do")
	public ModelAndView main(@RequestParam HashMap<String,String> paramMap, ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception{
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
	 * �α���ȭ��
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
	 * �α��� Action
	 * @param paramMap
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/loginAction.do")
	public ModelAndView loginAction(@RequestParam Map<String, String> paramMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			UserVo member = userSvc.userData(Var.selectUser, paramMap);
			if(member == null)
			{
				mv.addObject("code", "FAIL");
				mv.addObject("msg", "���� ������ Ȯ���� �ּ���.");
			}
			else
			{
				// ���� ���
				mv.addObject("code", "SUCC");
				mv.addObject("member", member);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return mv;
	}
	
	
	/**
	 * ID/PW ã�� ȭ��
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
	 * ������� ȭ��
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
	 * ȸ������ ȭ��
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
	 * ȸ������ Action
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userInsert.do")
	public ModelAndView userInsert(@RequestParam HashMap<String, String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			userSvc.userInsert(Var.insertUser, paramMap);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "ȸ�����ԵǾ����ϴ�.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "ȸ�� ��Ͽ� �����Ͽ����ϴ�.");
		}
		return mv;
	}
	
	

	
}
