package shares.service;
import java.util.HashMap;
import java.util.List;
import shares.vo.EmailVo;


/**
 * 
 * @author	강정권
 * @date	2016-02-09
 * @tip		이메일관리 Service
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public interface EmailSvc {
	
	// 이메일리스트
	List<EmailVo> list(String sqlId, HashMap<String, String> map) throws Exception;
	
	// 이메일 데이터
	EmailVo data(String sqlId, HashMap<String, String> map) throws Exception;
	
	// 전체 카운트
	int totalCnt(String sqlId, HashMap<String, String> paramMap) throws Exception;
	
	// 이메일 삽입
	void insert(String sqlId, HashMap<String, String> map) throws Exception;
	
	// 이메일 삭제
	void delete(String sqlId, HashMap<String, String> map) throws Exception;
}
