package com.ssh.zhu.service.impl;

import javax.annotation.Resource;
import com.ssh.zhu.dao.impl.*;
import org.springframework.stereotype.Service;
import com.ssh.zhu.model.goods;
import com.ssh.zhu.service.userGoodsService;
@Service
public class userGoodsImpl implements userGoodsService {
	@Resource
	private userGoodsDaoImpl userGoodsDaoImpl;
	
	public userGoodsDaoImpl getUserGoodsDaoImpl() {
		return userGoodsDaoImpl;
	}
	public void setUserGoodsDaoImpl(userGoodsDaoImpl userGoodsDaoImpl) {
		this.userGoodsDaoImpl = userGoodsDaoImpl;
	}

	@Override
	public Integer buy(String phone, goods good, Double inserv) {
		return userGoodsDaoImpl.buy(phone, good, inserv);
	}

}
