package graduation.design.colleges.schoolroom.help.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import graduation.design.colleges.schoolroom.help.dao.BaseDao;
import graduation.design.colleges.schoolroom.help.pagination.Page;

/**
  封装基础的Dao操作
 @Author 王钟鑫
 @date 2017年12月2日 下午11:27:37
 * 
 */
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {

	private String ns; //设置mybatis的命名空间
	
	public String getNs() {
		return ns;
	}

	public void setNs(String ns) {
		this.ns = ns;
	}
	//注入SqlSessionFactory  mybatis3.x之后必须手动注入
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {

		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<T> find(Map<?,?> paraMap) {
		
		List<T> list = this.getSqlSession().selectList(ns+".find",paraMap);
		
		return list;
	}

	@Override
	public T get(Serializable id) {

		return this.getSqlSession().selectOne(ns+".get",id);
	}

	@Override
	public void insert(T entity) {

		this.getSqlSession().insert(ns+".insert", entity);
	}

	@Override
	public void update(T entity) {

		this.getSqlSession().update(ns+".update",entity);
	}

	@Override
	public void delete(Serializable id) {

		this.getSqlSession().delete(ns+".deleteById",id);
	}

	@Override
	public void delete(Serializable[] ids) {

		this.getSqlSession().delete(ns+".delete",ids);
	}

	@Override
	public List<T> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

}
