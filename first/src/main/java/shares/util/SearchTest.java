package shares.util;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import java.io.ByteArrayInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchTest {

	public static void setUp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 try {
            String data = request.getParameter("data");
            data = data.replaceAll("data:image/png;base64,", "");
            byte[] file = Base64.decodeBase64(data);
            ByteArrayInputStream is = new ByteArrayInputStream(file);
            
            response.setContentType("image/png");
            response.setHeader("Content-Disposition", "attachment; filename= 111.png");
            IOUtils.copy(is,  response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            
        }
	}
}
