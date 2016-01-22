package shares.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author	������
 * @date	2015-11-07
 * @tip		DB ���� Class
 * <pre>
 * -------- �����̷� ----------
 * ������	:	������
 * ��������	:	2015-11-07
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
@Repository("AuthorityDAO")
public class AuthorityDAO extends AbstractDAO {
	
	// ���� ����Ʈ
	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String,String>> selectAuthorityList(String sqlId, HashMap<String,String> map) throws Exception
	{
		return (ArrayList<HashMap<String,String>>)selectList(sqlId, map);
	}
	
	// ���� �˻�
	@SuppressWarnings("unchecked")
	public HashMap<String,String> authoritySelect(String sqlId, String value) throws Exception
	{
		return (HashMap<String,String>)selectOne(sqlId, value);
	}
	
	/**
	 * �ߺ� Ȯ��
	 * @param sqlId
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String checkCode(String sqlId, String value) throws Exception
	{
		return (String)selectOne(sqlId, value);
	}
	
	
	/**
	 * ���� ����
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object authorityInsert(String sqlId, HashMap<String,String> map) throws Exception
	{
		return insert(sqlId, map);
	}
	
	/**
	 * ���� ����
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object authorityUpdate(String sqlId, HashMap<String,String> map) throws Exception
	{
		return update(sqlId, map);
	}
	
	/**
	 * ���� ����
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object authorityDelete(String sqlId, Map<String,Object> map) throws Exception
	{
		return delete(sqlId, map);
	}
}
