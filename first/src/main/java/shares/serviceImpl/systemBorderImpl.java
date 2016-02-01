package shares.serviceImpl;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import shares.dao.AbstractDAO;
import shares.service.systemBorderSvc;
import shares.vo.SystemBorderVo;

/**
 * 
 * @author	������
 * @date	2015-11-29
 * @tip		�Խ��� ���� Impl
 * 			1. DAO , VO ������ü ���� �ּ��� �ݵ�� �ۼ��Ѵ�
 * 			2. �ݵ�� ���� �ּ� �ۼ� ���¸� ���� �Ұ�
 * 			���� DAO	: BorderDAO
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
@Service("systemBorderSvc")
public class systemBorderImpl implements systemBorderSvc{
	// �α�
	Logger log = Logger.getLogger(this.getClass());
	
	// DAO ����
	@Resource(name="AbstractDAO")
	private AbstractDAO abstractDAO;
	
	
	// �ý��� �Խ��� ����Ʈ
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemBorderVo> borderList(String sqlId, HashMap<String, String> map) throws Exception {
		return (List<SystemBorderVo>) abstractDAO.selectList(sqlId, map);
	}
	
	// �Խ��� ���� �˻�
	@Override
	public SystemBorderVo borderData(String sqlId, HashMap<String, String> map) throws Exception {
		return (SystemBorderVo) abstractDAO.selectOne(sqlId, map);
	}
	
	
	// �Խ��� �ߺ�Ȯ��
	@Override
	public String checkCode(String sqlId, String value) throws Exception {
		return null;
	}
	
	
	// �Խù� ����
	@Override
	public void borderInsert(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.insert(sqlId, map);
	}
	
	
	// �Խù� ����
	@Override
	public void borderUpdate(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.update(sqlId, map);
	}
	
	
	// �Խù� ����
	@Override
	public void borderDelete(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.delete(sqlId, map);
	}
}
