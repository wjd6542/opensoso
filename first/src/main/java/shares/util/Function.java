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
		if( vo != null )
		{
			for(SystemVo sysVo : vo)
			{
				if( value != null && value.equals(sysVo.getCode()) )
				{
					result += "<option value='" + sysVo.getCode()+"' selected>" + sysVo.getTitle() + "</option>";
				}
				else
				{
					result += "<option value='" + sysVo.getCode()+"'>" + sysVo.getTitle() + "</option>";
				}
			}
		}
		return result;
	}
	
	
	/**
	 * 설명 : 코드 매핑 함수
	 * @param vo
	 * @param value
	 * @return
	 */
	public static String sysMapping(List<SystemVo> vo , String value) {
		String result = "";
		for(SystemVo sysVo : vo){
			String val = sysVo.getCode();
			if(value.equals(val)){
				result = sysVo.getTitle();
			}
		}
		return result;
	}
}
