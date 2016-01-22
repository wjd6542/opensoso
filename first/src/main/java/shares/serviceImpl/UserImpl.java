package shares.serviceImpl;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import shares.dao.UserDAO;
import shares.service.UserSvc;
import shares.vo.UserVo;



@Service("UserService")
public class UserImpl implements UserSvc{
	// 로그
	Logger log = Logger.getLogger(this.getClass());
	// DAO 연결
	@Resource(name="UserDAO")
	private UserDAO userDAO;
	
	@SuppressWarnings("unchecked")
	@Override
	public  List<UserVo> selectUserList(String sqlId, HashMap<String, String> map) throws Exception {
		return userDAO.selectList(sqlId, map);
	}
	
	@Override
	public UserVo selectUser(String sqlId, UserVo memberVo) throws Exception {
		return userDAO.selectUser(sqlId, memberVo);
	}
	
	@Override
	public int userTotalcnt(String sqlId) {
		return (int) userDAO.userTotalcnt(sqlId);
	}
	
	@Override
	public String idCheck(String sqlId, String value) throws Exception {
		return  userDAO.idCheck(sqlId, value);
	}
	
	@Override
	public void userInsert(String sqlId, HashMap<String, String> map) throws Exception {
		userDAO.insert(sqlId, map);
	}
	
	@Override
	public void userUpdate(String sqlId, HashMap<String, String> map) throws Exception {
		userDAO.update(sqlId, map);
	}
	
	@Override
	public void userDelete(String sqlId, HashMap<String, String> map) throws Exception {
		userDAO.delete(sqlId, map);
	}
	
}
