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
	private String column_type = "";			// �÷� Ÿ��
	
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
