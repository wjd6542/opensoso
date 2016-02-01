package shares.util;

/**
 * 
 * @author	강정권
 * @date	2015-10-17
 * @tip		member Controller
 * <pre>
 * -------- 수정이력 ----------
 * 수정자	:	강정권
 * 수정일자	:	2015-10-17
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */

public class Files {
	
	/**
	 * 설명 : 파일 확장자 체크 함수
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
	 * 설명 : 파일사이즈 채크 함수
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
