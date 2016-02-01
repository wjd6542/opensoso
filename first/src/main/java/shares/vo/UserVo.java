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
	private String no = "";				// ����ȣ
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
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phon
	 */
	public String getPhon() {
		return phon;
	}
	/**
	 * @param phon the phon to set
	 */
	public void setPhon(String phon) {
		this.phon = phon;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the hobby
	 */
	public String getHobby() {
		return hobby;
	}
	/**
	 * @param hobby the hobby to set
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	/**
	 * @return the forte
	 */
	public String getForte() {
		return forte;
	}
	/**
	 * @param forte the forte to set
	 */
	public void setForte(String forte) {
		this.forte = forte;
	}
	/**
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}
	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
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
	/**
	 * @return the imgName
	 */
	public String getImgName() {
		return imgName;
	}
	/**
	 * @param imgName the imgName to set
	 */
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	/**
	 * @return the rerelImg
	 */
	public String getRerelImg() {
		return rerelImg;
	}
	/**
	 * @param rerelImg the rerelImg to set
	 */
	public void setRerelImg(String rerelImg) {
		this.rerelImg = rerelImg;
	}
}
