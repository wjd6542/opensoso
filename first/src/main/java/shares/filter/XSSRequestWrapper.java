package shares.filter;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.log4j.Logger;

public class XSSRequestWrapper extends HttpServletRequestWrapper {
	
	// �ΰ�
	Logger logs = Logger.getLogger(this.getClass());
	
	private static Pattern[] patterns = new Pattern[] {
			Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
			Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL),
			Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL),
			Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
			Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
			Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
			Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL)
	};

	public XSSRequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
	}
	
	/**
	 * �Ķ���� �˻�
	 */
	@Override
	public String[] getParameterValues(String parameter) {
		logs.info("getParameterValues");
		String[] values = super.getParameterValues(parameter);

		if (values == null) {
			return null;
		}
		
		int count = values.length;
		
		String[] encodedValues = new String[count];

		for (int i = 0; i < count; i++) {
			encodedValues[i] = stripXSS(values[i]);
		}
		
		return encodedValues;
	}

	/**
	 * request �Ķ���� �����ö� ������ xss �˻����
	 */
	@Override
	public String getParameter(String parameter) {
		logs.info("getParameter");
		String value = super.getParameter(parameter);
		return stripXSS(value);
	}
	
	/**
	 * ��� �˻�
	 */
	@Override
	public String getHeader(String name) {
		logs.info("getHeader");
		String value = super.getHeader(name);
		return stripXSS(value);
	}
	
	/**
	 * ũ�ν�����Ʈ��ũ��Ʈ ����
	 * @param value
	 * @return
	 */
	private String stripXSS(String value) {
		logs.info("XSS	inint	:	" + value);
		if (value != null) {

			// NOTE: It's highly recommended to use the ESAPI library and
			// uncomment the following line to
			// avoid encoded attacks.
			// value = ESAPI.encoder().canonicalize(value);
			// Avoid null characters

			value = value.replaceAll("\0", "");

			// Remove all sections that match a pattern
			for (Pattern scriptPattern : patterns) {
				if ( scriptPattern.matcher(value).matches() ) {
					logs.info("match.....");
					value=value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
				}
			}
		}
		logs.info("XSS	result	:	" + value);
		return value;
	}
}