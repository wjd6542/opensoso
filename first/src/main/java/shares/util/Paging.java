package shares.util;

import java.util.HashMap;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Paging {
		private int pageSize;		// �Խ� �� ��
		private int firstPageNo;	// ù ��° ������ ��ȣ
		private int prevPageNo;		// ���� ������ ��ȣ
		private int startPageNo;	// ���� ������ (����¡ �׺� ����)
		private int pageNo;			// ������ ��ȣ
		private int endPageNo;		// �� ������ (����¡ �׺� ����)
		private int nextPageNo;		// ���� ������ ��ȣ
		private int finalPageNo;	// ������ ������ ��ȣ
		private int totalCount;		// �Խ� �� ��ü ��
		private int startNo;		// ���� ���۹�ȣ
		private int endNo;			// ���� ����ȣ
		
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
		 * ����¡ ó��
		 */
		private void makePaging() {
			if (this.totalCount == 0) 
				return;				// �Խ� �� ��ü ���� ���� ���
			if (this.pageNo == 0) 
				this.setPageNo(1);		// �⺻ �� ����
			if (this.pageSize == 0) 
				this.setPageSize(10);	// �⺻ �� ����
			
			int finalPage = (totalCount + (pageSize - 1)) / pageSize; // ������ ������
			if (this.pageNo > finalPage) 
				this.setPageNo(finalPage); // �⺻ �� ����

			if (this.pageNo < 0 || this.pageNo > finalPage) 
				this.pageNo = 1; // ���� ������ ��ȿ�� üũ

			boolean isNowFirst = pageNo == 1 ? true : false; // ���� ������ (��ü)
			boolean isNowFinal = pageNo == finalPage ? true : false; // ������ ������ (��ü)

			int startPage = ((pageNo - 1) / this.pageSize) * this.pageSize + 1; // ���� ������ (����¡ �׺� ����)
			int endPage = startPage + this.pageSize - 1; // �� ������ (����¡ �׺� ����)

			if (endPage > finalPage)  // [������ ������ (����¡ �׺� ����) > ������ ������] ���� ū ���
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
		 * ����¡ ó��
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