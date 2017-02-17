package com.ssh.zhu.dao.impl;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
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
	public List<goods> selectAll(final String kind) {	
		return hibernateTemplate.execute(new HibernateCallback<List<goods>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<goods> doInHibernate(Session session){
				String sql="select * from goods where kind='"+kind+"'";
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
		return hibernateTemplate.execute(new HibernateCallback<goods>() {
			@Override
			public goods doInHibernate(Session session){
				String sql = "select * from goods where name='"+name+"'";
				goods good=(goods) session.createSQLQuery(sql).addEntity(goods.class).uniqueResult();
				return good; 
			}
		});
	}

	@Override
	public void insert(goods good) {
		 hibernateTemplate.save(good);
	}

}
