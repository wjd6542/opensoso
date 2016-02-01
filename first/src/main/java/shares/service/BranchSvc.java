package shares.service;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author	������
 * @date	2015-11-29
 * @tip		�μ� Service
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-29
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public interface BranchSvc {
	// �μ� ����Ʈ
	ArrayList<HashMap<String,String>> selectBranchList(String sqlId,  HashMap<String,String> map) throws Exception;
	// �μ� �˻�
	HashMap<String, String>branchSelect(String sqlId, String value) throws Exception;
	// �ߺ� Ȯ��
	String checkCode(String sqlId, String value) throws Exception;
	// �μ� ����
	void branchInsert(String sqlId, HashMap<String, String> map) throws Exception;
	// �μ� ����
	void branchUpdate(String sqlId, HashMap<String, String> map) throws Exception;
	// �μ� ����
	void branchDelete(String sqlId, HashMap<String, String> map) throws Exception;
}
