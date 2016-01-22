package shares.service;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		권한 Service
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public interface AuthoritySvc {
	// 권한 리스트
	ArrayList<HashMap<String,String>> selectAuthorityList(String sqlId,  HashMap<String,String> map) throws Exception;
	// 권한 검색
	HashMap<String, String>authoritySelect(String sqlId,  HashMap<String,String> map) throws Exception;
	// 중복 확인
	String checkCode(String sqlId, String value) throws Exception;
	// 권한 삽입
	void authorityInsert(String sqlId, HashMap<String, String> map) throws Exception;
	// 권한 수정
	void authorityUpdate(String sqlId, HashMap<String, String> map) throws Exception;
	// 권한 삭제
	void authorityDelete(String sqlId, HashMap<String, String> map) throws Exception;
}
