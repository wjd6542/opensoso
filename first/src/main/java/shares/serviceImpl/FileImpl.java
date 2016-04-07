package shares.serviceImpl;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import shares.dao.AbstractDAO;
import shares.service.FileSvc;
import shares.util.Files;
import shares.var.Var;
import shares.vo.FileVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		파일 설정 Impl
 * 			1. DAO , VO 참조객체 설명 주석을 반드시 작성한다
 * 			2. 반드시 공용 주석 작성 형태를 참고 할것
 * 			참조 DAO	: AbstractDAO
 * 			참조 VO	: FileVo
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Service("FileSvc")
public class FileImpl implements FileSvc{
	// 로그
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="AbstractDAO")
	AbstractDAO abstractDAO;
	
	
	// 파일 리스트
	@SuppressWarnings("unchecked")
	@Override
	public <K, V> List<FileVo> fileList(String sqlId, HashMap<K, V> map) throws Exception {
		return abstractDAO.selectList(sqlId, map);
	}
	
	
	// 파일 전체 카운트
	@Override
	public int fileCnt(String sqlId, HashMap<String, String> map) throws Exception {
		return (int)abstractDAO.selectOne(sqlId, map);
	}
	
	
	// 파일 검색
	@Override
	public FileVo fileData(String sqlId, HashMap<String, Object> map) throws Exception {
		return (FileVo) abstractDAO.selectOne(sqlId, map);
	}
	
		
	// 파밀 삽입
	@Override
	public void fileInsert(String sqlId, HashMap<String, Object> map, MultipartHttpServletRequest multiRequest) throws Exception {
		
		List<MultipartFile> mf = multiRequest.getFiles("file");
		for(MultipartFile file : mf)
		{
			String oFileName = file.getOriginalFilename();
			String back = oFileName.substring(oFileName.indexOf("."), oFileName.length());
			String fileName = String.valueOf(System.currentTimeMillis()) + back;
			long size = file.getSize();
			if(Files.fileExtensionCheck(back) == false && Files.fileSizeCheck(size) == false)
			{
				if(map.get("fileName") == "" || map.get("fileName") == null)
				{
					map.put("fileName", fileName);
				}
				else
				{
					fileName = (String) map.get("fileName");
				}
				
				map.put("oName", oFileName);
				map.put("fileSize", size);
				
				// 파입 업로드
				file.transferTo(new File(Var.filePath + fileName));
				
				// DB 데이터 삽입
				abstractDAO.insert(sqlId, map);
			}
		}
	}
	
	
	// 파일 삭제
	@Override
	public <K, V> void fileDelete(String sqlId, HashMap<K, V> map) throws Exception {
		abstractDAO.delete(sqlId, map);
	}
	
}
