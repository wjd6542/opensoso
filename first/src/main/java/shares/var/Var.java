package shares.var;

/**
 * 
 * @author	������
 * @date	2015-11-07
 * @tip		���� ���� ����
 * 			SQL ID, ���� ���� ��� ����
 * <pre>
 * -------- �����̷� --------------
 * ������	:	������
 * ��������	:	2016-01-31
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public class Var {
	
	/* ���� ��� */
	public static final String filepath = "D:/rocky/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Shares/img/data/";
	
	
	/*============================================
	 * ���� : �������� ��� �ڵ�
	 * resultSucc		: ����
	 * resultFail		: ����
	 =============================================*/
	public static final String resultSucc = "SUCC";
	public static final String resultFail = "FAIL";
	
	
	/*============================================
	 * ���� : ���� SlqID
	 * selectUserList	: ���� ����Ʈ
	 * selectUser		: ���� �˻�(�ܰ�) id, pw
	 * selectUserData	: ���� ������ �˻�(�ܰ�)
	 * insertUser		: ���� ����
	 * updateUser		: ���� ����
	 * deleteUser		: ���� ����
	 * userTotalcnt		: ���� ��ü��
	 * userIdCheck		: ���� ID �ߺ�Ȯ��
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
	 * ���� : �ý��� ���̺� SlqID
	 * sysTableList	: ���̺� ����Ʈ
	 =============================================*/
	public static final String sysTableList = "systemTable.tableList";
	
	
	/*============================================
	 * ���� : ��з� �ڵ�  SlqID
	 * sysCodeList		: ��з� �ڵ� ����Ʈ
	 * sysCodeCheck		: ��з� �ڵ� �ߺ�Ȯ��
	 * sysCodeInsert	: ��з� �ڵ� ����
	 * sysCodeUpdate	: ��з� �ڵ� ����
	 * sysCodeDelete	: ��з� �ڵ� ����
	 =============================================*/
	public static final String sysCodeList = "systemCode.list";
	public static final String sysCodeCheck = "systemCode.codeCheck";
	public static final String sysCodeInsert = "systemCode.insert";
	public static final String sysCodeUpdate = "systemCode.update";
	public static final String sysCodeDelete = "systemCode.delete";
	
	
	/*============================================
	 * ���� : �Һз� �ڵ�  SlqID
	 * sysValueList		: �Һз� �ڵ� ����Ʈ
	 * sysValueCodeList	: �Һз� �ڵ� ����Ʈ(����� �˻�)
	 * sysValueCheck	: �Һз� �ڵ� �ߺ�Ȯ��
	 * sysValueInsert	: �Һз� �ڵ� ����
	 * sysValueUpdate	: �Һз� �ڵ� ����
	 * sysValueDelete	: �Һз� �ڵ� ����
	 =============================================*/
	public static final String sysValueList = "systemValue.list";
	public static final String sysValueCodeList = "systemValue.codeList";
	public static final String sysValueCheck = "systemValue.codeCheck";
	public static final String sysValueInsert = "systemValue.insert";
	public static final String sysValueUpdate = "systemValue.update";
	public static final String sysValueDelete = "systemValue.delete";
	
	
	/*============================================
	 * ���� : �Խ��� ����  SlqID
	 * sysBorderList	: �Խ��� ���� ����Ʈ
	 * sysBorderData	: �Խ��� ���� ������
	 * sysBorderInsert	: �Խ��� ���� ����
	 * sysBorderUpdate	: �Խ��� ���� ����
	 * sysBorderDelete	: �Խ��� ���� ����
	 =============================================*/
	public static final String sysBorderList = "systemBorder.list";
	public static final String sysBorderData = "systemBorder.data";
	public static final String sysBorderInsert = "systemBorder.insert";
	public static final String sysBorderUpdate = "systemBorder.update";
	public static final String sysBorderDelete = "systemBorder.delete";
	
	
	/*============================================
	 * ���� : �Խ���  SlqID
	 * borderList		: �Խ���  ����Ʈ
	 * borderMainList	: ���ο� ����Ʈ
	 * borderData		: �Խ���  ������
	 * borderMaxNo		: �Խ���  ��ȣ �ִ밪
	 * borderMaxGoodCnt	: �Խ��� ��õ�� �ִ밪
	 * borderInsert		: �Խ��� ����
	 * borderUpdate		: �Խ��� ����
	 * borderDelete		: �Խ��� ����
	 * borderHitCntUp	: �Խ��� ��ȸ�� ����
	 * borderGoodCntUp	: �Խ��� ��õ�� ����
	 * borderRippleCntUp: �Խ��� ���ü� ����
	 * borderGoodCntDown: �Խ��� ��õ�� �ٿ�
	 * borderStatusChase: �Խ��� ���� ����
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
	 * ���� : ����  SlqID
	 * fileList			: ���� ����Ʈ
	 * fileData			: ���� ������
	 * fileInsert		: ���� ����
	 * fileDelete		: ���� ����
	 =============================================*/
	public static final String fileList = "file.list";
	public static final String fileData = "file.data";
	public static final String fileInsert = "file.insert";
	public static final String fileDelete = "file.delete";
}
