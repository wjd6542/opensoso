package shares.service;
import java.util.HashMap;
import java.util.List;

import shares.vo.AccessVo;


/**
 * 
 * @author	������
 * @date	2016-02-09
 * @tip		���ٰ��� Service
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2015-11-29
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public interface AccessSvc {
	
	// ���ٸ���Ʈ
	List<AccessVo> accessList(String sqlId, HashMap<String, String> map) throws Exception;
	
	// ��ü ī��Ʈ
	int accessCnt(String sqlId, HashMap<String, String> paramMap) throws Exception;
	
	// ���� ����
	void accessInsert(String sqlId, HashMap<String, String> map) throws Exception;
	
	// ���� ����
	void accessDelete(String sqlId, HashMap<String, String> map) throws Exception;
}
