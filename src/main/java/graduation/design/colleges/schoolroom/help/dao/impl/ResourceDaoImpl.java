package graduation.design.colleges.schoolroom.help.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import graduation.design.colleges.schoolroom.help.dao.ResourceDao;
import graduation.design.colleges.schoolroom.help.entity.Resource;

/**
 * @Author 王钟鑫
 * @date 2017年12月14日 下午5:33:40
 * 
 */
@Repository
public class ResourceDaoImpl<T> extends BaseDaoImpl<T> implements ResourceDao<T> {

	// 设置命名空间
	private static String ns = "graduation.design.colleges.schoolroom.help.entity.ResourceMapper";

	public ResourceDaoImpl() {

			super.setNs(ns);
	}

	@Override
	public List<Resource> getResources(Map<?,?> maps) {

		return this.getSqlSession().selectList(super.getNs()+".findResource",maps);
	}
	

}
