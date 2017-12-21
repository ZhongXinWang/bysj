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
public interface UserService<User> {

	public User login(Serializable email);//登录操作
	public List<User> findPage(Page<?> page); //分页查询
	public List<User> find(Map<?, ?> paraMap);    //带条件查询
	public User get(Serializable id);       //获取单条数据
	public void insert(User entity);        //插入   用实体作为参数
	public void update(User entity);        //修改   用实体作为参数
	public void delete(Serializable id);  //删除
	public void delete(Serializable[] ids); //批量删除
	
	//获取用户的角色名
	public Set<String> getRoles(Serializable email);
	
	//获取用户所拥有的权限
	public Set<String> getPerms(Serializable email);
	//获取用户的菜单
	
	public List<Resource> getResources(Serializable email,ResourceType types);
	
}
 