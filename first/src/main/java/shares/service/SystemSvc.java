package shares.service;
import java.util.List;
import shares.vo.SystemTableVo;
import shares.vo.SystemVo;

/**
 * 
 * @author	������
 * @date	2015-11-29
 * @tip		�ý���  ���� Service
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-29
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public interface SystemSvc {
	
	// ȯ�ͼ��� ���̺� ����Ʈ(Ȯ�ο�)
	List<SystemTableVo> list(String sqlId, SystemTableVo vo) throws Exception;
	
	// ȯ�漳�� �ڵ� ����Ʈ
	List<SystemVo> list(String sqlId, SystemVo vo) throws Exception;
	
	// ȯ�漳�� ��� ����Ʈ option
	List<SystemVo> list(String sqlId, String value) throws Exception;
	
	// �ڵ� �ߺ� äũ
	String check(String sqlId, SystemVo vo) throws Exception;
	
	// ȯ�漳�� ����
	void insert(String sqlId, SystemVo vo) throws Exception;
	// ȯ�漳�� ����
	void update(String sqlId, SystemVo vo) throws Exception;
	// ȯ�漳�� ����
	void delete(String sqlId, SystemVo vo) throws Exception;
}
