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
public class SystemBorderVo extends CommonVo{
	private	String no = "";				// �ý����ڵ� ��ȣ
	private String title = "";			// �Խ��� ��
	private String type = "";			// �Խ��� ����
	private String authority = "";		// �Խ��� ����
	private String rippleUser = "";		// ���� �������
	private String fileUser = "";		// ���� �������
	private String sort = "";			// ���ļ���
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getRippleUser() {
		return rippleUser;
	}
	public void setRippleUser(String rippleUser) {
		this.rippleUser = rippleUser;
	}
	public String getFileUser() {
		return fileUser;
	}
	public void setFileUser(String fileUser) {
		this.fileUser = fileUser;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
