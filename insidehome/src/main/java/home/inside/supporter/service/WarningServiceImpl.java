package home.inside.supporter.service;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.inside.supporter.repository.IWarningDao;
import home.inside.supporter.vo.WarningVo;

@Service
public class WarningServiceImpl implements IWarningService{
	@Autowired
	IWarningDao dao;	
	
	//신고접수
	public void warningInsert(WarningVo vo) throws Exception {
		dao.warningInsert(vo);
	}
	//신고 횟수
	public int warningCount(String nickname) throws Exception {
		return dao.warningCount(nickname);
	}
	//회원 탈퇴시
	public void warningDelete(String nickname) throws Exception {
		dao.warningDelete(nickname);
	}
	
	//신고 횟수 리스트
	public List<HashMap<String, Object>> warningSelectAll() throws Exception {
		return dao.warningSelectAll();
	}
	
}
