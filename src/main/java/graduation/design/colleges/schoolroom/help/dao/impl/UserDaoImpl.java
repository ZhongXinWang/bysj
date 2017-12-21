package graduation.design.colleges.schoolroom.help.dao.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.stereotype.Repository;

import graduation.design.colleges.schoolroom.help.dao.UserDao;

/**
 @Author 王钟鑫
 @date 2017年12月14日 下午5:33:40
 * 
 */
@Repository
public class UserDaoImpl<T> extends BaseDaoImpl<T> implements UserDao<T> {

	//设置命名空间
	private static String ns = "graduation.design.colleges.schoolroom.help.entity.UserMapper"; 
	public UserDaoImpl(){
		
		super.setNs(ns);
	}
	@Override
	public T login(Serializable email) {

		return this.getSqlSession().selectOne(super.getNs()+".login",email);
	}
	@Override
	public void insertUserRole(Map<?,?> maps) {

		 this.getSqlSession().insert(super.getNs()+".insertUserRole",maps);
		
	}
	@Override
	public void deleteUserRoleById(Serializable id) {

		this.getSqlSession().delete(super.getNs()+".deleteByUserId",id);
	}
	@Override
	public void deleteUserRole(Serializable[] id) {

		this.getSqlSession().delete(super.getNs()+".deleteUserRole", id);
	}
	@Override
	public void updateUserRoleById(Map<?,?> maps) {

		this.getSqlSession().update(super.getNs()+".updateUserRoleById",maps);
		
	}

}
