package graduation.design.colleges.schoolroom.help.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import graduation.design.colleges.schoolroom.help.dao.PermDao;
import graduation.design.colleges.schoolroom.help.entity.Perm;
import graduation.design.colleges.schoolroom.help.enums.ResourceType;
import graduation.design.colleges.schoolroom.help.pagination.Page;
import graduation.design.colleges.schoolroom.help.service.PermService;
import graduation.design.colleges.schoolroom.help.service.ResourceService;
import graduation.design.colleges.schoolroom.help.service.RoleService;

/**
 @Author 王钟鑫
 @date 2017年12月19日 下午5:08:28
 * 
 */
@Service
public class PermServiceImpl implements PermService<Perm>{

	@Resource
	private PermDao<Perm> permDao;
	
	@Resource
	private ResourceService<graduation.design.colleges.schoolroom.help.entity.Resource> resourceService;
	@Override
	public List<Perm> findPage(Page<?> page) {

		return null;
	}

	@Override
	public List<Perm> find(Map<?, ?> paraMap) {

		return permDao.find(paraMap);
	}

	@Override
	public Perm get(Serializable id) {

		return permDao.get(id);
	}

	@Override
	public void insert(Perm entity) {

		//使用UUID来创建主键
		entity.setId(UUID.randomUUID().toString());
		//设置状态为启用
		entity.setStatus("1");
		
		permDao.insert(entity);
	}

	@Override
	public void update(Perm entity) {

		permDao.update(entity);
	}

	@Override
	public void delete(Serializable id) {

		permDao.delete(id);
	}

	@Override
	public void delete(Serializable[] ids) {

		permDao.delete(ids);
	}

	public void setPermDao(PermDao<Perm> permDao) {
		this.permDao = permDao;
	}

	@Override
	public List<Perm> getPerms(Serializable[] roleIds) {

		
		
		return permDao.getPerms(roleIds);
	}

	@Override
	public List<graduation.design.colleges.schoolroom.help.entity.Resource> getResources(Map<?,?> maps) {


		return resourceService.getResources(maps);
	}

	
}
