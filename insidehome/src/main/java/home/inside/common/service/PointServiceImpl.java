package home.inside.common.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.inside.common.repository.IPointDao;
import home.inside.common.vo.PointVo;

@Service
public class PointServiceImpl implements IPointService {

	@Autowired
	private IPointDao pointDao;	
	
	public void insertPoint(PointVo vo) throws Exception {
		pointDao.insert(vo);
	}

	public int selectCheck(String nickname) throws Exception {
		return pointDao.selectCheck(nickname);
	}
	
	public List<PointVo> selectMonth(String nickname, int month) throws Exception {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("nickname", nickname);
		hm.put("month", month);
		return pointDao.selectMonth(hm);
	}

	public void deletePoint(String nickname) throws Exception {
		pointDao.delete(nickname);
	}


}
