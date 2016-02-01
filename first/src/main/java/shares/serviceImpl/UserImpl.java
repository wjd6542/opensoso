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
 * @author	������
 * @date	2015-11-29
 * @tip		���� Impl
 * 			1. DAO , VO ������ü ���� �ּ��� �ݵ�� �ۼ��Ѵ�
 * 			2. �ݵ�� ���� �ּ� �ۼ� ���¸� ���� �Ұ�
 * 			���� DAO	: AbstractDAO
 * 			���� VO	: UserVo
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-29
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
@Service("UserSvc")
public class UserImpl implements UserSvc{
	// �α�
	Logger log = Logger.getLogger(this.getClass());
	// DAO ����
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
