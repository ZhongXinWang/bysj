package graduation.design.colleges.schoolroom.help.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import graduation.design.colleges.schoolroom.help.entity.Resource;
import graduation.design.colleges.schoolroom.help.pagination.Page;

/**
 @Author 王钟鑫
 @date 2017年12月14日 下午5:38:05
 * 
 */
public interface ResourceService<Resource> {

	public List<Resource> findPage(Page<?> page); //分页查询
	public List<Resource> find(Map<?, ?> paraMap);    //带条件查询
	public Resource get(Serializable id);       //获取单条数据
	public void insert(Resource entity);        //插入   用实体作为参数
	public void update(Resource entity);        //修改   用实体作为参数
	public void delete(Serializable id);  //删除
	public void delete(Serializable[] ids); //批量删除
	
	//获取用户的菜单,或按钮
	
	public List<Resource> getResources(Map<?,?> maps);
}
