package shares.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author	강정권
 * @date	2015-11-07
 * @tip		게시판관리 DB 연결 DAO
 * <pre>
 * -------- 수정이력 ----------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-07
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Repository("ConfingBorderDAO")
public class ConfingBorderDAO extends AbstractDAO {
	
	// 게시판 리스트
	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String,String>> selectBorderList(String sqlId, HashMap<String,String> map) throws Exception
	{
		return (ArrayList<HashMap<String,String>>)selectList(sqlId, map);
	}
	
	// 게시판 검색
	@SuppressWarnings("unchecked")
	public HashMap<String,String> borderSelect(String sqlId, String value) throws Exception
	{
		return (HashMap<String,String>)selectOne(sqlId, value);
	}
	
	/**
	 * 게시판 중복 확인
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
	 * 게시판 삽입
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
	 * 게시판 수정
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
	 * 게시판삭제
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
