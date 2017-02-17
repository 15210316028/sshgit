package com.ssh.zhu.service.impl;

import javax.annotation.Resource;
import com.ssh.zhu.dao.*;
import org.springframework.stereotype.Service;
import com.ssh.zhu.model.goods;
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
	public Integer buy(String phone, goods good, Double inserv) {
		return userGoodsDao.buy(phone, good, inserv);
	}

}
