package shares.serviceImpl;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import shares.dao.AbstractDAO;
import shares.service.AccessSvc;
import shares.vo.AccessVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		파일 설정 Impl
 * 			1. DAO , VO 참조객체 설명 주석을 반드시 작성한다
 * 			2. 반드시 공용 주석 작성 형태를 참고 할것
 * 			참조 DAO	: AbstractDAO
 * 			참조 VO	: FileVo
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Service("AccessSvc")
public class AccessImpl implements AccessSvc{
	// 로그
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="AbstractDAO")
	AbstractDAO abstractDAO;
	
	// 접근관리 리스트
	@SuppressWarnings("unchecked")
	@Override
	public List<AccessVo> accessList(String sqlId, HashMap<String, String> map) throws Exception {
		return (List<AccessVo>) abstractDAO.selectList(sqlId, map);
	}
	
	// 접근관리 삽입
	@Override
	public void accessInsert(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.insert(sqlId, map);
	}
	
	// 접근관리 삭제
	@Override
	public void accessDelete(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.delete(sqlId, map);
	}
	
	// 전체 카운트
	@Override
	public int accessCnt(String sqlId, HashMap<String, String> paramMap) throws Exception {
		
		return (int) abstractDAO.selectOne(sqlId, paramMap);
	}

}
