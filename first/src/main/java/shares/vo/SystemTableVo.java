package shares.vo;


/**
 * @author	rockys
 * @tip		���� : �ý��� ���̺� Ȯ�ο� value Object �̴� 
 * 			1. ������Ģ : �ݵ�� ���������ڴ� private �̴�
 * 			2. ȭ��� ���� Ȯ���� ���� CommonVo �� �ݵ�� ��� �޴´�
 * 			3. CommonVo ��  ����, ����¡ �⺻ param, ȭ��� ó�� data �� ������ ����
 * 			4. vo �� �ݵ�� DB ��Ű��, view input id,name �� ��ġ �Ѵ�
 * 			5. �÷� �߰��� �ݵ�� �ּ� �ۼ��Ѵ�
 */
public class SystemTableVo extends CommonVo {
	private	String table_name = "";				// ���̺� ��
	private	String table_comment = "";			// ���̺� �ڸ�Ʈ
	private String column_name = "";			// �÷���
	private String column_comment = "";			// �÷� �ڸ�Ʈ
	
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
