package shares.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

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
@Repository("AuthorityDAO")
public class AuthorityDAO extends AbstractDAO {
	
	// 권한 리스트
	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String,String>> selectAuthorityList(String sqlId, HashMap<String,String> map) throws Exception
	{
		return (ArrayList<HashMap<String,String>>)selectList(sqlId, map);
	}
	
	// 권한 검색
	@SuppressWarnings("unchecked")
	public HashMap<String,String> authoritySelect(String sqlId, String value) throws Exception
	{
		return (HashMap<String,String>)selectOne(sqlId, value);
	}
	
	/**
	 * 중복 확인
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
	 * 권한 삽입
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
	 * 권한 수정
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
	 * 권한 삭제
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
