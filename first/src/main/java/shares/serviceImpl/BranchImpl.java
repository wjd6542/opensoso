package shares.serviceImpl;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import shares.dao.BranchDAO;
import shares.service.BranchSvc;

@Service("BranchService")
public class BranchImpl implements BranchSvc{
	// 로그
	Logger log = Logger.getLogger(this.getClass());
	// DAO 연결
	@Resource(name="BranchDAO")
	private BranchDAO branchDAO;
	
	@Override
	public ArrayList<HashMap<String, String>> selectBranchList(String sqlId, HashMap<String, String> map) throws Exception {
		return (ArrayList<HashMap<String, String>>)branchDAO.selectBranchList(sqlId, map);
	}
	@Override
	public HashMap<String, String> branchSelect(String sqlId, String value) throws Exception {
		return (HashMap<String, String>)branchDAO.branchSelect(sqlId, value);
	}
	@Override
	public String checkCode(String sqlId, String value) throws Exception {
		return  "";
	}
	@Override
	public void branchInsert(String sqlId, HashMap<String, String> map) throws Exception {
		branchDAO.insert(sqlId, map);
	}
	@Override
	public void branchUpdate(String sqlId, HashMap<String, String> map) throws Exception {
		branchDAO.branchUpdate(sqlId, map);
	}
	@Override
	public void branchDelete(String sqlId, HashMap<String, String> map) throws Exception {
		branchDAO.branchDelete(sqlId, map);
	}
	
	
}
