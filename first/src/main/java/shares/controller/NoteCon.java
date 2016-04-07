package shares.controller;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shares.service.NoteSvc;
import shares.service.SystemSvc;
import shares.service.UserSvc;
import shares.util.Paging;
import shares.var.Var;
import shares.vo.NoteVo;

/**
 * 
 * @author	������
 * @date	2015-11-07
 * @tip		���� Controller
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
public class NoteCon {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	
	// ���� ���� ����
	@Resource(name="NoteSvc")
	private NoteSvc noteSvc;
	
	// �ý��� ���� ����
	@Resource(name="SystemSvc")
	private SystemSvc systemSvc;
	
	// ���� ���� ����
	@Resource(name="UserSvc")
	private UserSvc userSvc;
	
	// ����¡
	Paging paging = new Paging();
	
	
	/**
	 * ���� : �̸��� ���� ����
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/sendNote.do")
	public ModelAndView sendNote(@RequestParam HashMap<String, String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			noteSvc.insert(Var.noteInsert, paramMap);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "������ �߼۵Ǿ����ϴ�.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "���� �߼� �� ���� �Ͽ����ϴ�.");
		}
		return mv;
	}
	
	
	/**
	 * ���� : ���� �б� ó��
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/readNote.do")
	public ModelAndView readNote(@RequestParam HashMap<String, String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		String check = paramMap.get("check");
		try{
			if("Y".equals(check))
				noteSvc.update(Var.noteUpdate, paramMap);
			
			NoteVo noteVo = noteSvc.data(Var.noteData, paramMap);
			mv.addObject("code", "SUCC");
			mv.addObject("noteVo", noteVo);
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "���� ������ �ҷ����µ� ���� �Ͽ����ϴ�.");
		}
		return mv;
	}
	
	
	/**
	 * ���� : ���� ���� ó��
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/noteStatusSet.do")
	public ModelAndView noteStatusSet(@RequestParam HashMap<String, String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			userSvc.userUpdate(Var.updateUser, paramMap);
			mv.addObject("code", "SUCC");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "������ ���� �Ͽ����ϴ�.");
		}
		return mv;
	}
	
}
