package com.ssh.zhu.service.impl;

import java.util.List;

import javax.annotation.Resource;
import com.ssh.zhu.dao.impl.*;
import org.springframework.stereotype.Service;
import com.ssh.zhu.dao.goodsDao;
import com.ssh.zhu.model.goods;
import com.ssh.zhu.service.goodsService;
@Service
public class goodsServiceImpl implements goodsService {
	@Resource
	private goodsDaoImpl goodsDaoImpl;
	
	public goodsDaoImpl getGoodsDaoImpl() {
		return goodsDaoImpl;
	}

	public void setGoodsDaoImpl(goodsDaoImpl goodsDaoImpl) {
		this.goodsDaoImpl = goodsDaoImpl;
	}

	@Override
	public void add(goods good) {
		goodsDaoImpl.insert(good);
	}

	@Override
	public List<goods> queryAll(String kind) {
		return goodsDaoImpl.selectAll(kind);
	}

	@Override
	public goods get(String name) {
		return goodsDaoImpl.get(name);
	}

}
