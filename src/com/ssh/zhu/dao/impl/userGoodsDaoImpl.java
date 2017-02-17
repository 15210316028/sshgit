package com.ssh.zhu.dao.impl;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ssh.zhu.dao.userGoodsDao;
import com.ssh.zhu.model.goods;
import com.ssh.zhu.model.userGoods;
@Repository
public class userGoodsDaoImpl implements userGoodsDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	/*
	 * ¹ºÂò²úÆ·
	 * 
	 */
	public Integer buy(final String phone, final goods good, final Double inserv) {
			return hibernateTemplate.execute(new HibernateCallback<Integer>() {
				@Override
				public Integer doInHibernate(Session session){
					String sql="insert into userGood values('"+phone+"','"+good.getName()+"',"+good.getYield()+","+good.getTime()+","+inserv+")";
					Integer num=(Integer)session.createSQLQuery(sql).addEntity(userGoods.class).uniqueResult();
					return num;
				}
			});
		}		
}
