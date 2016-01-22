package shares.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import shares.vo.SystemVo;

/**
 * 
 * @author	������
 * @date	2015-11-07
 * @tip		DB ���� Class
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-07
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
@Repository("SystemDAO")
public class SystemDAO extends AbstractDAO{
	
	/**
	 * �ڵ� ����Ʈ �˻�
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SystemVo> list(String sqlId, SystemVo vo) throws Exception
	{
		return (List<SystemVo>)selectList(sqlId, vo);
	}
	
	/**
	 * �ڵ� �˻�
	 * @param sqlId
	 * @param value
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SystemVo> list(String sqlId, String value) throws Exception
	{
		return (List<SystemVo>)selectList(sqlId, value);
	}
	
	/**
	 * �ڵ� �ߺ�Ȯ��
	 * @param sqlId
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String check(String sqlId, String value) throws Exception
	{
		return (String)selectOne(sqlId, value);
	}
	
	/**
	 * �ڵ� ����
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object systemInsert(String sqlId, SystemVo vo) throws Exception
	{
		return insert(sqlId, vo);
	}
	
	/**
	 * �ڵ� ����
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object systemUpdate(String sqlId, SystemVo vo) throws Exception
	{
		return update(sqlId, vo);
	}
	
	/**
	 * �ڵ� ����
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object systemDelete(String sqlId, SystemVo vo) throws Exception
	{
		return delete(sqlId, vo);
	}
}
