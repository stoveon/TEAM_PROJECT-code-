package home.inside.goods.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.inside.goods.repository.IGoodsSalesDao;

@Service
public class GoodsServiceImpl implements IGoodsService {
	@Autowired
	private IGoodsSalesDao goodsSalesDao;

	@Override
	public int nicknameOrderCount(String nickname) throws Exception {
		return goodsSalesDao.salesCount(nickname);
	}
	
	@Override
	public void deleteGoodsSales(String nickname) throws Exception {
		goodsSalesDao.deleteGoodsSales(nickname);
	}

	@Override
	public List<HashMap<String, String>> nicknameOrderList(String nickname) throws Exception {
		return goodsSalesDao.nickNameOrderList(nickname);
	}
	
}
