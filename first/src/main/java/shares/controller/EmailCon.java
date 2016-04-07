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
public class EmailCon {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	
	// �̸��� ���� ����
	@Resource(name="EmailSvc")
	private EmailSvc emailSvc;
	
	// �ý��� ���� ����
	@Resource(name="SystemSvc")
	private SystemSvc systemSvc;
	
	// ����¡
	Paging paging = new Paging();
	
	/**
	 * ���� : �̸��� ���� ȭ��
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
		// ����¡ ó��
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
	 * ���� : �̸��� ����
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
	 * ���� : �̸��� ���� ����
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
			mv.addObject("msg", "����ó�� �Ǿ����ϴ�.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "����ó�� �� ���� �Ͽ����ϴ�.");
		}
		return mv;
	}
}
