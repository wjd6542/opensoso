package shares.controller;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shares.service.EmailSvc;
import shares.service.SystemSvc;
import shares.util.Paging;
import shares.var.Var;
import shares.vo.EmailVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-07
 * @tip		파일 Controller
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
public class EmailCon {
	// 로거
	Logger log = Logger.getLogger(this.getClass());
	
	// 이메일 서비스 연결
	@Resource(name="EmailSvc")
	private EmailSvc emailSvc;
	
	// 시스템 서비스 연결
	@Resource(name="SystemSvc")
	private SystemSvc systemSvc;
	
	// 페이징
	Paging paging = new Paging();
	
	/**
	 * 설명 : 이메일 관리 화면
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/emailManager.do")
	public ModelAndView emailManager(
			@RequestParam HashMap<String,String> paramMap,
			@RequestParam(value="pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value="pageSize", defaultValue = "10") int pageSize,
			ModelAndView mv) throws Exception
	{
		// 페이징 처리
		int totalcnt = emailSvc.totalCnt(Var.emailTotalCnt, paramMap);
		paramMap = paging.setting(pageNo, pageSize, totalcnt, paramMap);
		List<EmailVo> list = emailSvc.list(Var.emailList, paramMap);
		mv.addObject("list", list);
		mv.addObject("searchString", paramMap.get("searchString"));
		mv.addObject("pageNo", pageNo);
		mv.addObject("pageSize", pageSize);
		mv.addObject("paging", paging);
		mv.setViewName("/admin/emailManager");
		return mv;
	}
	
	
	/**
	 * 설명 : 이메일 정보
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/emailData.do")
	public ModelAndView emailData(@RequestParam HashMap<String, String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		EmailVo emailVo = emailSvc.data(Var.emailData, paramMap);
		mv.addObject("emailVo", emailVo);
		return mv;
	}
	
	
	/**
	 * 설명 : 이메일 정보 삭제
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/emailDelete.do")
	public ModelAndView emailDelete(@RequestParam HashMap<String, String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			emailSvc.delete(Var.emailDelete, paramMap);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "삭제처리 되었습니다.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "삭제처리 에 실패 하였습니다.");
		}
		return mv;
	}
}
