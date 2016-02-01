package shares.util;

/**
 * 
 * @author	������
 * @date	2015-10-17
 * @tip		member Controller
 * <pre>
 * -------- �����̷� ----------
 * ������	:	������
 * ��������	:	2015-10-17
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */

public class Files {
	
	/**
	 * ���� : ���� Ȯ���� üũ �Լ�
	 * @param extension
	 * @return
	 */
	public static boolean fileExtensionCheck(String extension){
		String[] badExtension = {".java",".jsp",".php",".asp",".exe",".perl",".torrent"};
		for(String key : badExtension){
			if(extension.equalsIgnoreCase(key)){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * ���� : ���ϻ����� äũ �Լ�
	 * @param size
	 * @return
	 */
	public static boolean fileSizeCheck(long size){
		if(100000000 <= size){
			return true;
		}
		return false;
	}
	
}
