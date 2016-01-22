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
	
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public String getColumn_comment() {
		return column_comment;
	}
	public void setColumn_comment(String column_comment) {
		this.column_comment = column_comment;
	}
	public String getTable_comment() {
		return table_comment;
	}
	public void setTable_comment(String table_comment) {
		this.table_comment = table_comment;
	}
}
