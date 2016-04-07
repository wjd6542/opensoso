package shares.controller;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shares.service.FileSvc;
import shares.service.SystemSvc;
import shares.util.Function;
import shares.util.Paging;
import shares.var.Var;
import shares.vo.FileVo;
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
public class FileCon {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	
	// ���� ���� ����
	@Resource(name="FileSvc")
	private FileSvc fileSvc;
	
	// �ý��� ���� ����
	@Resource(name="SystemSvc")
	private SystemSvc systemSvc;
	
	// ����¡
	Paging paging = new Paging();
		
	
	/**
	 * ���� : ���� ���� ������
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/fileManager.do")
	public ModelAndView fileManager(
			@RequestParam HashMap<String,String> paramMap, 
			@RequestParam(value="pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value="pageSize", defaultValue = "10") int pageSize,
			ModelAndView mv) throws Exception
	{
		// ����¡ ó��
		int totalcnt = fileSvc.fileCnt(Var.fileTotalCnt, paramMap);
		paramMap = paging.setting(pageNo, pageSize, totalcnt, paramMap);
		List<FileVo> fileList = fileSvc.fileList(Var.fileList, paramMap);
		List<SystemVo> serchMap = systemSvc.list(Var.sysValueCodeList, "fileSerch");
		
		
		/*================ View data setting str =================
		 * search			: �˻� �׸�
		 * searchString		: �˻� �Է�
		 * pageNo			: ������ ��ȣ
		 * pageSize			: ������ ������
		 * paging			: ����¡
		 * fileList			: ���� ����Ʈ
		 ================= View data setting end =================*/
		mv.addObject("search",  Function.sysOption(serchMap, paramMap.get("search")));
		mv.addObject("searchString", paramMap.get("searchString"));
		mv.addObject("pageNo", pageNo);
		mv.addObject("pageSize", pageSize);
		mv.addObject("paging", paging);
		mv.addObject("fileList", fileList);
		mv.setViewName("/admin/fileManager");
		return mv;
	}
		
		
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
		String SavePath = Var.filePath;
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
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File(Var.filePath + file.getFileName()));
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(file.getFileName(),"UTF-8")+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
	
	/**
	 * ���� : �ϰ� ���� �ٿ�ε�
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/bachDown.do")
	public void bachDown(String noArr)
	{
		@SuppressWarnings("unchecked")
		List<String> checkList = JSONArray.fromObject(noArr);
		
		for(String key : checkList)
		{
			System.out.println(key);
		}
		
	}
}
