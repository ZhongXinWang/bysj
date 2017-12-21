package graduation.design.colleges.schoolroom.help.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;

import graduation.design.colleges.schoolroom.help.dao.ResourceDao;
import graduation.design.colleges.schoolroom.help.entity.Resource;
import graduation.design.colleges.schoolroom.help.pagination.Page;
import graduation.design.colleges.schoolroom.help.service.ResourceService;

/**
 @Author 王钟鑫
 @date 2017年12月19日 下午5:14:16
 * 
 */
@Service
public class ResourceServiceImpl implements ResourceService<Resource> {

	@javax.annotation.Resource
	private ResourceDao<Resource> resourceDao;
	@Override
	public List<Resource> findPage(Page<?> page) {
		return null;
	}

	@Override
	public List<Resource> find(Map<?, ?> paraMap) {

		return resourceDao.find(paraMap);
	}

	@Override
	public Resource get(Serializable id) {

		return resourceDao.get(id);
	}

	@Override
	public void insert(Resource entity) {

		resourceDao.insert(entity);
	}

	@Override
	public void update(Resource entity) {

		resourceDao.update(entity);
	}

	@Override
	public void delete(Serializable id) {

		resourceDao.delete(id);
	}

	@Override
	public void delete(Serializable[] ids) {

		resourceDao.delete(ids);
	}

	public void setResourceDao(ResourceDao<Resource> resourceDao) {
		this.resourceDao = resourceDao;
	}

	@Override
	public List<Resource> getResources(Map<?,?> maps) {


		
		return resourceDao.getResources(maps);
	}

	
}
