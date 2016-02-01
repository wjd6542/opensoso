package shares.serviceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import shares.dao.AbstractDAO;
import shares.service.BranchSvc;

/**
 * 
 * @author	������
 * @date	2015-11-29
 * @tip		�μ� ���� Impl
 * 			1. DAO , VO ������ü ���� �ּ��� �ݵ�� �ۼ��Ѵ�
 * 			2. �ݵ�� ���� �ּ� �ۼ� ���¸� ���� �Ұ�
 * 			���� DAO	: AbstractDAO
 * 			���� VO	: SystemBorderVo
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-29
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
@Service("BranchSvc")
public class BranchImpl implements BranchSvc{
	// �α�
	Logger log = Logger.getLogger(this.getClass());
	// DAO ����
	@Resource(name="AbstractDAO")
	private AbstractDAO abstractDAO;
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<HashMap<String, String>> selectBranchList(String sqlId, HashMap<String, String> map) throws Exception {
		return (ArrayList<HashMap<String, String>>)abstractDAO.selectList(sqlId, map);
	}
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, String> branchSelect(String sqlId, String value) throws Exception {
		return (HashMap<String, String>)abstractDAO.selectList(sqlId, value);
	}
	@Override
	public String checkCode(String sqlId, String value) throws Exception {
		return  "";
	}
	@Override
	public void branchInsert(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.insert(sqlId, map);
	}
	@Override
	public void branchUpdate(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.update(sqlId, map);
	}
	@Override
	public void branchDelete(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.delete(sqlId, map);
	}
	
	
}
