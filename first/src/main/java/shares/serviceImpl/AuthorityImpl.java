package shares.serviceImpl;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import shares.dao.AuthorityDAO;
import shares.service.AuthoritySvc;

@Service("AuthorityService")
public class AuthorityImpl implements AuthoritySvc{
	// 로그
	Logger log = Logger.getLogger(this.getClass());
	// DAO 연결
	@Resource(name="AuthorityDAO")
	private AuthorityDAO authorityDAO;
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<HashMap<String, String>> selectAuthorityList(String sqlId, HashMap<String, String> map) throws Exception {
		return (ArrayList<HashMap<String, String>>)authorityDAO.selectList(sqlId, map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, String> authoritySelect(String sqlId, HashMap<String, String> map) throws Exception {
		return (HashMap<String, String>)authorityDAO.selectOne(sqlId, map);
	}

	@Override
	public String checkCode(String sqlId, String value) throws Exception {
		return (String)authorityDAO.checkCode(sqlId, value);
	}

	@Override
	public void authorityInsert(String sqlId, HashMap<String, String> map) throws Exception {
		authorityDAO.insert(sqlId, map);
	}
	
	@Override
	public void authorityUpdate(String sqlId, HashMap<String, String> map) throws Exception {
		authorityDAO.update(sqlId, map);
	}

	@Override
	public void authorityDelete(String sqlId, HashMap<String, String> map) throws Exception {
		authorityDAO.delete(sqlId, map);
	}
}
