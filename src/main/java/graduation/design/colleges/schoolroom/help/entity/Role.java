package graduation.design.colleges.schoolroom.help.entity;

import java.io.Serializable;
import java.util.List;

/**
 @Author 王钟鑫
 @date 2017年12月14日 下午4:24:57
 * 
 */
public class Role  implements Serializable{

	private static final long serialVersionUID = 1L;
    
	private String id;
	private String roleName;
	private String des;
	private String createTime;
	private String createBy;
	private long orderNo;
	private String status;
	
	/*关联用户表*/
	private List<User> users;
	/*关联权限表*/
	private List<Perm> perms;
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Perm> getPerms() {
		return perms;
	}
	public void setPerms(List<Perm> perms) {
		this.perms = perms;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	
}
