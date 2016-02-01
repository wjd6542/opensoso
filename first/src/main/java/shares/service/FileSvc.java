package shares.service;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import shares.vo.FileVo;

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
public interface FileSvc {
	// ���� ����Ʈ
	<K, V> List<FileVo> fileList(String sqlId, HashMap<K, V> map) throws Exception;
	// ���ϰ˻�
	FileVo fileData(String sqlId, HashMap<String, Object> map) throws Exception;
	// ���� ����
	void fileInsert(String sqlId, HashMap<String, Object> map, MultipartHttpServletRequest multiRequest) throws Exception;
	// ����  ����
	<K, V> void fileDelete(String sqlId, HashMap<K, V> map) throws Exception;
}
