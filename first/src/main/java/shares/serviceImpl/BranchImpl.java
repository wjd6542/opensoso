package shares.serviceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import shares.dao.AbstractDAO;
import shares.service.BranchSvc;

/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		부서 설정 Impl
 * 			1. DAO , VO 참조객체 설명 주석을 반드시 작성한다
 * 			2. 반드시 공용 주석 작성 형태를 참고 할것
 * 			참조 DAO	: AbstractDAO
 * 			참조 VO	: SystemBorderVo
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Service("BranchSvc")
public class BranchImpl implements BranchSvc{
	// 로그
	Logger log = Logger.getLogger(this.getClass());
	// DAO 연결
	@Resource(name="AbstractDAO")
	private AbstractDAO abstractDAO;
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<HashMap<String, String>> selectBranchList(String sqlId, HashMap<String, String> map) throws Exception {
		return (ArrayList<HashMap<String, String>>)abstractDAO.selectList(sqlId, map);
	}
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, String> branchSelect(String sqlId, String value) throws Exception {
		return (HashMap<String, String>)abstractDAO.selectList(sqlId, value);
	}
	@Override
	public String checkCode(String sqlId, String value) throws Exception {
		return  "";
	}
	@Override
	public void branchInsert(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.insert(sqlId, map);
	}
	@Override
	public void branchUpdate(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.update(sqlId, map);
	}
	@Override
	public void branchDelete(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.delete(sqlId, map);
	}
	
	
}
