package com.ssh.zhu.dao.impl;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
	public void buy(userGoods userGoods) 
	{
		hibernateTemplate.save(userGoods);
	}
	@Override
	public userGoods get(final String phone, final goods good) {
		return hibernateTemplate.execute(new HibernateCallback<userGoods>() {
			@Override
			public userGoods doInHibernate(Session session){
				String sql="select * from userGoods where phone='"+phone+"' and name='"+good.getName()+"'";
				userGoods userGoods=(userGoods)session.createSQLQuery(sql).addEntity(userGoods.class).uniqueResult();
				return userGoods;
			}
		});
	}	
	public Integer getId()
	{
		return hibernateTemplate.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session){
				String sql="select ifnull(max(id),0) as maxId from userGoods ";
				Integer maxId=((java.math.BigInteger)session.createSQLQuery(sql).uniqueResult()).intValue();
				return maxId;
			}
		});
	}
}
