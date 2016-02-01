package shares.service;
import java.util.HashMap;
import java.util.List;
import shares.vo.BorderVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		게시판 Service
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public interface BorderSvc {
	// 게시판 리스트
	List<BorderVo> borderList(String sqlId,  HashMap<String,String> map) throws Exception;
	// 게시판 정보
	BorderVo borderData(String sqlId,  HashMap<String,String> map) throws Exception;
	// 중복 확인
	String checkCode(String sqlId, String value) throws Exception;
	// 최대값 검색
	String maxNo(String sqlId) throws Exception;
	// 추천수 검색
	String selectCnt(String sqlId, HashMap<String, String> map) throws Exception;
	// 게시판 삽입
	void borderInsert(String sqlId, HashMap<String, String> map) throws Exception;
	// 게시판 수정
	void borderUpdate(String sqlId, HashMap<String, String> map) throws Exception;
	// 게시판 삭제
	void borderDelete(String sqlId, HashMap<String, String> map) throws Exception;
}
