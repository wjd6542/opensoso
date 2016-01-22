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
public class SystemVo extends CommonVo{
	private	String no = "";				// �ý����ڵ� ��ȣ
	private	String systemCode = "";		// �ý���  �ڵ�
	private String code = "";			// �ڵ�
	private String title = "";			// �ڵ� ����
	private String memo = "";			// �޸�
	private String sort = "";			// ���ļ���
	private String status = "";			// ����
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getSystemCode() {
		return systemCode;
	}
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
}
