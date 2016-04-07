package shares.serviceImpl;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import shares.dao.AbstractDAO;
import shares.service.NoteSvc;
import shares.vo.NoteVo;

/**
 * 
 * @author	강정권
 * @date	2015-11-29
 * @tip		이메일 Impl
 * 			1. DAO , VO 참조객체 설명 주석을 반드시 작성한다
 * 			2. 반드시 공용 주석 작성 형태를 참고 할것
 * 			참조 DAO	: AbstractDAO
 * 			참조 VO	: EmailVo
 * <pre>
 * -------- 수정이력 --------------
 * 수정자	:	강정권
 * 수정일자	:	2015-11-29
 * 수정내용	:	class 작성
 * ----------------------------
 * </pre>
 *
 */
@Service("NoteSvc")
public class NotelImpl implements NoteSvc{
	// 로그
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="AbstractDAO")
	AbstractDAO abstractDAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<NoteVo> list(String sqlId, HashMap<String, String> map) throws Exception {
		return (List<NoteVo>) abstractDAO.selectList(sqlId, map);
	}
	
	@Override
	public NoteVo data(String sqlId, HashMap<String, String> map) throws Exception {
		return (NoteVo) abstractDAO.selectOne(sqlId, map);
	}

	@Override
	public int totalCnt(String sqlId, HashMap<String, String> map) throws Exception {
		return (int) abstractDAO.selectOne(sqlId, map);
	}

	@Override
	public void insert(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.insert(sqlId, map);
	}

	@Override
	public void delete(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.delete(sqlId, map);
	}

	@Override
	public void update(String sqlId, HashMap<String, String> map) throws Exception {
		abstractDAO.update(sqlId, map);
	}
	
}
