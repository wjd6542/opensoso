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
 * @author	강정권
 * @date	2015-11-07
 * @tip		쪽지 Controller
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
public class NoteCon {
	// 로거
	Logger log = Logger.getLogger(this.getClass());
	
	// 쪽지 서비스 연결
	@Resource(name="NoteSvc")
	private NoteSvc noteSvc;
	
	// 시스템 서비스 연결
	@Resource(name="SystemSvc")
	private SystemSvc systemSvc;
	
	// 유저 서비스 연결
	@Resource(name="UserSvc")
	private UserSvc userSvc;
	
	// 페이징
	Paging paging = new Paging();
	
	
	/**
	 * 설명 : 이메일 정보 삭제
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
			mv.addObject("msg", "쪽지가 발송되었습니다.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "쪽지 발송 에 실패 하였습니다.");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 쪽지 읽기 처리
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
			mv.addObject("msg", "쪽지 내용을 불러오는데 실패 하였습니다.");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 쪽지 상태 처리
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
			mv.addObject("msg", "설정에 실패 하였습니다.");
		}
		return mv;
	}
	
}
