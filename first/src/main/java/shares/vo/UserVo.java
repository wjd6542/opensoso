package shares.vo;

import org.springframework.stereotype.Service;

/**
 * @author	rockys
 * @tip		설명 : 사용자 value Object 이다 
 * 			1. 생성규칙 : 반드시 접근제어자는 private 이다
 * 			2. 화면단 제어 확장을 위해 CommonVo 를 반드시 상속 받는다
 * 			3. CommonVo 는  파일, 페이징 기본 param, 화면단 처리 data 를 가지고 있음
 *			4. vo 는 반드시 DB 스키마, view input in,name 과 일치 한다
 *			5. 컬럼 추가시 반드시 주석 작성한다
 */

@Service
public class UserVo extends CommonVo {
	private String no = "";				// 고객번호
	private String id = "";				// 아이디
	private String password = "";		// 비밀번호
	private String name = "";			// 이름
	private String nickName = "";		// 별명
	private String email = "";			// 이메일
	private String phon = "";			// 휴대폰
	private String gender = "";			// 성별
	private String birthday = "";		// 생년월일
	private String hobby = "";			// 취믹
	private String forte = "";			// 특기
	private String authority = "";		// 권한
	private String status = "";			// 저장상태
	private String imgName = "";		// 저장 이미지 명
	private String oName = "";			// 원본이미지 명
	private String citation = "";		// 비밀번호 인증번호
	private String noteStatus = "";		// 쪽지 여부
	
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
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	 * @return the citation
	 */
	public String getCitation() {
		return citation;
	}
	/**
	 * @param citation the citation to set
	 */
	public void setCitation(String citation) {
		this.citation = citation;
	}
	
	/**
	 * @return the noteStatus
	 */
	public String getNoteStatus() {
		return noteStatus;
	}
	/**
	 * @param noteStatus the noteStatus to set
	 */
	public void setNoteStatus(String noteStatus) {
		this.noteStatus = noteStatus;
	}
}
