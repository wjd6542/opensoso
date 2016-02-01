package shares.util;

import java.util.HashMap;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Paging {
		private int pageSize;		// 게시 글 수
		private int firstPageNo;	// 첫 번째 페이지 번호
		private int prevPageNo;		// 이전 페이지 번호
		private int startPageNo;	// 시작 페이지 (페이징 네비 기준)
		private int pageNo;			// 페이지 번호
		private int endPageNo;		// 끝 페이지 (페이징 네비 기준)
		private int nextPageNo;		// 다음 페이지 번호
		private int finalPageNo;	// 마지막 페이지 번호
		private int totalCount;		// 게시 글 전체 수
		private int startNo;		// 쿼리 시작번호
		private int endNo;			// 쿼리 끝번호
		
		/**
		 * @return the pageSize
		 */
		public int getPageSize() {
			return pageSize;
		}

		/**
		 * @param pageSize the pageSize to set
		 */
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		/**
		 * @return the firstPageNo
		 */
		public int getFirstPageNo() {
			return firstPageNo;
		}

		/**
		 * @param firstPageNo the firstPageNo to set
		 */
		public void setFirstPageNo(int firstPageNo) {
			this.firstPageNo = firstPageNo;
		}

		/**
		 * @return the prevPageNo
		 */
		public int getPrevPageNo() {
			return prevPageNo;
		}

		/**
		 * @param prevPageNo the prevPageNo to set
		 */
		public void setPrevPageNo(int prevPageNo) {
			this.prevPageNo = prevPageNo;
		}

		/**
		 * @return the startPageNo
		 */
		public int getStartPageNo() {
			return startPageNo;
		}

		/**
		 * @param startPageNo the startPageNo to set
		 */
		public void setStartPageNo(int startPageNo) {
			this.startPageNo = startPageNo;
		}

		/**
		 * @return the pageNo
		 */
		public int getPageNo() {
			return pageNo;
		}

		/**
		 * @param pageNo the pageNo to set
		 */
		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}

		/**
		 * @return the endPageNo
		 */
		public int getEndPageNo() {
			return endPageNo;
		}

		/**
		 * @param endPageNo the endPageNo to set
		 */
		public void setEndPageNo(int endPageNo) {
			this.endPageNo = endPageNo;
		}

		/**
		 * @return the nextPageNo
		 */
		public int getNextPageNo() {
			return nextPageNo;
		}

		/**
		 * @param nextPageNo the nextPageNo to set
		 */
		public void setNextPageNo(int nextPageNo) {
			this.nextPageNo = nextPageNo;
		}

		/**
		 * @return the finalPageNo
		 */
		public int getFinalPageNo() {
			return finalPageNo;
		}

		/**
		 * @param finalPageNo the finalPageNo to set
		 */
		public void setFinalPageNo(int finalPageNo) {
			this.finalPageNo = finalPageNo;
		}

		/**
		 * @return the totalCount
		 */
		public int getTotalCount() {
			return totalCount;
		}

		/**
		 * @param totalCount the totalCount to set
		 */
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
			this.makePaging();
		}
		public int getStartNo() {
			return startNo;
		}

		public void setStartNo(int startNo) {
			this.startNo = startNo;
		}

		public int getEndNo() {
			return endNo;
		}

		public void setEndNo(int endNo) {
			this.endNo = endNo;
		}
		
		/**
		 * 페이징 처리
		 */
		private void makePaging() {
			if (this.totalCount == 0) 
				return;				// 게시 글 전체 수가 없는 경우
			if (this.pageNo == 0) 
				this.setPageNo(1);		// 기본 값 설정
			if (this.pageSize == 0) 
				this.setPageSize(10);	// 기본 값 설정
			
			int finalPage = (totalCount + (pageSize - 1)) / pageSize; // 마지막 페이지
			if (this.pageNo > finalPage) 
				this.setPageNo(finalPage); // 기본 값 설정

			if (this.pageNo < 0 || this.pageNo > finalPage) 
				this.pageNo = 1; // 현재 페이지 유효성 체크

			boolean isNowFirst = pageNo == 1 ? true : false; // 시작 페이지 (전체)
			boolean isNowFinal = pageNo == finalPage ? true : false; // 마지막 페이지 (전체)

			int startPage = ((pageNo - 1) / this.pageSize) * this.pageSize + 1; // 시작 페이지 (페이징 네비 기준)
			int endPage = startPage + this.pageSize - 1; // 끝 페이지 (페이징 네비 기준)

			if (endPage > finalPage)  // [마지막 페이지 (페이징 네비 기준) > 마지막 페이지] 보다 큰 경우
				endPage = finalPage;
			
			
			// firstPage set
			this.setFirstPageNo(1);
			// prevPage set
			if (isNowFirst) 
				this.setPrevPageNo(1); 
			 else 
				this.setPrevPageNo(((pageNo - 1) < 1 ? 1 : (pageNo - 1)));
			
			// startPage set
			this.setStartPageNo(startPage);
			// endPage set
			this.setEndPageNo(endPage); 
			// nextPage set
			if (isNowFinal) 
				this.setNextPageNo(finalPage);
			else
				this.setNextPageNo(((pageNo + 1) > finalPage ? finalPage : (pageNo + 1)));
			
			// lastPage set
			this.setFinalPageNo(finalPage);
			
			// startNum set
			this.setStartNo((this.pageNo - 1) * this.pageSize);
			// endnum  set
			this.setEndNo(this.pageNo + this.pageSize -1);
		}
		
		/**
		 * 페이징 처리
		 * @param pageNo
		 * @param pageSize
		 * @param totalcnt
		 * @param paramMap
		 * @return
		 */
		public HashMap<String,String> setting(int pageNo, int pageSize, int totalcnt, HashMap<String,String> paramMap)
		{
			this.setPageNo(pageNo);
			this.setPageSize(pageSize);
			this.setTotalCount(totalcnt);
			paramMap.put("startNo", String.valueOf(this.getStartNo()));
			paramMap.put("endNo", String.valueOf(this.getEndNo()));
			return paramMap;
		}
		
		
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}
	}