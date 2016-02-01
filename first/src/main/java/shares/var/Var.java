package shares.var;

/**
 * 
 * @author	강정권
 * @date	2015-11-07
 * @tip		전역 변수 설정
 * 			SQL ID, 파일 삽입 경로 설정
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2016-01-31
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public class Var {
	
	/* 파일 경로 */
	public static final String filepath = "D:/rocky/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Shares/img/data/";
	
	
	/*============================================
	 * 설명 : 성공여부 출력 코드
	 * resultSucc		: 성공
	 * resultFail		: 실패
	 =============================================*/
	public static final String resultSucc = "SUCC";
	public static final String resultFail = "FAIL";
	
	
	/*============================================
	 * 설명 : 유저 SlqID
	 * selectUserList	: 유저 리스트
	 * selectUser		: 유저 검색(단건) id, pw
	 * selectUserData	: 유저 데이터 검색(단건)
	 * insertUser		: 유저 삽입
	 * updateUser		: 유저 수정
	 * deleteUser		: 유저 삭제
	 * userTotalcnt		: 유저 전체수
	 * userIdCheck		: 유저 ID 중복확인
	 =============================================*/
	public static final String selectUserList = "user.list";
	public static final String selectUser = "user.selectUser";
	public static final String selectUserData = "user.data";
	public static final String insertUser = "user.insertUser";
	public static final String updateUser = "user.updateUser";
	public static final String deleteUser = "user.deleteUser";
	public static final String userTotalcnt = "user.totalcnt";
	public static final String userIdCheck = "user.idCheck";
	
	
	
	/*============================================
	 * 설명 : 시스템 데이블 SlqID
	 * sysTableList	: 테이블 리스트
	 =============================================*/
	public static final String sysTableList = "systemTable.tableList";
	
	
	/*============================================
	 * 설명 : 대분류 코드  SlqID
	 * sysCodeList		: 대분류 코드 리스트
	 * sysCodeCheck		: 대분류 코드 중복확인
	 * sysCodeInsert	: 대분류 코드 삽입
	 * sysCodeUpdate	: 대분류 코드 수정
	 * sysCodeDelete	: 대분류 코드 삭제
	 =============================================*/
	public static final String sysCodeList = "systemCode.list";
	public static final String sysCodeCheck = "systemCode.codeCheck";
	public static final String sysCodeInsert = "systemCode.insert";
	public static final String sysCodeUpdate = "systemCode.update";
	public static final String sysCodeDelete = "systemCode.delete";
	
	
	/*============================================
	 * 설명 : 소분류 코드  SlqID
	 * sysValueList		: 소분류 코드 리스트
	 * sysValueCodeList	: 소분류 코드 리스트(대분휴 검색)
	 * sysValueCheck	: 소분류 코드 중복확인
	 * sysValueInsert	: 소분류 코드 삽입
	 * sysValueUpdate	: 소분류 코드 수정
	 * sysValueDelete	: 소분류 코드 삭제
	 =============================================*/
	public static final String sysValueList = "systemValue.list";
	public static final String sysValueCodeList = "systemValue.codeList";
	public static final String sysValueCheck = "systemValue.codeCheck";
	public static final String sysValueInsert = "systemValue.insert";
	public static final String sysValueUpdate = "systemValue.update";
	public static final String sysValueDelete = "systemValue.delete";
	
	
	/*============================================
	 * 설명 : 게시판 설정  SlqID
	 * sysBorderList	: 게시판 설정 리스트
	 * sysBorderData	: 게시판 설정 데이터
	 * sysBorderInsert	: 게시판 설정 삽입
	 * sysBorderUpdate	: 게시판 설정 수정
	 * sysBorderDelete	: 게시판 설정 삭제
	 =============================================*/
	public static final String sysBorderList = "systemBorder.list";
	public static final String sysBorderData = "systemBorder.data";
	public static final String sysBorderInsert = "systemBorder.insert";
	public static final String sysBorderUpdate = "systemBorder.update";
	public static final String sysBorderDelete = "systemBorder.delete";
	
	
	/*============================================
	 * 설명 : 게시판  SlqID
	 * borderList		: 게시판  리스트
	 * borderMainList	: 메인용 리스트
	 * borderData		: 게시판  데이터
	 * borderMaxNo		: 게시판  번호 최대값
	 * borderMaxGoodCnt	: 게시판 추천수 최대값
	 * borderInsert		: 게시판 삽입
	 * borderUpdate		: 게시판 수정
	 * borderDelete		: 게시판 삭제
	 * borderHitCntUp	: 게시판 조회수 수정
	 * borderGoodCntUp	: 게시판 추천수 수정
	 * borderRippleCntUp: 게시판 리플수 수정
	 * borderGoodCntDown: 게시판 추천수 다운
	 * borderStatusChase: 게시판 상태 변경
	 =============================================*/
	public static final String borderList = "border.list";
	public static final String borderMainList = "border.mainList";
	public static final String borderData = "border.data";
	public static final String borderMaxNo = "border.maxNo";
	public static final String borderTotalCnt = "border.totalCnt";
	public static final String borderMaxGoodCnt = "border.maxGoodCnt";
	public static final String borderInsert = "border.insert";
	public static final String borderUpdate = "border.update";
	public static final String borderDelete = "border.delete";
	public static final String borderHitCntUp = "border.hitCntUp";
	public static final String borderGoodCntUp = "border.goodCntUp";
	public static final String borderRippleCntUp = "border.rippleCntUp";
	public static final String borderGoodCntDown = "border.goodCntDown";
	public static final String borderStatusChase = "border.statusChase";
	
	
	/*============================================
	 * 설명 : 파일  SlqID
	 * fileList			: 파일 리스트
	 * fileData			: 파일 데이터
	 * fileInsert		: 파일 삽입
	 * fileDelete		: 파일 삭제
	 =============================================*/
	public static final String fileList = "file.list";
	public static final String fileData = "file.data";
	public static final String fileInsert = "file.insert";
	public static final String fileDelete = "file.delete";
}
