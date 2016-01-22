package shares.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import shares.vo.SystemVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-07
 * @tip		DB 연결 Class
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-07
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Repository("SystemDAO")
public class SystemDAO extends AbstractDAO{
	
	/**
	 * 코드 리스트 검색
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
	 * 코드 검색
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
	 * 코드 중복확인
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
	 * 코드 삽입
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
	 * 코드 수정
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
	 * 코드 삭제
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
