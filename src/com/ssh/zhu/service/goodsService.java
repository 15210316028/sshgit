package com.ssh.zhu.service;

import java.util.List;
import com.ssh.zhu.model.goods;
public interface goodsService {
	void add(goods good);
	List<goods> queryAll(String kind);
	goods get(String name);
}
