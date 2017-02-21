package com.ssh.zhu.dao.impl;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.ssh.zhu.dao.goodsDao;
import com.ssh.zhu.model.goods;
@Repository
public class goodsDaoImpl implements goodsDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	/*
	 * 根据产品VIP查询产品
	 * 
	 */
	public List<goods> selectAll() {	
		return hibernateTemplate.execute(new HibernateCallback<List<goods>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<goods> doInHibernate(Session session){
				String sql="select * from goods";
				List<goods> list=(List<goods>)session.createSQLQuery(sql).addEntity(goods.class).list();				
				return list;				
			}
		});
	}
	@Override
	/*
	 * 根据产品名称查询产品
	 * 
	 */
	public goods get(final String name) {
		return hibernateTemplate.execute(new HibernateCallback<goods>(){

			@Override
			public goods doInHibernate(Session session){
				String sql="select * from goods where name='"+name+"'";				
				goods goods=(goods)session.createSQLQuery(sql).addEntity(goods.class).uniqueResult();
				return goods;
			}
			
		});
	}

	@Override
	public void insert(goods good) {
		 hibernateTemplate.save(good);
	}
	@Override
	public void update(goods good) {
		hibernateTemplate.update(good);		
	}
}
