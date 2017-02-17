package com.ssh.zhu.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssh.zhu.dao.goodsDao;
import com.ssh.zhu.model.goods;
import com.ssh.zhu.service.goodsService;
@Service
public class goodsServiceImpl implements goodsService {
	@Resource
	private goodsDao goodsDao;
	public goodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(goodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public void add(goods good) {
		goodsDao.insert(good);
	}

	@Override
	public List<goods> queryAll(String kind) {
		return goodsDao.selectAll(kind);
	}

	@Override
	public goods get(String name) {
		return goodsDao.get(name);
	}

}
