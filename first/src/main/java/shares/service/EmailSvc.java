package shares.service;
import java.util.HashMap;
import java.util.List;
import shares.vo.EmailVo;


/**
 * 
 * @author	������
 * @date	2016-02-09
 * @tip		�̸��ϰ��� Service
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-29
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public interface EmailSvc {
	
	// �̸��ϸ���Ʈ
	List<EmailVo> list(String sqlId, HashMap<String, String> map) throws Exception;
	
	// �̸��� ������
	EmailVo data(String sqlId, HashMap<String, String> map) throws Exception;
	
	// ��ü ī��Ʈ
	int totalCnt(String sqlId, HashMap<String, String> paramMap) throws Exception;
	
	// �̸��� ����
	void insert(String sqlId, HashMap<String, String> map) throws Exception;
	
	// �̸��� ����
	void delete(String sqlId, HashMap<String, String> map) throws Exception;
}
