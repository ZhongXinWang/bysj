package graduation.design.colleges.schoolroom.help.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import graduation.design.colleges.schoolroom.help.dao.PermDao;

/**
 * @Author 王钟鑫
 * @date 2017年12月14日 下午5:33:40
 * 
 */
@Repository
public class PermDaoImpl<T> extends BaseDaoImpl<T> implements PermDao<T> {

	// 设置命名空间
	private static String ns = "graduation.design.colleges.schoolroom.help.entity.PermMapper";

	public PermDaoImpl() {

		super.setNs(ns);
	}

	@Override
	public List<T> getPerms(Serializable[] roleIds) {

		return this.getSqlSession().selectList(super.getNs()+".findPerm", roleIds);
	}
}
