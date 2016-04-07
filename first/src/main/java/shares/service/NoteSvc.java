package shares.service;
import java.util.HashMap;
import java.util.List;
import shares.vo.NoteVo;


/**
 * 
 * @author	강정권
 * @date	2016-02-09
 * @tip		쪽지관리 Service
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public interface NoteSvc {
	
	// 쪽지리스트
	List<NoteVo> list(String sqlId, HashMap<String, String> map) throws Exception;
	
	// 쪽지 데이터
	NoteVo data(String sqlId, HashMap<String, String> map) throws Exception;
	
	// 전체 카운트
	int totalCnt(String sqlId, HashMap<String, String> paramMap) throws Exception;
	
	// 쪽지 삽입
	void insert(String sqlId, HashMap<String, String> map) throws Exception;
	
	// 쪽지 수정
	void update(String sqlId, HashMap<String, String> map) throws Exception;
		
	// 쪽지 삭제
	void delete(String sqlId, HashMap<String, String> map) throws Exception;
}
