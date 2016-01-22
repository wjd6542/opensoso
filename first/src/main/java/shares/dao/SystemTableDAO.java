package shares.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import shares.vo.SystemTableVo;

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
@Repository("SystemTableDAO")
public class SystemTableDAO extends AbstractDAO{
	
	/**
	 * 테이블 검색
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SystemTableVo> list(String sqlId, SystemTableVo vo) throws Exception
	{
		return (List<SystemTableVo>)selectList(sqlId, vo);
	}
}
