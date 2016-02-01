package shares.serviceImpl;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import shares.dao.AbstractDAO;
import shares.service.BorderSvc;
import shares.vo.BorderVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		게시판 설정 Impl
 * 			1. DAO , VO 참조객체 설명 주석을 반드시 작성한다
 * 			2. 반드시 공용 주석 작성 형태를 참고 할것
 * 			참조 DAO	: AbstractDAO
 * 			참조 VO	: BorderVo
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Service("BorderSvc")
public class BorderImpl implements BorderSvc{
	// 로그
	Logger log = Logger.getLogger(this.getClass());
	
	// DAO 연결
	@Resource(name="AbstractDAO")
	private AbstractDAO abstractDAO;
	
	
	// 시스템 게시판 리스트
	@SuppressWarnings("unchecked")
	@Override
	public List<BorderVo> borderList(String sqlId, HashMap<String, String> map) throws Exception {
		return (List<BorderVo>) abstractDAO.selectList(sqlId, map);
	}
	
	
	// 게시판 정보 검색
	@Override
	public BorderVo borderData(String sqlId, HashMap<String, String> map) throws Exception {
		return (BorderVo) abstractDAO.selectOne(sqlId, map);
	}
	
	
	// 게시판 중복확인
	@Override
	public String checkCode(String sqlId, String value) throws Exception {
		return (String)abstractDAO.selectOne(sqlId, value);
	}
	
	
	// 게시판 게시글 최대번호 검색
	@Override
	public String maxNo(String sqlId) throws Exception {
		return (String)abstractDAO.selectOne(sqlId);
	}
	
	
	// cnt 검색
	@Override
	public String selectCnt(String sqlId, HashMap<String, String> map) throws Exception {
		return (String)abstractDAO.selectOne(sqlId, map);
	}
	
	
	// 게시물 삽입
	@Override
	public void borderInsert(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.insert(sqlId, map);
	}
	
	
	// 게시물 수정
	@Override
	public void borderUpdate(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.update(sqlId, map);
	}
	
	
	// 게시물 삭제
	@Override
	public void borderDelete(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.delete(sqlId, map);
	}
	
}
