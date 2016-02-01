package shares.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import shares.vo.UserVo;

/**
 * 
 * @author	������
 * @date	2015-11-29
 * @tip		����  Service
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-29
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public interface UserSvc {
	// ���� �˻�
	List<UserVo> selectUserList(String sqlId, HashMap<String, String> map) throws Exception;
	// ����Ȯ��
	UserVo userData(String sqlId, Map<String, String> paramMap) throws Exception;
	// �ߺ�Ȯ��
	String idCheck(String sqlId, String value) throws Exception;
	// ��ü ���� 
	int userTotalcnt(String sqlId, HashMap<String, String> map);
	// ���� ����
	void userInsert(String sqlId, HashMap<String, String> map) throws Exception;
	// ���� ����
	void userUpdate(String sqlId, HashMap<String, String> map) throws Exception;
	// ���� ����
	void userDelete(String sqlId, HashMap<String, String> map) throws Exception;
}
