package com.ssh.zhu.dao;

import com.ssh.zhu.model.*;
public interface userGoodsDao {
	void buy(userGoods userGoods);
	userGoods get(String phone,goods good);
}
