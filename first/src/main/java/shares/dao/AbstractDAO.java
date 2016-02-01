package shares.dao;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author	강정권
 * @date	2015-10-17
 * @tip		DB 연결 Class
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Repository("AbstractDAO")
public class AbstractDAO {
	// 로그
	Logger log = Logger.getLogger(this.getClass());
	
	// DB 연결
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 쿼리 출력
	 * @param queryId
	 */
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()){
			//log.debug("\t QueryId  \t:  " + queryId);
		}
	}
	
	/**
	 * 삽입 조건 여러개
	 * @param queryId
	 * @param params
	 * @return
	 */
	public Object insert(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.insert(queryId, params);
	}
	
	/**
	 * 수정 조건 여러개
	 * @param queryId
	 * @param params
	 * @return
	 */
	public Object update(String queryId, Object params){
		return sqlSession.update(queryId, params);
	}
	
	/**
	 * 삭제 조건 여러개
	 * @param queryId
	 * @param params
	 * @return
	 */
	public Object delete(String queryId, Object params){
		return sqlSession.delete(queryId, params);
	}
	
	/**
	 * 검색 단건
	 * @param queryId
	 * @return
	 */
	public Object selectOne(String queryId){
		return sqlSession.selectOne(queryId);
	}
	
	/**
	 * 검색 단건 조건 여러개
	 * @param queryId
	 * @param params
	 * @return
	 */
	public Object selectOne(String queryId, Object params){
		return sqlSession.selectOne(queryId, params);
	}
	/**
	 * 리스트 조회 전채 조회
	 * @param queryId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId){
		return sqlSession.selectList(queryId);
	}
	
	/**
	 * 리스트 조회 조건 여러개
	 * @param queryId
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId, Object params){
		return sqlSession.selectList(queryId,params);
	}
}