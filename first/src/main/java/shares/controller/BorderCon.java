package shares.controller;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import shares.service.BorderSvc;
import shares.service.FileSvc;
import shares.service.SystemSvc;
import shares.service.UserSvc;
import shares.service.SystemBorderSvc;
import shares.util.BadMessage;
import shares.util.Function;
import shares.util.Paging;
import shares.var.Var;
import shares.vo.BorderVo;
import shares.vo.FileVo;
import shares.vo.SystemBorderVo;
import shares.vo.SystemVo;
import shares.vo.UserVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-07
 * @tip		게시판 Controller
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-07
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Controller
public class BorderCon {
	// 로거
	Logger log = Logger.getLogger(this.getClass());
	
	// 게시판 관리 서비스 연결
	@Resource(name="SystemBorderSvc")
	private SystemBorderSvc systemBorderSvc;
	
	// 유저 서비스 연결
	@Resource(name="UserSvc")
	private UserSvc userSvc;
	
	// 게시판 서비스 연결
	@Resource(name="BorderSvc")
	private BorderSvc borderSvc;
	
	// 시스템 서비스 연결
	@Resource(name="SystemSvc")
	private SystemSvc systemSvc;
	
	// 파일 서비스 연결
	@Resource(name="FileSvc")
	private FileSvc fileSvc;
	
	// 페이징
	Paging paging = new Paging();
	
	/**
	 * 설명 : 게시판 리스트
	 * @param paramMap
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/borderList.do")
	public ModelAndView borderList(@RequestParam HashMap<String, String> paramMap, 
			@RequestParam(value="pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value="pageSize", defaultValue = "10") int pageSize,
			@RequestParam(value="totalcnt", defaultValue = "0") int totalcnt,
			@RequestParam(value="order", defaultValue = "bno") String order,
			ModelAndView mv) throws Exception{
		
		/*================ data setting str =================
		 * borderVo			: 게시판 설정 변수
		 * borderList		: 게시판 리스트 변수
		 * typeMap			: 게시판 구분 설정 리스트
		 * typeTitle		: 게시판 제목
		 ================= data setting end =================*/
		// 페이징 처리
		String cnt = borderSvc.selectCnt(Var.borderTotalCnt, paramMap);
		if(cnt == null) cnt = "0";
		totalcnt = Integer.parseInt(cnt);
		paramMap = paging.setting(pageNo, pageSize, totalcnt, paramMap);
		SystemBorderVo borderVo = systemBorderSvc.borderData(Var.sysBorderData, paramMap);
		List<BorderVo> borderList = borderSvc.borderList(Var.borderList, paramMap);
		List<SystemVo> typeMap = systemSvc.list(Var.sysValueCodeList, "borderType");
		String typeTitle = Function.sysMapping(typeMap, paramMap.get("borderType"));
		List<SystemVo> serchMap = systemSvc.list(Var.sysValueCodeList, "borderSerch");
		
		/*================ View data setting str =================
		 * typeTitle		: 계시판 구분 title
		 * borderVo			: 게시판 설정
		 * borderList		: 게시판 리스트
		 * searchString		: 검색 입력
		 ================= View data setting end =================*/
		mv.addObject("search",  Function.sysOption(serchMap, paramMap.get("search")));
		mv.addObject("searchString",  paramMap.get("searchString"));
		mv.addObject("order", order);
		mv.addObject("typeTitle", typeTitle);
		mv.addObject("borderConf", borderVo);
		mv.addObject("borderList", borderList);
		mv.addObject("pageNo", pageNo);
		mv.addObject("pageSize", pageSize);
		mv.addObject("paging", paging);
		mv.addObject("borderType",  paramMap.get("borderType"));
		mv.setViewName("/border/list");
		return mv;
	}
	
	
	/**
	 * 설명 : 게시물 확인 페이지
	 * @param paramMap
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/borderView.do")
	public ModelAndView borderView(@RequestParam HashMap<String, String> paramMap, ModelAndView mv) throws Exception{
		String borderType = paramMap.get("borderType");
		SystemBorderVo borderVo = systemBorderSvc.borderData(Var.sysBorderData, paramMap);
		borderSvc.borderUpdate(Var.borderHitCntUp, paramMap);
		BorderVo border = borderSvc.borderData(Var.borderData, paramMap);
		paramMap.put("userNo", border.getUserNo());
		UserVo userInfo = userSvc.userData(Var.selectUserData, paramMap);
		List<FileVo> fileList = fileSvc.fileList(Var.fileDataList, paramMap);
		
		mv.addObject("borderConf", borderVo);
		mv.addObject("userInfo", userInfo);
		mv.addObject("border", border);
		mv.addObject("fileList", fileList);
		mv.addObject("borderType", borderType);
		mv.setViewName("/border/view");
		return mv;
	}
	
	
	/**
	 * 설명 : 게시판 작성 페이지
	 * @param paramMap
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/borderWrite.do")
	public ModelAndView borderWiter(@RequestParam HashMap<String, String> paramMap, ModelAndView mv) throws Exception{
		String actionType = "", btnNm = "", interest = "";
		SystemBorderVo borderVo = systemBorderSvc.borderData(Var.sysBorderData, paramMap);
		List<SystemVo> interestMap = systemSvc.list(Var.sysValueCodeList, "borderWriterType");
		String borderNo = paramMap.get("borderNo");
		String borderType = paramMap.get("borderType");
		BorderVo border = null;
		List<FileVo> fileList = null;
		
		if(borderNo == null || borderNo == ""){
			interest = Function.sysOption(interestMap, "");
			actionType = "insert";
			btnNm = "등록";
		}else{
			border = borderSvc.borderData(Var.borderData, paramMap);
			fileList = fileSvc.fileList(Var.fileList, paramMap);
			interest = Function.sysOption(interestMap, border.getInterest());
			actionType = "update";
			btnNm = "수정";
		}
		
		mv.addObject("fileList", fileList);
		mv.addObject("border", border);
		mv.addObject("borderConf", borderVo);
		mv.addObject("interest", interest);
		mv.addObject("actionType", actionType);
		mv.addObject("btnNm", btnNm);
		mv.addObject("borderNo", borderNo);
		mv.addObject("borderType", borderType);
		mv.setViewName("/border/write");
		return mv;
	}
	
	
	/**
	 * 설명 : 게시판 내용 삽입
	 * @param paramMap
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/borderAction.do")
	public ModelAndView borderView(@RequestParam HashMap<String, String> paramMap, 
			MultipartHttpServletRequest multiRequest) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		List<MultipartFile> mf = multiRequest.getFiles("file");
		String actionType = paramMap.get("actionType");
		String userNo = paramMap.get("userNo");
		String memo = paramMap.get("memo");
		String msg = "";
		String borderNo = "";
		
		// 욕설 방지
		paramMap.put("memo", BadMessage.BadMsgRemove(memo));
		
		try{
			// 게시판 action
			if(actionType.equals("insert")){
				borderSvc.borderInsert(Var.borderInsert, paramMap);
				borderNo = borderSvc.maxNo(Var.borderMaxNo);
				msg = "등록";
			}else if(actionType.equals("update")){
				borderSvc.borderUpdate(Var.borderUpdate, paramMap);
				borderNo = paramMap.get("borderNo");
				msg = "수정";
			}else if(actionType.equals("delete")){
				borderSvc.borderDelete(Var.borderDelete, paramMap);
				File file = new File(Var.filePath + paramMap.get("filename"));
				file.delete();
				msg = "삭제";
			}
			
			// 파일 action
			if(mf.size() == 0 || mf.get(0).getOriginalFilename().equals("")){
				
			}else{
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("borderNo", borderNo);
				map.put("userNo", userNo);
				fileSvc.fileInsert(Var.fileInsert, map, multiRequest);
			}
			
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "게시물 "+ msg +"에 성공 하였습니다.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "게시물 "+ msg +"에 실패 하였습니다.");
		}
		
		return mv;
	}
	
	
	/**
	 * 설명 : 추천수 설정
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/GoodCntAction.do")
	public ModelAndView hitCntUp(@RequestParam HashMap<String, String> paramMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		String actionType = paramMap.get("actionType");
		String msg = "";
		String goodCnt = "";
		try{
			if(actionType.equals("goodCntUp")){
				borderSvc.borderUpdate(Var.borderGoodCntUp, paramMap);
				goodCnt = borderSvc.selectCnt(Var.borderMaxGoodCnt, paramMap);
				msg = "추천 되었습니다.";
			}else if(actionType.equals("goodCntDown")){
				borderSvc.borderUpdate(Var.borderGoodCntDown, paramMap);
				goodCnt = borderSvc.selectCnt(Var.borderMaxGoodCnt, paramMap);
				msg = "비추천 되었습니다.";
			}
			
			mv.addObject("code", "SUCC");
			mv.addObject("msg", msg);
			mv.addObject("goodCnt", goodCnt);
			
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "처리 에 실패 하였습니다.");
		}
		return mv;
	}
	
	
	/**
	 * 설명 : 게시물 비공개 처리
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/borderSecret.do")
	public ModelAndView borderSecret(@RequestParam HashMap<String, String> paramMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		try{
			borderSvc.borderUpdate(Var.borderStatusChase, paramMap);
			mv.addObject("code", "SUCC");
			mv.addObject("msg", "비공개 처리 되었습니다.");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("code", "FAIL");
			mv.addObject("msg", "처리 에 실패 하였습니다.");
		}
		return mv;
	}
}