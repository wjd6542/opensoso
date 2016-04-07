package shares.serviceImpl;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import shares.dao.AbstractDAO;
import shares.service.BranchSvc;
import shares.vo.BranchVo;

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
	public List<BranchVo> list(String sqlId, HashMap<String, String> map) throws Exception {
		return (List<BranchVo>)abstractDAO.selectList(sqlId, map);
	}
	
	@Override
	public BranchVo data(String sqlId, HashMap<String,String> map) throws Exception {
		return (BranchVo)abstractDAO.selectOne(sqlId, map);
	}
	
	@Override
	public String dataNum(String sqlId, HashMap<String, String> map) throws Exception {
		
		return (String) abstractDAO.selectOne(sqlId, map);
	}
	
	@Override
	public String checkCode(String sqlId, String value) throws Exception {
		return  "";
	}
	
	@Override
	public void insert(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.insert(sqlId, map);
	}
	
	@Override
	public void update(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.update(sqlId, map);
	}
	
	@Override
	public void delete(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.delete(sqlId, map);
	}
}
