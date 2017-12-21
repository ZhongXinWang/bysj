package graduation.design.colleges.schoolroom.help.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import graduation.design.colleges.schoolroom.help.entity.Resource;
import graduation.design.colleges.schoolroom.help.enums.ResourceType;
import graduation.design.colleges.schoolroom.help.pagination.Page;

/**
 @Author 王钟鑫
 @date 2017年12月14日 下午5:38:05
 * 
 */
public interface PermService<Perm> {

	public List<Perm> findPage(Page<?> page); //分页查询
	public List<Perm> find(Map<?, ?> paraMap);    //带条件查询
	public Perm get(Serializable id);       //获取单条数据
	public void insert(Perm entity);        //插入   用实体作为参数
	public void update(Perm entity);        //修改   用实体作为参数
	public void delete(Serializable id);  //删除
	public void delete(Serializable[] ids); //批量删除
	
	//获取用户所拥有的权限
	public List<Perm> getPerms(Serializable[] roleIds);
	
	//获取用户的菜单	
	public List<Resource> getResources(Map<?,?> maps);
}
