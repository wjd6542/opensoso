package shares.vo;

/**
 * @author	rockys
 * @tip		���� : ���� value Object �̴� 
 * 			1. ������Ģ : �ݵ�� ���������ڴ� private �̴�
 * 			2. ȭ��� ���� Ȯ���� ���� CommonVo �� �ݵ�� ��� �޴´�
 * 			3. CommonVo ��  ����, ����¡ �⺻ param, ȭ��� ó�� data �� ������ ����
 *			4. vo �� �ݵ�� DB ��Ű��, view input in,name �� ��ġ �Ѵ�
 *			5. �÷� �߰��� �ݵ�� �ּ� �ۼ��Ѵ�
 */
public class FileVo extends CommonVo {
	private String no = "";					// ���Ϲ�ȣ
	private String userNo = "";				// ����ȣ
	private String borderNo = "";			// �Խù���ȣ
	private String oName = "";				// �������ϸ�
	private String fileName = "";			// �������ϸ�
	private String fileSize = "";			// ���ϻ�����
	
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
