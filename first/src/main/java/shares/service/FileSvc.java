package shares.service;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import shares.vo.FileVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		파일  Service
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public interface FileSvc {
	// 파일 리스트
	<K, V> List<FileVo> fileList(String sqlId, HashMap<K, V> map) throws Exception;
	// 파일검색
	FileVo fileData(String sqlId, HashMap<String, Object> map) throws Exception;
	// 파일 삽입
	void fileInsert(String sqlId, HashMap<String, Object> map, MultipartHttpServletRequest multiRequest) throws Exception;
	// 파일  삭제
	<K, V> void fileDelete(String sqlId, HashMap<K, V> map) throws Exception;
}
