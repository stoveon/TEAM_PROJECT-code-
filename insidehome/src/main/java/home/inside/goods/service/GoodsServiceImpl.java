package home.inside.goods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.inside.goods.repository.IGoodsSalesDao;

@Service
public class GoodsServiceImpl implements IGoodsService {
	@Autowired
	private IGoodsSalesDao goodsSalesDao;

	@Override
	public int salesCountNickname(String nickname) throws Exception {
		return goodsSalesDao.salesCount(nickname);
	}
	
	@Override
	public void deleteGoodsSales(String nickname) throws Exception {
		goodsSalesDao.deleteGoodsSales(nickname);
	}
	
}
