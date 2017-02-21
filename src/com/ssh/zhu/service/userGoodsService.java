package com.ssh.zhu.service;

import com.ssh.zhu.model.*;

public interface userGoodsService {
	void buy(userGoods userGoods);
	userGoods get(String phone, goods good);
}
