package shares.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import shares.vo.SystemTableVo;

/**
 * 
 * @author	������
 * @date	2015-11-07
 * @tip		DB ���� Class
 * <pre>
 * -------- �����̷� ----------
 * ������	:	������
 * ��������	:	2015-11-07
 * ��������	:	class �ۼ�
 * ----------------------------
 * </pre>
 *
 */
@Repository("SystemTableDAO")
public class SystemTableDAO extends AbstractDAO{
	
	/**
	 * ���̺� �˻�
	 * @param sqlId
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SystemTableVo> list(String sqlId, SystemTableVo vo) throws Exception
	{
		return (List<SystemTableVo>)selectList(sqlId, vo);
	}
}
