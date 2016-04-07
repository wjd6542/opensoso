package shares.service;
import java.util.HashMap;
import java.util.List;

import shares.vo.AccessVo;


/**
 * 
 * @author	강정권
 * @date	2016-02-09
 * @tip		접근관리 Service
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public interface AccessSvc {
	
	// 접근리스트
	List<AccessVo> accessList(String sqlId, HashMap<String, String> map) throws Exception;
	
	// 전체 카운트
	int accessCnt(String sqlId, HashMap<String, String> paramMap) throws Exception;
	
	// 접근 삽입
	void accessInsert(String sqlId, HashMap<String, String> map) throws Exception;
	
	// 접근 삭제
	void accessDelete(String sqlId, HashMap<String, String> map) throws Exception;
}
