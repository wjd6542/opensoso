package shares.serviceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import shares.dao.AbstractDAO;
import shares.service.AuthoritySvc;

/**
 * 
 * @author	������
 * @date	2015-11-29
 * @tip		���� ���� Impl
 * 			1. DAO , VO ������ü ���� �ּ��� �ݵ�� �ۼ��Ѵ�
 * 			2. �ݵ�� ���� �ּ� �ۼ� ���¸� ���� �Ұ�
 * 			���� DAO	: AbstractDAO
 * 			���� VO	: BorderVo
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-29
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
@Service("AuthoritySvc")
public class AuthorityImpl implements AuthoritySvc{
	// �α�
	Logger log = Logger.getLogger(this.getClass());
	// DAO ����
	@Resource(name="AbstractDAO")
	private AbstractDAO abstractDAO;
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<HashMap<String, String>> selectAuthorityList(String sqlId, HashMap<String, String> map) throws Exception {
		return (ArrayList<HashMap<String, String>>)abstractDAO.selectList(sqlId, map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, String> authoritySelect(String sqlId, HashMap<String, String> map) throws Exception {
		return (HashMap<String, String>)abstractDAO.selectOne(sqlId, map);
	}

	@Override
	public String checkCode(String sqlId, String value) throws Exception {
		return (String)abstractDAO.selectOne(sqlId, value);
	}

	@Override
	public void authorityInsert(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.insert(sqlId, map);
	}
	
	@Override
	public void authorityUpdate(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.update(sqlId, map);
	}

	@Override
	public void authorityDelete(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.delete(sqlId, map);
	}
}
