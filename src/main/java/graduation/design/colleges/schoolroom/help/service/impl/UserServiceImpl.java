package graduation.design.colleges.schoolroom.help.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import graduation.design.colleges.schoolroom.help.dao.UserDao;
import graduation.design.colleges.schoolroom.help.entity.Role;
import graduation.design.colleges.schoolroom.help.entity.User;
import graduation.design.colleges.schoolroom.help.enums.ResourceType;
import graduation.design.colleges.schoolroom.help.pagination.Page;
import graduation.design.colleges.schoolroom.help.service.PasswordHelperService;
import graduation.design.colleges.schoolroom.help.service.RoleService;
import graduation.design.colleges.schoolroom.help.service.UserService;
/**
 * @Author 王钟鑫
 * @date 2017年12月14日 下午5:40:55
 * 
 */
@Service
public class UserServiceImpl implements UserService<User> {

	@Resource
	private UserDao<User> userDao;
	@Resource
	private PasswordHelperService passwordHelper;

	@Resource
	private RoleService<Role> roleService;

	@Override
	public User login(Serializable email) {

		return userDao.login(email);
	}

	@Override
	public List<User> findPage(Page<?> page) {
		return null;
	}

	@Override
	public List<User> find(Map<?, ?> paraMap) {

		return userDao.find(paraMap);
	}

	@Override
	public User get(Serializable id) {

		return userDao.get(id);
	}
	// 根据email，可以获得用户的角色信息
	@Override
	public Set<String> getRoles(Serializable email) {

		
		List<Role> list = roleService.getRoles(email);
		if (list != null && list.size() > 0) {

			Set<String> set = new HashSet<>();
			for (Role role : list) {

				set.add(role.getRoleName());	
			}
			
			return set != null?set:null;

		}

		return null;
	}

	//根据email获取到该用户具有的权限信息
	@Override
	public Set<String> getPerms(Serializable email) {

		return roleService.getPerms(email);
	}
	
	//根据email来获取到该用户的菜单信息
	@Override
	public List<graduation.design.colleges.schoolroom.help.entity.Resource> getResources(Serializable email,ResourceType types) {

		
		return roleService.getResources(email, types);
	}

	//添加用户时，需要获得用户对应的role_id，需要在aop中开启事务，才能保证数据的一致性
	@Override
	public void insert(User entity) {

		// 使用UUID来创建主键
		entity.setId(UUID.randomUUID().toString());
		// 设置状态为启用
		entity.setStatus("1");

		// 加密密码，使用cglib 动态代理CglibAopProxy进行entity的赋值，并返回
		passwordHelper.encryptPassword(entity);
		
		//添加用户的时候需要指定用户的角色
		
		userDao.insert(entity);
		
		//添加关联表的数据
		Map<Object,Object> maps = new HashMap<Object, Object>();
		maps.put("userId", entity.getId());
		maps.put("roleIds", entity.getRoles());

		userDao.insertUserRole(maps);
	}

	@Override
	public void update(User entity) {

		userDao.update(entity);
	}

	@Override
	public void delete(Serializable id) {

		userDao.delete(id);
		
		/*删除关联表的操作*/
		userDao.deleteUserRoleById(id);
	}

	@Override
	public void delete(Serializable[] ids) {

		userDao.delete(ids);
		
		/*批量删除关联表*/
		userDao.deleteUserRole(ids);
	}

	public void setUserDao(UserDao<User> userDao) {
		this.userDao = userDao;
	}
}
