package shares.service;
import java.util.HashMap;
import java.util.List;
import shares.vo.SystemBorderVo;

/**
 * 
 * @author	������
 * @date	2015-11-29
 * @tip		�Խ��� ���� Service
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-29
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public interface systemBorderSvc {
	// �Խ��� ����Ʈ
	List<SystemBorderVo> borderList(String sqlId,  HashMap<String,String> map) throws Exception;
	
	SystemBorderVo borderData(String sqlId,  HashMap<String,String> map) throws Exception;
	
	// �ߺ� Ȯ��
	String checkCode(String sqlId, String value) throws Exception;
	// �Խ��� ����
	void borderInsert(String sqlId, HashMap<String, String> map) throws Exception;
	// �Խ��� ����
	void borderUpdate(String sqlId, HashMap<String, String> map) throws Exception;
	// �Խ��� ����
	void borderDelete(String sqlId, HashMap<String, String> map) throws Exception;
}
