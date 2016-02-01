package shares.service;
import java.util.HashMap;
import java.util.List;
import shares.vo.SystemBorderVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		게시판 관리 Service
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public interface systemBorderSvc {
	// 게시판 리스트
	List<SystemBorderVo> borderList(String sqlId,  HashMap<String,String> map) throws Exception;
	
	SystemBorderVo borderData(String sqlId,  HashMap<String,String> map) throws Exception;
	
	// 중복 확인
	String checkCode(String sqlId, String value) throws Exception;
	// 게시판 삽입
	void borderInsert(String sqlId, HashMap<String, String> map) throws Exception;
	// 게시판 수정
	void borderUpdate(String sqlId, HashMap<String, String> map) throws Exception;
	// 게시판 삭제
	void borderDelete(String sqlId, HashMap<String, String> map) throws Exception;
}
