package shares.service;
import java.util.HashMap;
import java.util.List;
import shares.vo.BranchVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		부서 Service
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public interface BranchSvc {
	// 부서 리스트
	List<BranchVo> list(String sqlId,  HashMap<String,String> map) throws Exception;
	// 부서 검색
	BranchVo data(String sqlId, HashMap<String,String> map) throws Exception;
	// 중복 확인
	String checkCode(String sqlId, String value) throws Exception;
	// 채번
	String dataNum(String sqlId, HashMap<String,String> map) throws Exception;
	// 부서 삽입
	void insert(String sqlId, HashMap<String, String> map) throws Exception;
	// 부서 수정
	void update(String sqlId, HashMap<String, String> map) throws Exception;
	// 부서 삭제
	void delete(String sqlId, HashMap<String, String> map) throws Exception;
}
