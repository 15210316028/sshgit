package com.ssh.zhu.service;

import java.util.List;
import com.ssh.zhu.model.goods;
public interface goodsService {
	void add(goods good);
	void exid(goods good);
	List<goods> queryAll();
	goods get(String name);
}
