package graduation.design.colleges.schoolroom.help.entity;
/**
 @Author 王钟鑫
 @date 2017年12月14日 下午4:52:07
 * 
 */
public class UserRoleLink {

	private int id;
	private User user;
	private Role role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
