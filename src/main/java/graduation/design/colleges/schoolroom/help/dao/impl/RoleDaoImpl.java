package graduation.design.colleges.schoolroom.help.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import graduation.design.colleges.schoolroom.help.dao.RoleDao;

/**
 * @Author 王钟鑫
 * @date 2017年12月14日 下午5:35:28
 * 
 */
@Repository
public class RoleDaoImpl<T> extends BaseDaoImpl<T> implements RoleDao<T> {

	// 设置命名空间
	private static String ns = "graduation.design.colleges.schoolroom.help.entity.RoleMapper";

	public RoleDaoImpl() {

		super.setNs(ns);
	}
	
	@Override
	public List<T> getRoles(Serializable email) {

		return this.getSqlSession().selectList(super.getNs()+".findRole",email);
	}

}
