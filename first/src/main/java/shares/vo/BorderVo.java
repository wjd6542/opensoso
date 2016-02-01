package shares.vo;


/**
 * @author	rockys
 * @tip		���� : �ý���  ��� value Object �̴�
 * 			1. ������Ģ : �ݵ�� ���������ڴ� private �̴�
 * 			2. ȭ��� ���� Ȯ���� ���� CommonVo �� �ݵ�� ��� �޴´�
 * 			3. CommonVo ��  ����, ����¡ �⺻ param, ȭ��� ó�� data �� ������ ����
 * 			4. vo �� �ݵ�� DB ��Ű��, view input in,name �� ��ġ �Ѵ�
 * 			5. �÷� �߰��� �ݵ�� �ּ� �ۼ��Ѵ�
 */
public class BorderVo extends CommonVo{
	private	String no = "";				// �Խñ� ��ȣ
	private	String sysNo = "";			// �Խ��� ���� ��ȣ
	private	String userNo = "";			// �� ��ȣ
	private	String title = "";			// ����
	private	String borderType = "";		// �Խñ� ����
	private	String saveDate = "";		// ��������
	private	String saveTime = "";		// ����ð�
	private	String interest = "";		// ���ɻ�
	private	String hitCnt = "";			// ��ȸ��
	private	String rippleCnt = "";		// ���ü�
	private	String goodCnt = "";		// ��õ��
	private	String memo = "";			// �޸�
	private	String status = "";			// ������ Y : N
	
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
	 * @return the sysNo
	 */
	public String getSysNo() {
		return sysNo;
	}
	/**
	 * @param sysNo the sysNo to set
	 */
	public void setSysNo(String sysNo) {
		this.sysNo = sysNo;
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
	 * @return the borderType
	 */
	public String getBorderType() {
		return borderType;
	}
	/**
	 * @param borderType the borderType to set
	 */
	public void setBorderType(String borderType) {
		this.borderType = borderType;
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
	 * @return the interest
	 */
	public String getInterest() {
		return interest;
	}
	/**
	 * @param interest the interest to set
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}
	/**
	 * @return the hitCnt
	 */
	public String getHitCnt() {
		return hitCnt;
	}
	/**
	 * @param hitCnt the hitCnt to set
	 */
	public void setHitCnt(String hitCnt) {
		this.hitCnt = hitCnt;
	}
	/**
	 * @return the rippleCnt
	 */
	public String getRippleCnt() {
		return rippleCnt;
	}
	/**
	 * @param rippleCnt the rippleCnt to set
	 */
	public void setRippleCnt(String rippleCnt) {
		this.rippleCnt = rippleCnt;
	}
	/**
	 * @return the goodCnt
	 */
	public String getGoodCnt() {
		return goodCnt;
	}
	/**
	 * @param goodCnt the goodCnt to set
	 */
	public void setGoodCnt(String goodCnt) {
		this.goodCnt = goodCnt;
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
