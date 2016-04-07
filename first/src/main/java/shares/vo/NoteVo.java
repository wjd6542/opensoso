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
public class NoteVo extends CommonVo {
	private String no = "";				// ��ȣ
	private String userNo = "";			// ����ȣ
	private String toId = "";			// ������ ��� id
	private String toName = "";			// ������ ���
	private String fromId = "";			// �޴� ��� id
	private String title = "";			// ����
	private String memo = "";			// ����
	private String sendDate = "";		// ���� ��¥
	private String sendTime = "";		// ���� �ð�
	private String readDate = "";		// ���� ��¥
	private String readTime = "";		// ���� �ð�
	private String saveDate = "";		// ��������
	private String saveTime = "";		// ����ð�
	private String saveStatus = "";		// �ϱ���� R : N
	private String status = "";			// ������� Y : N
	
	
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
	 * @return the toId
	 */
	public String getToId() {
		return toId;
	}
	/**
	 * @param toId the toId to set
	 */
	public void setToId(String toId) {
		this.toId = toId;
	}
	/**
	 * @return the toName
	 */
	public String getToName() {
		return toName;
	}
	/**
	 * @param toName the toName to set
	 */
	public void setToName(String toName) {
		this.toName = toName;
	}
	/**
	 * @return the fromId
	 */
	public String getFromId() {
		return fromId;
	}
	/**
	 * @param fromId the fromId to set
	 */
	public void setFromId(String fromId) {
		this.fromId = fromId;
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
	 * @return the sendDate
	 */
	public String getSendDate() {
		return sendDate;
	}
	/**
	 * @param sendDate the sendDate to set
	 */
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	/**
	 * @return the sendTime
	 */
	public String getSendTime() {
		return sendTime;
	}
	/**
	 * @param sendTime the sendTime to set
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * @return the readDate
	 */
	public String getReadDate() {
		return readDate;
	}
	/**
	 * @param readDate the readDate to set
	 */
	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}
	/**
	 * @return the readTime
	 */
	public String getReadTime() {
		return readTime;
	}
	/**
	 * @param readTime the readTime to set
	 */
	public void setReadTime(String readTime) {
		this.readTime = readTime;
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
	 * @return the saveStatus
	 */
	public String getSaveStatus() {
		return saveStatus;
	}
	/**
	 * @param saveStatus the saveStatus to set
	 */
	public void setSaveStatus(String saveStatus) {
		this.saveStatus = saveStatus;
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
