package shares.service;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author	������
 * @date	2015-11-29
 * @tip		���� Service
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-29
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public interface AuthoritySvc {
	// ���� ����Ʈ
	ArrayList<HashMap<String,String>> selectAuthorityList(String sqlId,  HashMap<String,String> map) throws Exception;
	// ���� �˻�
	HashMap<String, String>authoritySelect(String sqlId,  HashMap<String,String> map) throws Exception;
	// �ߺ� Ȯ��
	String checkCode(String sqlId, String value) throws Exception;
	// ���� ����
	void authorityInsert(String sqlId, HashMap<String, String> map) throws Exception;
	// ���� ����
	void authorityUpdate(String sqlId, HashMap<String, String> map) throws Exception;
	// ���� ����
	void authorityDelete(String sqlId, HashMap<String, String> map) throws Exception;
}
