package shares.util;

/**
 * 
 * @author	������
 * @date	2016-02-28
 * @tip		�弳 ���� �Լ�
 * <pre>
 * -------- �����̷� ----------
 * ������	:	������
 * ��������	:	2016-02-28
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public class BadMessage {
	static String[] badArr = {
		"����","������","�ΰ���","��ģ","��ģ��","��â","����","����","����","���ġ","���ζ�","���","�ù߳�"
	};
	
	
	/**
	 * ���� : �弳 ���� �Լ�
	 * @param msg
	 * @return
	 */
	public static String BadMsgRemove(String msg){
		if(msg != null || msg != "")
		{
			for(String badMsg : badArr)
			{
				msg = msg.replaceAll(badMsg, "");
			}
		}
		return msg;
	}
}
