package shares.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author	������
 * @date	2015-11-07
 * @tip		�Խ��ǰ��� DB ���� DAO
 * <pre>
 * -------- �����̷� ----------
 * ������	:	������
 * ��������	:	2015-11-07
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
@Repository("ConfingBorderDAO")
public class ConfingBorderDAO extends AbstractDAO {
	
	// �Խ��� ����Ʈ
	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String,String>> selectBorderList(String sqlId, HashMap<String,String> map) throws Exception
	{
		return (ArrayList<HashMap<String,String>>)selectList(sqlId, map);
	}
	
	// �Խ��� �˻�
	@SuppressWarnings("unchecked")
	public HashMap<String,String> borderSelect(String sqlId, String value) throws Exception
	{
		return (HashMap<String,String>)selectOne(sqlId, value);
	}
	
	/**
	 * �Խ��� �ߺ� Ȯ��
	 * @param sqlId
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String borderCheck(String sqlId, String value) throws Exception
	{
		return (String)selectOne(sqlId, value);
	}
	
	
	/**
	 * �Խ��� ����
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object borderInsert(String sqlId, HashMap<String,String> map) throws Exception
	{
		return insert(sqlId, map);
	}
	
	/**
	 * �Խ��� ����
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object borderUpdate(String sqlId, HashMap<String,String> map) throws Exception
	{
		return update(sqlId, map);
	}
	
	/**
	 * �Խ��ǻ���
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object borderDelete(String sqlId, Map<String,Object> map) throws Exception
	{
		return delete(sqlId, map);
	}
}
