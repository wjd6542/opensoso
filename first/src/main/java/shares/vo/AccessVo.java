package shares.vo;

/**
 * @author	rockys
 * @tip		설명 : 파일 value Object 이다 
 * 			1. 생성규칙 : 반드시 접근제어자는 private 이다
 * 			2. 화면단 제어 확장을 위해 CommonVo 를 반드시 상속 받는다
 * 			3. CommonVo 는  파일, 페이징 기본 param, 화면단 처리 data 를 가지고 있음
 *			4. vo 는 반드시 DB 스키마, view input in,name 과 일치 한다
 *			5. 컬럼 추가시 반드시 주석 작성한다
 */
public class AccessVo extends CommonVo {
	private String no = "";				// 번호
	private String path = "";			// 접근경로
	private String type = "";			// 접근구분
	private String ip = "";				// 접근아이피
	private	String name = "";			// 이름
	private String saveDate = "";		// 접근일자
	private String saveTime = "";		// 접근시간
	private String status = "";			// 저장상태
	
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
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
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
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
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
