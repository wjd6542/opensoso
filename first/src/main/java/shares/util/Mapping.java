package shares.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class Mapping {
	// �ΰ�
	Logger log = Logger.getLogger(this.getClass());
	
	
	/**
	 * �ڵ� ���� �Լ�
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
	 * ���� ����Ʈ ����
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
