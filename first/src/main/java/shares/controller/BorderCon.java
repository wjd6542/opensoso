package shares.controller;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @author	강정권
 * @date	2015-11-07
 * @tip		게시판 Controller
 * <pre>
 * -------- 수정이력 ----------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-07
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Controller
public class BorderCon {
	// 로거
	Logger log = Logger.getLogger(this.getClass());
	
	
	
	/**
	 * 게시판 관리 화면
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/borderManager.do")
	public ModelAndView borderManager(@RequestParam HashMap<String,String> paramMap, ModelAndView mv) throws Exception
	{
		
		mv.setViewName("/manager/borderManager");
		return mv;
	}
}
