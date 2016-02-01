package shares.dao;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author	������
 * @date	2015-10-17
 * @tip		DB ���� Class
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-29
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
@Repository("AbstractDAO")
public class AbstractDAO {
	// �α�
	Logger log = Logger.getLogger(this.getClass());
	
	// DB ����
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * ���� ���
	 * @param queryId
	 */
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()){
			//log.debug("\t QueryId  \t:  " + queryId);
		}
	}
	
	/**
	 * ���� ���� ������
	 * @param queryId
	 * @param params
	 * @return
	 */
	public Object insert(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.insert(queryId, params);
	}
	
	/**
	 * ���� ���� ������
	 * @param queryId
	 * @param params
	 * @return
	 */
	public Object update(String queryId, Object params){
		return sqlSession.update(queryId, params);
	}
	
	/**
	 * ���� ���� ������
	 * @param queryId
	 * @param params
	 * @return
	 */
	public Object delete(String queryId, Object params){
		return sqlSession.delete(queryId, params);
	}
	
	/**
	 * �˻� �ܰ�
	 * @param queryId
	 * @return
	 */
	public Object selectOne(String queryId){
		return sqlSession.selectOne(queryId);
	}
	
	/**
	 * �˻� �ܰ� ���� ������
	 * @param queryId
	 * @param params
	 * @return
	 */
	public Object selectOne(String queryId, Object params){
		return sqlSession.selectOne(queryId, params);
	}
	/**
	 * ����Ʈ ��ȸ ��ä ��ȸ
	 * @param queryId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId){
		return sqlSession.selectList(queryId);
	}
	
	/**
	 * ����Ʈ ��ȸ ���� ������
	 * @param queryId
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId, Object params){
		return sqlSession.selectList(queryId,params);
	}
}