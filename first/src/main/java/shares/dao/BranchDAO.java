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
@Repository("BranchDAO")
public class BranchDAO extends AbstractDAO {
	// 부서 리스트
	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String,String>> selectBranchList(String sqlId, HashMap<String,String> map) throws Exception
	{
		return (ArrayList<HashMap<String,String>>)selectList(sqlId, map);
	}
	
	// 부서 검색
	@SuppressWarnings("unchecked")
	public HashMap<String,String> branchSelect(String sqlId, String value) throws Exception
	{
		return (HashMap<String,String>)selectOne(sqlId, value);
	}
	
	/**
	 * 부서 확인
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
	 * 부서 삽입
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
	 * 부서 수정
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
	 * 부서 삭제
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
