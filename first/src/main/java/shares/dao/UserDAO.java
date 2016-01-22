package shares.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import shares.dao.AbstractDAO;
import shares.vo.UserVo;

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
@Repository("UserDAO")
public class UserDAO extends AbstractDAO{
	
	/**
	 * ���� �˻� List
	 * @param sqlId
	 * @param value
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, String>> selectUserList(String sqlId, HashMap<String, String> map) throws Exception
	{
		return (ArrayList<HashMap<String, String>>)selectList(sqlId, map);
	}
	
	
	/**
	 * ���� �˻�
	 * @param sqlId
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public UserVo selectUser(String sqlId, UserVo memberVo) throws Exception
	{
		return (UserVo)selectOne(sqlId, memberVo);
	}
	
	/**
	 * ID �ߺ�Ȯ��
	 * @param sqlId
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String idCheck(String sqlId, String value) throws Exception
	{
		return (String)selectOne(sqlId, value);
	}
	
	/**
	 * ���� ī��Ʈ
	 * @param sqlId
	 * @return
	 */
	public Object userTotalcnt(String sqlId) {
		return selectOne(sqlId);
	}
	
	
	/**
	 * ���� ����
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object userInsert(String sqlId, UserVo memberVo) throws Exception
	{
		return insert(sqlId, memberVo);
	}
	
	/**
	 * ���� ����
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object userUpdate(String sqlId, HashMap<String,String> map) throws Exception
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
	public Object userDelete(String sqlId, Map<String,Object> map) throws Exception
	{
		return delete(sqlId, map);
	}
}
