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
@Repository("BranchDAO")
public class BranchDAO extends AbstractDAO {
	// �μ� ����Ʈ
	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String,String>> selectBranchList(String sqlId, HashMap<String,String> map) throws Exception
	{
		return (ArrayList<HashMap<String,String>>)selectList(sqlId, map);
	}
	
	// �μ� �˻�
	@SuppressWarnings("unchecked")
	public HashMap<String,String> branchSelect(String sqlId, String value) throws Exception
	{
		return (HashMap<String,String>)selectOne(sqlId, value);
	}
	
	/**
	 * �μ� Ȯ��
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
	 * �μ� ����
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object branchInsert(String sqlId, HashMap<String,String> map) throws Exception
	{
		return insert(sqlId, map);
	}
	
	/**
	 * �μ� ����
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object branchUpdate(String sqlId, HashMap<String,String> map) throws Exception
	{
		return update(sqlId, map);
	}
	
	/**
	 * �μ� ����
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object branchDelete(String sqlId, Map<String,String> map) throws Exception
	{
		return delete(sqlId, map);
	}
}
