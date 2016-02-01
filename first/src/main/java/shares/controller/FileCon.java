package shares.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shares.service.FileSvc;
import shares.var.Var;
import shares.vo.FileVo;

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
public class FileCon {
	// 로거
	Logger log = Logger.getLogger(this.getClass());
	
	// 파일 서비스 연결
	@Resource(name="FileSvc")
	private FileSvc fileSvc;
	
	
	/**
	 * 설명 : 파일 삭제
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/fileDelete.do")
	public ModelAndView fileDelete(@RequestParam HashMap<String,String> paramMap) throws Exception
	{
		ModelAndView mv = new ModelAndView("jsonView");
		String SavePath = Var.filepath;
		String fileName = paramMap.get("fileName");
		File file = new File(SavePath + fileName);
		System.out.println(SavePath + fileName);
		try{
			fileSvc.fileDelete(Var.fileDelete, paramMap);
			file.delete();
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "파일 삭제에 성공하였습니다.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "파일 삭제에 실패하였습니다.");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 파일 다운로드
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/fileDown.do")
	public void fileDown(@RequestParam HashMap<String, Object> paramMap, HttpServletResponse response) throws Exception
	{
		FileVo file = fileSvc.fileData(Var.fileData, paramMap);
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File(Var.filepath + file.getFileName()));
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(file.getFileName(),"UTF-8")+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
}
