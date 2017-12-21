package graduation.design.colleges.schoolroom.help.dao;

import java.io.Serializable;
import java.util.Map;

/**
 @Author 王钟鑫
 @date 2017年12月14日 下午5:32:45
 * 
 */
public interface UserDao<T> extends BaseDao<T> {

	public T login(Serializable email);
	
	public void insertUserRole(Map<?,?> maps);
	
	/*删除关联表的操作*/
	public void deleteUserRoleById(Serializable id);
	
	/*删除多条关联表的操作*/
	public void deleteUserRole(Serializable[] id);
	
	/*修改用户的角色*/
	public void updateUserRoleById(Map<?,?> maps);
	
}
