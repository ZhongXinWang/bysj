package graduation.design.colleges.schoolroom.help.entity;

import java.io.Serializable;
import java.util.List;

/**
 @Author 王钟鑫
 @date 2017年12月14日 下午4:37:01
 * 
 */
public class Resource  implements Serializable{

	private static final long serialVersionUID = 1L;
    
	private Integer id;
	private String resourceName;
	private String ctype;
	private String url;
	private Integer parentId;
	private String parentIds;
	private String createTime;
	private String createBy;
	private long orderNo;
	private String status;
	/*图标*/
	private String icon;
	/*资源表和权限表之间的关联*/
	private List<Perm> perms;
	public List<Perm> getPerms() {
		return perms;
	}
	public void setPerms(List<Perm> perms) {
		this.perms = perms;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getParentIds() {
		return parentIds;
	}
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	

	
}
