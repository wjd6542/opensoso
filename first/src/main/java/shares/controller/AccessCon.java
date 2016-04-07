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
public class AccessCon {
	// 로거
	Logger log = Logger.getLogger(this.getClass());
	
	// 접근 서비스 연결
	@Resource(name="AccessSvc")
	private AccessSvc accessSvc;
	
	// 시스템 서비스 연결
	@Resource(name="SystemSvc")
	private SystemSvc systemSvc;
	
	// 페이징
	Paging paging = new Paging();
	
	/**
	 * 설명 : 접근관리 화면
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
		// 페이징 처리
		int totalcnt = accessSvc.accessCnt(Var.accessTotalCnt, paramMap);
		paramMap = paging.setting(pageNo, pageSize, totalcnt, paramMap);
		List<AccessVo> accessList = accessSvc.accessList(Var.accessList, paramMap);
		List<SystemVo> serchMap = systemSvc.list(Var.sysValueCodeList, "accessSerch");
		
		
		/*================ View data setting str =================
		 * search			: 검색 항목
		 * searchString		: 검색 입력
		 * pageNo			: 페이지 번호
		 * pageSize			: 페이지 사이즈
		 * paging			: 페이징
		 * accessList		: 접근 리스트
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
