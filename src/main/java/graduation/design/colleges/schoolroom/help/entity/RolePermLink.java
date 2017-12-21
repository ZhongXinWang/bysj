package graduation.design.colleges.schoolroom.help.entity;
/**
 @Author 王钟鑫
 @date 2017年12月14日 下午5:08:40
 * 
 */
public class RolePermLink {

	private Integer id;
	private Role role;
	private Perm perm;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Perm getPerm() {
		return perm;
	}
	public void setPerm(Perm perm) {
		this.perm = perm;
	}
	
}
