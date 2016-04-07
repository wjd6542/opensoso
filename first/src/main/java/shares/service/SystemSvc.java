package shares.service;
import java.util.List;
import shares.vo.SystemTableVo;
import shares.vo.SystemVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		시스템  제어 Service
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public interface SystemSvc {
	
	// 환셩설정 테이블 리스트(확인용)
	List<SystemTableVo> list(String sqlId, SystemTableVo vo) throws Exception;
	
	// 환경설정 코드 리스트
	List<SystemVo> list(String sqlId, SystemVo vo) throws Exception;
	
	// 환경설정 결과 리스트 option
	List<SystemVo> list(String sqlId, String value) throws Exception;
	
	// 코드 중복 채크
	String check(String sqlId, SystemVo vo) throws Exception;
	
	// 환경설정 삽입
	void insert(String sqlId, SystemVo vo) throws Exception;
	// 환경설정 수정
	void update(String sqlId, SystemVo vo) throws Exception;
	// 환경설정 삭제
	void delete(String sqlId, SystemVo vo) throws Exception;
}
