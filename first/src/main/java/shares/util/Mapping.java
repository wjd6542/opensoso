package shares.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class Mapping {
	// 로거
	Logger log = Logger.getLogger(this.getClass());
	
	
	/**
	 * 코드 매핑 함수
	 * @param map
	 * @param value
	 * @return
	 */
	public String codeMapping(ArrayList<HashMap<String,String>> map, String value)
	{
		String result = "";
		for(int i=0; i<map.size(); i++)
		{
			String val = map.get(i).get("ccode");
			if(val == value)
			{
				result = val;
				break;
			}
		}
		return result;
	}
	
	/**
	 * 유저 리스트 가공
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,String>> userSetting(ArrayList<HashMap<String,String>> map)
	{
		for(int i=0; i<map.size(); i++)
		{
			//Set set = map.set(i, map);
		}
		return map;
	}
}
