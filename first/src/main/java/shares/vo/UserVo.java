package shares.vo;

/**
 * @author	rockys
 * @tip		설명 : 사용자 value Object 이다 
 * 			1. 생성규칙 : 반드시 접근제어자는 private 이다
 * 			2. 화면단 제어 확장을 위해 CommonVo 를 반드시 상속 받는다
 * 			3. CommonVo 는  파일, 페이징 기본 param, 화면단 처리 data 를 가지고 있음
 *			4. vo 는 반드시 DB 스키마, view input in,name 과 일치 한다
 *			5. 컬럼 추가시 반드시 주석 작성한다
 */
public class UserVo extends CommonVo {
	private String id = "";				// 아이디
	private String password = "";		// 비밀번호
	private String name = "";			// 이름
	private String email = "";			// 이메일
	private String phon = "";			// 휴대폰
	private String gender = "";			// 성별
	private String birthday = "";		// 생년월일
	private String hobby = "";			// 취믹
	private String forte = "";			// 특기
	private String authority = "";		// 권한
	private String status = "";			// 저장상태
	private String imgName = "";		// 저장 이미지 명
	private String rerelImg = "";		// 원본이미지 명
	
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
