package shares.service;
import java.util.HashMap;
import java.util.List;
import shares.vo.BorderVo;

/**
 * 
 * @author	������
 * @date	2015-11-29
 * @tip		�Խ��� Service
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-29
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public interface BorderSvc {
	// �Խ��� ����Ʈ
	List<BorderVo> borderList(String sqlId,  HashMap<String,String> map) throws Exception;
	// �Խ��� ����
	BorderVo borderData(String sqlId,  HashMap<String,String> map) throws Exception;
	// �ߺ� Ȯ��
	String checkCode(String sqlId, String value) throws Exception;
	// �ִ밪 �˻�
	String maxNo(String sqlId) throws Exception;
	// ��õ�� �˻�
	String selectCnt(String sqlId, HashMap<String, String> map) throws Exception;
	// �Խ��� ����
	void borderInsert(String sqlId, HashMap<String, String> map) throws Exception;
	// �Խ��� ����
	void borderUpdate(String sqlId, HashMap<String, String> map) throws Exception;
	// �Խ��� ����
	void borderDelete(String sqlId, HashMap<String, String> map) throws Exception;
}
