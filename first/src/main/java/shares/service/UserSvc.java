package shares.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import shares.vo.UserVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		유저  Service
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public interface UserSvc {
	// 유저 검색
	List<UserVo> selectUserList(String sqlId, HashMap<String, String> map) throws Exception;
	// 유저확인
	UserVo userData(String sqlId, Map<String, String> paramMap) throws Exception;
	// 중복확인
	String idCheck(String sqlId, String value) throws Exception;
	// 전체 갯수 
	int userTotalcnt(String sqlId, HashMap<String, String> map);
	// 유저 삽입
	void userInsert(String sqlId, HashMap<String, String> map) throws Exception;
	// 유저 수정
	void userUpdate(String sqlId, HashMap<String, String> map) throws Exception;
	// 유저 삭제
	void userDelete(String sqlId, HashMap<String, String> map) throws Exception;
}
