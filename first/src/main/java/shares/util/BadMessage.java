package shares.util;

/**
 * 
 * @author	강정권
 * @date	2016-02-28
 * @tip		욕설 방지 함수
 * <pre>
 * -------- 수정이력 ----------
 * 수정자	:	강정권
 * 수정일자	:	2016-02-28
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
public class BadMessage {
	static String[] badArr = {
		"씨발","개새끼","싸가지","미친","미친놈","엠창","염병","지랄","좆도","양아치","씨부랄","썅놈","시발놈"
	};
	
	
	/**
	 * 설명 : 욕설 제거 함수
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
