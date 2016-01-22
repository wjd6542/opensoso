package shares.util;
import java.util.List;
import shares.vo.SystemVo;

public class Function {
	
	/**
	 * map 데이터 option 값으로 변경 함수
	 * @param map
	 * @param object
	 * @return
	 */
	public static String sysOption(List<SystemVo> vo , String value) {
		String result = "";
		if(vo != null && value != null)
		{
			for(int i=0; i<vo.size(); i++)
			{
				if( value != null && value == vo.get(i).getCode() )
				{
					result += "<option value='"+vo.get(i).getCode()+"' selected>"+vo.get(i).getTitle()+"</option>";
				}
				else
				{
					result += "<option value='"+vo.get(i).getCode()+"'>"+vo.get(i).getTitle()+"</option>";
				}
			}
		}
		else
		{
			return "";
		}
		return result;
	}
	

}
