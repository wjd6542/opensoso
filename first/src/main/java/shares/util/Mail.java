package shares.util;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;


/**
 * 
 * @author	강정권
 * @date	2016-02-28
 * @tip		메일발송
 * <pre>
 * -------- 수정이력 ----------
 * 수정자	:	강정권
 * 수정일자	:	2016-02-28
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public class Mail {
	
	// 로거
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 메일 발송 
	 * @param map
	 * @return
	 * @throws MessagingException
	 */
	public boolean sendMail(HashMap<String, String> map) throws MessagingException {
		
		/*================ data setting str =================
		 * 메일 발송전 데이터를 셋팅한다
		 * 구글 계정인경우 smtp.gmail.com 사용
		 * 구글 사용시 내계정 정보 - 로그인 및 보안 - 보안수준이 낮은 앱 허용 을 사용해주어야 계정 접속 가능함
		 * 포트는 465 으로 고정한다
		 ================= data setting end =================*/
		Properties p = System.getProperties();
		p.put("mail.smtp.user", "wid6542");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		
		try 
		{
			/*================ data setting str =================
			 * session 생성 및  MimeMessage생성
			 * title	: 메일 제목
			 * toAddr	: 받는사람 주소
			 * memo		: 발송 메일 내용
			 ================= data setting end =================*/
			String title = map.get("title");
			String toAddrs = map.get("toAddr");
			String content = map.get("memo");
			
			Authenticator auth = new SMTPAuthenticator();
			javax.mail.Session ses = javax.mail.Session.getInstance(p, auth);
			MimeMessage msg = new MimeMessage(ses);
			Address fromAddr = new InternetAddress("OpenSoSo@gmail.com");
			Address toAddr = new InternetAddress(toAddrs);
			
			msg.setSubject(title);
			msg.setFrom(fromAddr);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(content, "text/html;charset=UTF-8");
			Transport.send(msg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
