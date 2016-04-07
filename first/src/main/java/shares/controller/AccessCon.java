package shares.controller;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shares.service.AccessSvc;
import shares.service.SystemSvc;
import shares.util.Function;
import shares.util.Paging;
import shares.var.Var;
import shares.vo.AccessVo;
import shares.vo.SystemVo;

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
public class AccessCon {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	
	// ���� ���� ����
	@Resource(name="AccessSvc")
	private AccessSvc accessSvc;
	
	// �ý��� ���� ����
	@Resource(name="SystemSvc")
	private SystemSvc systemSvc;
	
	// ����¡
	Paging paging = new Paging();
	
	/**
	 * ���� : ���ٰ��� ȭ��
	 * @param paramMap
	 * @param mv
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/accessManager.do")
	public ModelAndView accessManager(
			@RequestParam HashMap<String, String> paramMap,
			@RequestParam(value="pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value="pageSize", defaultValue = "10") int pageSize,
			ModelAndView mv) throws Exception
	{
		// ����¡ ó��
		int totalcnt = accessSvc.accessCnt(Var.accessTotalCnt, paramMap);
		paramMap = paging.setting(pageNo, pageSize, totalcnt, paramMap);
		List<AccessVo> accessList = accessSvc.accessList(Var.accessList, paramMap);
		List<SystemVo> serchMap = systemSvc.list(Var.sysValueCodeList, "accessSerch");
		
		
		/*================ View data setting str =================
		 * search			: �˻� �׸�
		 * searchString		: �˻� �Է�
		 * pageNo			: ������ ��ȣ
		 * pageSize			: ������ ������
		 * paging			: ����¡
		 * accessList		: ���� ����Ʈ
		 ================= View data setting end =================*/
		mv.addObject("search",  Function.sysOption(serchMap, paramMap.get("search")));
		mv.addObject("searchString", paramMap.get("searchString"));
		mv.addObject("pageNo", pageNo);
		mv.addObject("pageSize", pageSize);
		mv.addObject("paging", paging);
		mv.addObject("accessList", accessList);
		mv.setViewName("/admin/accessManager");
		return mv;
	}
}
