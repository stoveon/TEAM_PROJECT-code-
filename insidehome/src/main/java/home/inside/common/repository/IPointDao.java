package home.inside.common.repository;

import java.util.HashMap;

import home.inside.common.vo.PointVo;

public interface IPointDao {
	public void insert(PointVo vo) throws Exception;
	public int selectCheck(HashMap<String, Object> hm) throws Exception;
	public void delete(String nickname) throws Exception;
}
