package shares.controller;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @author	������
 * @date	2015-11-07
 * @tip		�Խ��� Controller
 * <pre>
 * -------- �����̷� ----------
 * ������	:	������
 * ��������	:	2015-11-07
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
@Controller
public class BorderCon {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	
	
	
	/**
	 * �Խ��� ���� ȭ��
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
