package shares.vo;

/**
 * @author	rockys
 * @tip		���� : ����� value Object �̴� 
 * 			1. ������Ģ : �ݵ�� ���������ڴ� private �̴�
 * 			2. ȭ��� ���� Ȯ���� ���� CommonVo �� �ݵ�� ��� �޴´�
 * 			3. CommonVo ��  ����, ����¡ �⺻ param, ȭ��� ó�� data �� ������ ����
 *			4. vo �� �ݵ�� DB ��Ű��, view input in,name �� ��ġ �Ѵ�
 *			5. �÷� �߰��� �ݵ�� �ּ� �ۼ��Ѵ�
 */
public class UserVo extends CommonVo {
	private String id = "";				// ���̵�
	private String password = "";		// ��й�ȣ
	private String name = "";			// �̸�
	private String email = "";			// �̸���
	private String phon = "";			// �޴���
	private String gender = "";			// ����
	private String birthday = "";		// �������
	private String hobby = "";			// ���
	private String forte = "";			// Ư��
	private String authority = "";		// ����
	private String status = "";			// �������
	private String imgName = "";		// ���� �̹��� ��
	private String rerelImg = "";		// �����̹��� ��
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhon() {
		return phon;
	}
	public void setPhon(String phon) {
		this.phon = phon;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getForte() {
		return forte;
	}
	public void setForte(String forte) {
		this.forte = forte;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getRerelImg() {
		return rerelImg;
	}
	public void setRerelImg(String rerelImg) {
		this.rerelImg = rerelImg;
	}
}
