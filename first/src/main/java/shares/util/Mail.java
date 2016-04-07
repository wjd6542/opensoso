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
 * @author	������
 * @date	2016-02-28
 * @tip		���Ϲ߼�
 * <pre>
 * -------- �����̷� ----------
 * ������	:	������
 * ��������	:	2016-02-28
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
public class Mail {
	
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * ���� �߼� 
	 * @param map
	 * @return
	 * @throws MessagingException
	 */
	public boolean sendMail(HashMap<String, String> map) throws MessagingException {
		
		/*================ data setting str =================
		 * ���� �߼��� �����͸� �����Ѵ�
		 * ���� �����ΰ�� smtp.gmail.com ���
		 * ���� ���� ������ ���� - �α��� �� ���� - ���ȼ����� ���� �� ��� �� ������־�� ���� ���� ������
		 * ��Ʈ�� 465 ���� �����Ѵ�
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
			 * session ���� ��  MimeMessage����
			 * title	: ���� ����
			 * toAddr	: �޴»�� �ּ�
			 * memo		: �߼� ���� ����
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
