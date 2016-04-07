package shares.vo;


/**
 * @author	rockys
 * @tip		���� : �μ����� value Object �̴�
 * 			1. ������Ģ : �ݵ�� ���������ڴ� private �̴�
 * 			2. ȭ��� ���� Ȯ���� ���� CommonVo �� �ݵ�� ��� �޴´�
 * 			3. CommonVo ��  ����, ����¡ �⺻ param, ȭ��� ó�� data �� ������ ����
 * 			4. vo �� �ݵ�� DB ��Ű��, view input id,name �� ��ġ �Ѵ�
 * 			5. �÷� �߰��� �ݵ�� �ּ� �ۼ��Ѵ�
 */
public class BranchVo extends CommonVo{
	private	String no = "";				// �Խñ� ��ȣ
	private	String name = "";			// �μ���
	private	String code = "";			// �μ��ڵ�
	private	String sort = "";			// ���ļ���
	private	String grupNo = "";			// �׷� ��ȣ
	private	String depthNo = "";		// ����
	private	String memo = "";			// �޸�
	private	String status = "";			// ����
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}
	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	/**
	 * @return the grupNo
	 */
	public String getGrupNo() {
		return grupNo;
	}
	/**
	 * @param grupNo the grupNo to set
	 */
	public void setGrupNo(String grupNo) {
		this.grupNo = grupNo;
	}
	/**
	 * @return the depthNo
	 */
	public String getDepthNo() {
		return depthNo;
	}
	/**
	 * @param depthNo the depthNo to set
	 */
	public void setDepthNo(String depthNo) {
		this.depthNo = depthNo;
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
