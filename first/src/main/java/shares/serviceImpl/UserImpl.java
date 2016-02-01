package shares.serviceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import shares.dao.AbstractDAO;
import shares.service.UserSvc;
import shares.vo.UserVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		유저 Impl
 * 			1. DAO , VO 참조객체 설명 주석을 반드시 작성한다
 * 			2. 반드시 공용 주석 작성 형태를 참고 할것
 * 			참조 DAO	: AbstractDAO
 * 			참조 VO	: UserVo
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Service("UserSvc")
public class UserImpl implements UserSvc{
	// 로그
	Logger log = Logger.getLogger(this.getClass());
	// DAO 연결
	@Resource(name="AbstractDAO")
	private AbstractDAO abstractDAO;
	
	@SuppressWarnings("unchecked")
	@Override
	public  List<UserVo> selectUserList(String sqlId, HashMap<String, String> map) throws Exception {
		return abstractDAO.selectList(sqlId, map);
	}
	
	@Override
	public int userTotalcnt(String sqlId, HashMap<String, String> map) {
		return (int) abstractDAO.selectOne(sqlId, map);
	}
	
	@Override
	public String idCheck(String sqlId, String value) throws Exception {
		return (String)abstractDAO.selectOne(sqlId, value);
	}
	
	@Override
	public void userInsert(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.insert(sqlId, map);
	}
	
	@Override
	public void userUpdate(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.update(sqlId, map);
	}
	
	@Override
	public void userDelete(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.delete(sqlId, map);
	}

	@Override
	public UserVo userData(String sqlId, Map<String, String> map) throws Exception {
		return (UserVo)abstractDAO.selectOne(sqlId, map);
	}
	
}
