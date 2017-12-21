package graduation.design.colleges.schoolroom.help.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import graduation.design.colleges.schoolroom.help.dao.RoleDao;
import graduation.design.colleges.schoolroom.help.entity.Perm;
import graduation.design.colleges.schoolroom.help.entity.Role;
import graduation.design.colleges.schoolroom.help.enums.ResourceType;
import graduation.design.colleges.schoolroom.help.pagination.Page;
import graduation.design.colleges.schoolroom.help.service.PermService;
import graduation.design.colleges.schoolroom.help.service.RoleService;

/**
 * @Author 王钟鑫
 * @date 2017年12月19日 下午5:11:43
 * 
 */
@Service
public class RoleServiceImpl implements RoleService<Role> {

	@Resource
	private RoleDao<Role> roleDao;

	@Resource
	private PermService<Perm> permService;

	@Override
	public List<Role> findPage(Page<?> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> find(Map<?, ?> paraMap) {

		return roleDao.find(paraMap);
	}

	@Override
	public Role get(Serializable id) {

		return roleDao.get(id);
	}

	@Override
	public void insert(Role entity) {

		// 使用UUID来创建主键
		entity.setId(UUID.randomUUID().toString());
		// 设置状态为启用
		entity.setStatus("1");
		roleDao.insert(entity);
	}

	@Override
	public void update(Role entity) {

		roleDao.update(entity);
	}

	@Override
	public void delete(Serializable id) {

		roleDao.delete(id);
	}

	@Override
	public void delete(Serializable[] ids) {

		roleDao.delete(ids);
	}

	public void setRoleDao(RoleDao<Role> roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public List<Role> getRoles(Serializable email) {

		List<Role> list = roleDao.getRoles(email);
		if (list != null && list.size() > 0) {

			return list;
		}
		return null;
	}

	// 根据roles获取到权限的信息
	@Override
	public Set<String> getPerms(Serializable email) {

		// 根据email获取到对应的roleID
		List<Role> list = getRoles(email);
		if (list != null) {

			String[] roleIds = new String[list.size()];
			int i = 0;
			for (Role role : list) {

				roleIds[i] = role.getId();
				i++;
			}

			// 根据roleID 获取到权限
			List<Perm> perms = permService.getPerms(roleIds);
			if (perms != null && perms.size() > 0) {

				Set<String> permNames = new HashSet<>();
				for (Perm p : perms) {

					permNames.add(p.getPermName());
				}

				return permNames != null ? permNames : null;

			}
		}

		return null;
	}

	@Override
	public List<graduation.design.colleges.schoolroom.help.entity.Resource> getResources(Serializable email,
			ResourceType types) {
		// 根据email获取到对应的roleID
		List<Role> list = getRoles(email);

		if (list != null && list.size() > 0) {

			String[] roleIds = new String[list.size()];
			int i = 0;
			for (Role role : list) {

				roleIds[i] = role.getId();
				i++;
			}
			// 根据roleID 获取到权限

			List<Perm> perms = permService.getPerms(roleIds);
			if (perms != null && perms.size() > 0) {

				List<String> permIds = new ArrayList<>();
				for (Perm p : perms) {

					permIds.add(p.getId());
				}

		        Map<Object,Object> maps = new HashMap<>();
				maps.put("dataList", permIds);
				maps.put("ctypes", types.name().toString());
				
				return permService.getResources(maps);

			}
		}

		return null;
	}
}
