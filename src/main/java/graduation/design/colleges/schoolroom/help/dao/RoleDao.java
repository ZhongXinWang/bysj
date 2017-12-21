package graduation.design.colleges.schoolroom.help.dao;

import java.io.Serializable;
import java.util.List;

/**
 @Author 王钟鑫
 @date 2017年12月14日 下午5:32:45
 * 
 */
public interface RoleDao<T> extends BaseDao<T> {


	//获取角色信息
	public List<T> getRoles(Serializable email);
}
