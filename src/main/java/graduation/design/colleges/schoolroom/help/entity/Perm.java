package graduation.design.colleges.schoolroom.help.entity;

import java.io.Serializable;
import java.util.List;

/**
 @Author 王钟鑫
 @date 2017年12月14日 下午4:31:53
 * 
 */
public class Perm implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String permName;
	private String des;
	private String status;
	private String createTime;
	private String createBy;
	private long orderNo;
	
	/*
	 和角色表之间的关联
	 */
	private List<Role> roles;
	/*和资源之间的关联*/
	private List<Resource> resources;
	public List<Role> getRoles() {
		return roles;
	}
	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPermName() {
		return permName;
	}
	public void setPermName(String permName) {
		this.permName = permName;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
