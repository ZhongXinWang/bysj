package graduation.design.colleges.schoolroom.help.entity;
/**
 @Author 王钟鑫
 @date 2017年12月14日 下午5:17:06
 * 
 */
public class PermResourceLink {

	private int id;
	private Perm perm;
	private Resource resource;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Perm getPerm() {
		return perm;
	}
	public void setPerm(Perm perm) {
		this.perm = perm;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
}
