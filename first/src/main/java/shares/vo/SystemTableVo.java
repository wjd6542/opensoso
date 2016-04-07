package shares.vo;


/**
 * @author	rockys
 * @tip		설명 : 시스템 테이블 확인용 value Object 이다 
 * 			1. 생성규칙 : 반드시 접근제어자는 private 이다
 * 			2. 화면단 제어 확장을 위해 CommonVo 를 반드시 상속 받는다
 * 			3. CommonVo 는  파일, 페이징 기본 param, 화면단 처리 data 를 가지고 있음
 * 			4. vo 는 반드시 DB 스키마, view input id,name 과 일치 한다
 * 			5. 컬럼 추가시 반드시 주석 작성한다
 */
public class SystemTableVo extends CommonVo {
	private	String table_name = "";				// 테이블 명
	private	String table_comment = "";			// 테이블 코멘트
	private String column_name = "";			// 컬럼명
	private String column_comment = "";			// 컬럼 코멘트
	private String column_type = "";			// 컬럼 타입
	
	/**
	 * @return the table_name
	 */
	public String getTable_name() {
		return table_name;
	}
	/**
	 * @param table_name the table_name to set
	 */
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	/**
	 * @return the table_comment
	 */
	public String getTable_comment() {
		return table_comment;
	}
	/**
	 * @param table_comment the table_comment to set
	 */
	public void setTable_comment(String table_comment) {
		this.table_comment = table_comment;
	}
	/**
	 * @return the column_name
	 */
	public String getColumn_name() {
		return column_name;
	}
	/**
	 * @param column_name the column_name to set
	 */
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	/**
	 * @return the column_comment
	 */
	public String getColumn_comment() {
		return column_comment;
	}
	/**
	 * @param column_comment the column_comment to set
	 */
	public void setColumn_comment(String column_comment) {
		this.column_comment = column_comment;
	}
	/**
	 * @return the column_type
	 */
	public String getColumn_type() {
		return column_type;
	}
	/**
	 * @param column_type the column_type to set
	 */
	public void setColumn_type(String column_type) {
		this.column_type = column_type;
	}
	
	
}
