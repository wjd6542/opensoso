package shares.serviceImpl;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import shares.dao.SystemTableDAO;
import shares.dao.SystemDAO;
import shares.service.SystemSvc;
import shares.vo.SystemTableVo;
import shares.vo.SystemVo;


/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		시스템 코드 제어 Service
 * 			1. DAO , VO 참조객체 설명 주석을 반드시 작성한다
 * 			2. 반드시 공용 주석 작성 형태를 참고 할것
 * 			참조 DAO	: SystemTableDAO, SystemCodeDAO, SystemValueDAO
 * 			참조 VO	: SystemTableVo, SystemCodeVo, SystemValueVo
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Service("SystemService")
public class SystemImpl implements SystemSvc{
	// 로그
	Logger log = Logger.getLogger(this.getClass());
	
	// SystemTableDAO 연결
	@Resource(name = "SystemTableDAO")
	private SystemTableDAO systemTableDAO;
	
	// SystemDAO 연결
	@Resource(name = "SystemDAO")
	private SystemDAO systemDAO;
	
	// 시스템 테이블 리스트
	@Override
	public List<SystemTableVo> list(String sqlId, SystemTableVo vo) throws Exception {
		return (List<SystemTableVo>) systemTableDAO.list(sqlId, vo);
	}
	
	// 환경설정 리스트
	@Override
	public List<SystemVo> list(String sqlId, SystemVo vo) throws Exception { 
		return (List<SystemVo>) systemDAO.list(sqlId, vo);
	}
	
	// 환경설정 리스트 부분
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemVo> list(String sqlId, String value) throws Exception {
		return (List<SystemVo>) systemDAO.selectList(sqlId, value);
	}

	// 환경설정 코드 중복확인
	@Override
	public String check(String sqlId, String value) throws Exception {
		return (String) systemDAO.selectOne(sqlId, value);
	}
	
	// 환경설정 삽입
	@Override
	public void insert(String sqlId, SystemVo vo) throws Exception {
		systemDAO.insert(sqlId, vo);
	}
	
	// 환경설정 수정
	@Override
	public void update(String sqlId, SystemVo vo) throws Exception {
		systemDAO.update(sqlId, vo);
	}

	// 환경설정 삭제
	@Override
	public void delete(String sqlId, SystemVo vo) throws Exception {
		systemDAO.delete(sqlId, vo);
	}
}
