package shares.serviceImpl;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import shares.dao.SystemTableDAO;
import shares.dao.SystemDAO;
import shares.service.SystemSvc;
import shares.vo.SystemTableVo;
import shares.vo.SystemVo;


/**
 * 
 * @author	������
 * @date	2015-11-29
 * @tip		�ý��� �ڵ� ���� Service
 * 			1. DAO , VO ������ü ���� �ּ��� �ݵ�� �ۼ��Ѵ�
 * 			2. �ݵ�� ���� �ּ� �ۼ� ���¸� ���� �Ұ�
 * 			���� DAO	: SystemTableDAO, SystemCodeDAO, SystemValueDAO
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
@Service("SystemService")
public class SystemImpl implements SystemSvc{
	// �α�
	Logger log = Logger.getLogger(this.getClass());
	
	// SystemTableDAO ����
	@Resource(name = "SystemTableDAO")
	private SystemTableDAO systemTableDAO;
	
	// SystemDAO ����
	@Resource(name = "SystemDAO")
	private SystemDAO systemDAO;
	
	// �ý��� ���̺� ����Ʈ
	@Override
	public List<SystemTableVo> list(String sqlId, SystemTableVo vo) throws Exception {
		return (List<SystemTableVo>) systemTableDAO.list(sqlId, vo);
	}
	
	// ȯ�漳�� ����Ʈ
	@Override
	public List<SystemVo> list(String sqlId, SystemVo vo) throws Exception { 
		return (List<SystemVo>) systemDAO.list(sqlId, vo);
	}
	
	// ȯ�漳�� ����Ʈ �κ�
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemVo> list(String sqlId, String value) throws Exception {
		return (List<SystemVo>) systemDAO.selectList(sqlId, value);
	}

	// ȯ�漳�� �ڵ� �ߺ�Ȯ��
	@Override
	public String check(String sqlId, String value) throws Exception {
		return (String) systemDAO.selectOne(sqlId, value);
	}
	
	// ȯ�漳�� ����
	@Override
	public void insert(String sqlId, SystemVo vo) throws Exception {
		systemDAO.insert(sqlId, vo);
	}
	
	// ȯ�漳�� ����
	@Override
	public void update(String sqlId, SystemVo vo) throws Exception {
		systemDAO.update(sqlId, vo);
	}

	// ȯ�漳�� ����
	@Override
	public void delete(String sqlId, SystemVo vo) throws Exception {
		systemDAO.delete(sqlId, vo);
	}
}
