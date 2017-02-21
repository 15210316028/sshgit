package com.ssh.zhu.dao;

import java.util.*;
import com.ssh.zhu.model.*;
public interface goodsDao {
	List<goods> selectAll();
	goods get(String name);
	void insert(goods good); 
	void update(goods good);
}
