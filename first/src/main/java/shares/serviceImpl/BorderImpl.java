package shares.serviceImpl;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import shares.dao.AbstractDAO;
import shares.service.BorderSvc;
import shares.vo.BorderVo;

/**
 * 
 * @author	������
 * @date	2015-11-29
 * @tip		�Խ��� ���� Impl
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
@Service("BorderSvc")
public class BorderImpl implements BorderSvc{
	// �α�
	Logger log = Logger.getLogger(this.getClass());
	
	// DAO ����
	@Resource(name="AbstractDAO")
	private AbstractDAO abstractDAO;
	
	
	// �ý��� �Խ��� ����Ʈ
	@SuppressWarnings("unchecked")
	@Override
	public List<BorderVo> borderList(String sqlId, HashMap<String, String> map) throws Exception {
		return (List<BorderVo>) abstractDAO.selectList(sqlId, map);
	}
	
	
	// �Խ��� ���� �˻�
	@Override
	public BorderVo borderData(String sqlId, HashMap<String, String> map) throws Exception {
		return (BorderVo) abstractDAO.selectOne(sqlId, map);
	}
	
	
	// �Խ��� �ߺ�Ȯ��
	@Override
	public String checkCode(String sqlId, String value) throws Exception {
		return (String)abstractDAO.selectOne(sqlId, value);
	}
	
	
	// �Խ��� �Խñ� �ִ��ȣ �˻�
	@Override
	public String maxNo(String sqlId) throws Exception {
		return (String)abstractDAO.selectOne(sqlId);
	}
	
	
	// cnt �˻�
	@Override
	public String selectCnt(String sqlId, HashMap<String, String> map) throws Exception {
		return (String)abstractDAO.selectOne(sqlId, map);
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
