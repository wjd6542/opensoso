package shares.util;
import javax.mail.PasswordAuthentication;

/**
 * 
 * @author	������
 * @date	2016-02-28
 * @tip		���Ϲ߼� ����
 * <pre>
 * -------- �����̷� ----------
 * ������	:	������
 * ��������	:	2016-02-28
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public class SMTPAuthenticator extends javax.mail.Authenticator {
	public PasswordAuthentication getPasswordAuthentication() {
		// ���̹��� Gmail ����� ���� ����.
		// Gmail�� ��� @gmail.com�� ������ ���̵� �Է��Ѵ�.
	return new PasswordAuthentication("wjd6542@gmail.com", "wmfdlek18!");
	}
}