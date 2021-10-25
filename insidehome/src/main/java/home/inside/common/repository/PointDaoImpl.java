package home.inside.common.repository;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import home.inside.common.vo.PointVo;

@Repository
public class PointDaoImpl implements IPointDao {
	private SqlSessionTemplate sqlSessionTemplate; 
	
	public void insert(PointVo vo) throws Exception {
		// TODO Auto-generated method stub
		int num;
	}

	public int selectCheck(HashMap<String, Object> hm) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(String nickname) throws Exception {
		// TODO Auto-generated method stub
		int num;

	}

}
