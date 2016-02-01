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
public class FileCon {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	
	// ���� ���� ����
	@Resource(name="FileSvc")
	private FileSvc fileSvc;
	
	
	/**
	 * ���� : ���� ����
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
			mv.addObject("msg", "���� ������ �����Ͽ����ϴ�.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "���� ������ �����Ͽ����ϴ�.");
		}
		return mv;
	}
	
	
	/**
	 * ���� : ���� �ٿ�ε�
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
