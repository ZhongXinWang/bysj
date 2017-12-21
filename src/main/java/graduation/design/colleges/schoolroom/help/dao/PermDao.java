package graduation.design.colleges.schoolroom.help.dao;

import java.io.Serializable;
import java.util.List;

/**
 @Author 王钟鑫
 @date 2017年12月14日 下午5:32:45
 * 
 */
public interface PermDao<T> extends BaseDao<T> {

	
	//获取权限信息信息
	  public List<T> getPerms(Serializable[] roleIds);
	
}
