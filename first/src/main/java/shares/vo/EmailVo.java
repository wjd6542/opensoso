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
public class EmailVo extends CommonVo {
	private String no = "";				// ��ȣ
	private String title = "";			// ����
	private String userNo = "";			// ����ȣ
	private String type = "";			// �߼۱���
	private	String toAddr = "";			// �޴� �ּ�
	private	String memo = "";			// �߼۳���
	private String saveDate = "";		// �߼�����
	private String saveTime = "";		// �߼۽ð�
	private String status = "";			// �������
	
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the toAddr
	 */
	public String getToAddr() {
		return toAddr;
	}
	/**
	 * @param toAddr the toAddr to set
	 */
	public void setToAddr(String toAddr) {
		this.toAddr = toAddr;
	}
	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}
	/**
	 * @param memo the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * @return the saveDate
	 */
	public String getSaveDate() {
		return saveDate;
	}
	/**
	 * @param saveDate the saveDate to set
	 */
	public void setSaveDate(String saveDate) {
		this.saveDate = saveDate;
	}
	/**
	 * @return the saveTime
	 */
	public String getSaveTime() {
		return saveTime;
	}
	/**
	 * @param saveTime the saveTime to set
	 */
	public void setSaveTime(String saveTime) {
		this.saveTime = saveTime;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
