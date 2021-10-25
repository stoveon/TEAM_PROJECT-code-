package home.inside.common.service;

import java.util.Date;

import home.inside.common.repository.IPointDao;

public interface IPointService {
	public void insertPoint(String nickname, String type) throws Exception;
	public void insertPoint(String nickname, int changePoint) throws Exception;
	public int selectCheck(String nickname, Date changeDate) throws Exception;
	public void deletePoint(String nickname) throws Exception;
}
