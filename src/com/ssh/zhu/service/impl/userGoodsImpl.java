package com.ssh.zhu.service.impl;

import javax.annotation.Resource;
import com.ssh.zhu.dao.*;
import org.springframework.stereotype.Service;
import com.ssh.zhu.model.goods;
import com.ssh.zhu.model.userGoods;
import com.ssh.zhu.service.userGoodsService;
@Service
public class userGoodsImpl implements userGoodsService {
	@Resource
	private userGoodsDao userGoodsDao;
	public userGoodsDao getUserGoodsDao() {
		return userGoodsDao;
	}
	public void setUserGoodsDao(userGoodsDao userGoodsDao) {
		this.userGoodsDao = userGoodsDao;
	}
	@Override
	public void buy(userGoods userGoods) {
		userGoodsDao.buy(userGoods);
	}
	@Override
	public userGoods get(String phone,goods good) {
		return userGoodsDao.get(phone, good);
	}

}
