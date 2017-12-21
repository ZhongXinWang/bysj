package graduation.design.colleges.schoolroom.help.dao;

import java.util.List;
import java.util.Map;

import graduation.design.colleges.schoolroom.help.entity.Resource;

/**
 @Author 王钟鑫
 @date 2017年12月14日 下午5:32:45
 * 
 */
public interface ResourceDao<T> extends BaseDao<T> {

	public List<Resource> getResources(Map<?,?> maps);
	
}
