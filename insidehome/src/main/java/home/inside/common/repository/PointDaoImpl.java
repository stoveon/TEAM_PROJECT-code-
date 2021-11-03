package home.inside.common.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.inside.common.vo.PointVo;

@Repository
public class PointDaoImpl implements IPointDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insertPoint(HashMap<String, Object> hsm) throws Exception {
		sqlSessionTemplate.insert("insertPoint", hsm);
	}

	@Override
	public int selectCheckIn(String nickname) throws Exception {
		List<Integer> result = sqlSessionTemplate.selectList("selectCheckIn", nickname);
		return result.isEmpty() ? 0 : result.get(0);
	}

	@Override
	public List<HashMap<String, Object>> selectPointList(String nickname) throws Exception {
		return sqlSessionTemplate.selectList("selectPointList", nickname);
	}

	@Override
	public List<Date> selectCheckMonth(String nickname) throws Exception {
		return sqlSessionTemplate.selectList("selectCheckMonth", nickname);
	}

	@Override
	public void deletePoint(String nickname) throws Exception {
		sqlSessionTemplate.delete("deletePoint", nickname);
	}

}
