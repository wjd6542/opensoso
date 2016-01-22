package shares.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import shares.dao.AbstractDAO;
import shares.vo.UserVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-07
 * @tip		DB 연결 Class
 * <pre>
 * -------- 수정이력 ----------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-07
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Repository("UserDAO")
public class UserDAO extends AbstractDAO{
	
	/**
	 * 유저 검색 List
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
	 * 유저 검색
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
	 * ID 중복확인
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
	 * 유저 카운트
	 * @param sqlId
	 * @return
	 */
	public Object userTotalcnt(String sqlId) {
		return selectOne(sqlId);
	}
	
	
	/**
	 * 유저 삽입
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
	 * 유저 수정
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
	 * 유저 삭제
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
