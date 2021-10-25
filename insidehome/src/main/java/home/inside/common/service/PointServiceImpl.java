package home.inside.common.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.inside.common.repository.IPointDao;

@Service
public class PointServiceImpl implements IPointService {

	@Autowired
	private IPointDao pointDao;
	//private IMemberDao memberDao;
	
	public void insertPoint(String nickname, String type) throws Exception {
		// TODO Auto-generated method stub

	}

	public void insertPoint(String nickname, int changePoint) throws Exception {
		// TODO Auto-generated method stub

	}

	public int selectCheck(String nickname, Date changeDate) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deletePoint(String nickname) throws Exception {
		// TODO Auto-generated method stub

	}

}
