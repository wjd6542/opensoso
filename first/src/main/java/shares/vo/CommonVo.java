package shares.vo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author	rockys
 * @tip		���� : ���� value Object �̴� 
 * 			1. view, �⺻ ȭ��� ó�� ��  controll �� �ʿ���  �����͸�  �߰��Ѵ�
 * 			2. ���� Ȯ�� �� ���� CommonVo �� �ݵ�� ��� �Ѵ�
 * 			3. �÷� �߰��� �ݵ�� �ּ� �ۼ��Ѵ�
 */
public class CommonVo {
	private String pageNo = "";				// ������ ��ȣ
	private String actionType = "";			// �׼Ǳ��� ����/����/����
	private String serchType = "";			// �˻� ����
	private String serchString = "";		// �˻� ������
	MultipartFile file;						// ����
	
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
