package shares.util;
import javax.mail.PasswordAuthentication;

/**
 * 
 * @author	강정권
 * @date	2016-02-28
 * @tip		메일발송 설정
 * <pre>
 * -------- 수정이력 ----------
 * 수정자	:	강정권
 * 수정일자	:	2016-02-28
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public class SMTPAuthenticator extends javax.mail.Authenticator {
	public PasswordAuthentication getPasswordAuthentication() {
		// 네이버나 Gmail 사용자 계정 설정.
		// Gmail의 경우 @gmail.com을 제외한 아이디만 입력한다.
	return new PasswordAuthentication("wjd6542@gmail.com", "wmfdlek18!");
	}
}