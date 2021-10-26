package home.inside.common.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.ognl.Ognl;

import home.inside.common.vo.PointVo;

public interface IPointDao {
	public void insert(PointVo vo) throws Exception;
	public int selectCheck(String nickname) throws Exception;
	public List<PointVo> selectMonth(HashMap<String, Object> hm) throws Exception;
	public void delete(String nickname) throws Exception;
}
