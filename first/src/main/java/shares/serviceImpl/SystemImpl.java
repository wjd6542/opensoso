package shares.serviceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import shares.dao.AbstractDAO;
import shares.service.SystemSvc;
import shares.vo.SystemTableVo;
import shares.vo.SystemVo;

/**
 * 
 * @author	������
 * @date	2015-11-29
 * @tip		�ý���  ���� Impl
 * 			1. DAO , VO ������ü ���� �ּ��� �ݵ�� �ۼ��Ѵ�
 * 			2. �ݵ�� ���� �ּ� �ۼ� ���¸� ���� �Ұ�
 * 			���� DAO	: AbstractDAO
 * 			���� VO	: SystemTableVo, SystemCodeVo, SystemValueVo
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-29
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
@Service("SystemSvc")
public class SystemImpl implements SystemSvc{
	// �α�
	Logger log = Logger.getLogger(this.getClass());
	
	// SystemTableDAO ����
	@Resource(name = "AbstractDAO")
	private AbstractDAO abstractDAO;
	
	// �ý��� ���̺� ����Ʈ
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemTableVo> list(String sqlId, SystemTableVo vo) throws Exception {
		return (List<SystemTableVo>) abstractDAO.selectList(sqlId, vo);
	}
	
	// ȯ�漳�� ����Ʈ
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemVo> list(String sqlId, SystemVo vo) throws Exception { 
		return (List<SystemVo>) abstractDAO.selectList(sqlId, vo);
	}
	
	// ȯ�漳�� ����Ʈ �κ�
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemVo> list(String sqlId, String value) throws Exception {
		return (List<SystemVo>) abstractDAO.selectList(sqlId, value);
	}

	// ȯ�漳�� �ڵ� �ߺ�Ȯ��
	@Override
	public String check(String sqlId, String value) throws Exception {
		return (String) abstractDAO.selectOne(sqlId, value);
	}
	
	// ȯ�漳�� ����
	@Override
	public void insert(String sqlId, SystemVo vo) throws Exception {
		abstractDAO.insert(sqlId, vo);
	}
	
	// ȯ�漳�� ����
	@Override
	public void update(String sqlId, SystemVo vo) throws Exception {
		abstractDAO.update(sqlId, vo);
	}

	// ȯ�漳�� ����
	@Override
	public void delete(String sqlId, SystemVo vo) throws Exception {
		abstractDAO.delete(sqlId, vo);
	}
}
