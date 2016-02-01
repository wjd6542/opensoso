package shares.vo;

/**
 * @author	rockys
 * @tip		설명 : 파일 value Object 이다 
 * 			1. 생성규칙 : 반드시 접근제어자는 private 이다
 * 			2. 화면단 제어 확장을 위해 CommonVo 를 반드시 상속 받는다
 * 			3. CommonVo 는  파일, 페이징 기본 param, 화면단 처리 data 를 가지고 있음
 *			4. vo 는 반드시 DB 스키마, view input in,name 과 일치 한다
 *			5. 컬럼 추가시 반드시 주석 작성한다
 */
public class FileVo extends CommonVo {
	private String no = "";					// 파일번호
	private String userNo = "";				// 고객번호
	private String borderNo = "";			// 게시물번호
	private String oName = "";				// 원본파일명
	private String fileName = "";			// 저장파일명
	private String fileSize = "";			// 파일사이즈
	
	/**
	 * @return the no
	 */
	public String getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}
	/**
	 * @return the userNo
	 */
	public String getUserNo() {
		return userNo;
	}
	/**
	 * @param userNo the userNo to set
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	/**
	 * @return the borderNo
	 */
	public String getBorderNo() {
		return borderNo;
	}
	/**
	 * @param borderNo the borderNo to set
	 */
	public void setBorderNo(String borderNo) {
		this.borderNo = borderNo;
	}
	/**
	 * @return the oName
	 */
	public String getoName() {
		return oName;
	}
	/**
	 * @param oName the oName to set
	 */
	public void setoName(String oName) {
		this.oName = oName;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the fileSize
	 */
	public String getFileSize() {
		return fileSize;
	}
	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
}
