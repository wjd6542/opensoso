package shares.vo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author	rockys
 * @tip		설명 : 공용 value Object 이다 
 * 			1. view, 기본 화면단 처리 및  controll 에 필요한  데이터를  추가한다
 * 			2. 제어 확장 을 위해 CommonVo 를 반드시 상속 한다
 * 			3. 컬럼 추가시 반드시 주석 작성한다
 */
public class CommonVo {
	private String pageNo = "";				// 페이지 번호
	private String actionType = "";			// 액션구분 삽입/수정/삭제
	private String serchType = "";			// 검색 구분
	private String serchString = "";		// 검색 데이터
	MultipartFile file;						// 파일
	
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getSerchType() {
		return serchType;
	}
	public void setSerchType(String serchType) {
		this.serchType = serchType;
	}
	public String getSerchString() {
		return serchString;
	}
	public void setSerchString(String serchString) {
		this.serchString = serchString;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
