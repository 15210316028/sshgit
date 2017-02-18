package com.ssh.zhu.dao.impl;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ssh.zhu.dao.personDao;
import com.ssh.zhu.model.person;
@Repository
public class personDaoImpl implements personDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public void insert(person person) {
		hibernateTemplate.save(person);
	}
	/*
	 * »áÔ±×¢²á²éÑ¯
	 * 
	 */
	@Override
	public person getPerson(final String idCard) {
		return hibernateTemplate.execute(new HibernateCallback<person>() {
			@Override
			public person doInHibernate(Session session){
				String sql="select * from person where idCard='"+idCard+"'";
				person person=(person)session.createSQLQuery(sql).addEntity(person.class).uniqueResult();
				return person;
			}
		});
	}
	@Override
	public person get(final String phone) {
		return hibernateTemplate.execute(new HibernateCallback<person>() {
			@Override
			public person doInHibernate(Session session){
				String sql="select * from person where phone='"+phone+"'";
				person person=(person)session.createSQLQuery(sql).addEntity(person.class).uniqueResult();
				return person;
			}
		});
	}

}
