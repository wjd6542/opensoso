package shares.service;
import java.util.HashMap;
import java.util.List;
import shares.vo.BranchVo;

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
	List<BranchVo> list(String sqlId,  HashMap<String,String> map) throws Exception;
	// �μ� �˻�
	BranchVo data(String sqlId, HashMap<String,String> map) throws Exception;
	// �ߺ� Ȯ��
	String checkCode(String sqlId, String value) throws Exception;
	// ä��
	String dataNum(String sqlId, HashMap<String,String> map) throws Exception;
	// �μ� ����
	void insert(String sqlId, HashMap<String, String> map) throws Exception;
	// �μ� ����
	void update(String sqlId, HashMap<String, String> map) throws Exception;
	// �μ� ����
	void delete(String sqlId, HashMap<String, String> map) throws Exception;
}
