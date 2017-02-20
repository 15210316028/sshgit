package com.ssh.zhu.dao.impl;
import javax.annotation.Resource;
import org.hibernate.*;
import org.springframework.orm.hibernate3.*;
import org.springframework.stereotype.*;
import com.ssh.zhu.dao.*;
import com.ssh.zhu.model.*;
@Repository
public class userDaoImpl implements userDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void insert(user user){
		hibernateTemplate.save(user);
	}

	@Override
	/*
	 * 注册查询用户
	 * 
	 */
	public user getUser(final String phone) {
		return hibernateTemplate.execute(new HibernateCallback<user>() {
			@Override
			public user doInHibernate(Session session){
				String sql="select * from user where phone='"+phone+"'";
				user user=(user)session.createSQLQuery(sql).addEntity(user.class).uniqueResult();
				return user;
			}
		});
	}

	@Override
	/*
	 * 登陆查询用户
	 * 
	 */
	public user get(final String phone, final String password) {
		return hibernateTemplate.execute(new HibernateCallback<user>() {
			@Override
			public user doInHibernate(Session session){
				String sql = "select * from user where phone='"+phone+"' and password='"+password+"'";
				user user=(user)session.createSQLQuery(sql).addEntity(user.class).uniqueResult();
				return user;
			}
		});

	}
}
