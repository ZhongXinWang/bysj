package graduation.design.colleges.schoolroom.help.test.user;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import graduation.design.colleges.schoolroom.help.entity.Resource;
import graduation.design.colleges.schoolroom.help.entity.Role;
import graduation.design.colleges.schoolroom.help.entity.User;
import graduation.design.colleges.schoolroom.help.enums.ResourceType;
import graduation.design.colleges.schoolroom.help.service.UserService;

/**
 @Author 王钟鑫
 @date 2017年12月19日 下午8:38:10
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml","classpath:sqlMapConfig.xml"})
public class TestUser {

	private Logger log = Logger.getLogger(TestUser.class);
	@Autowired
	private UserService<User> userService;

	static String email = "940945444@qq.com";
	@Test
	public void testFindRoles(){

		Set<String> list = userService.getRoles(email);
		
		if(list != null){
			
           for (String string : list) {
				
				System.out.println(string);
			}
			
		System.out.println(list.size()+"----");
		}else{
			
			log.info("list is null");
		}
	}
	@Test
	public void testFindPerms(){
		
		
		Set<String> set = userService.getPerms(email);
		
		if(set != null){
			
			for (String string : set) {
				
				System.out.println(string);
			}
			System.out.println(set.size()+"----");
			}else{
				
				log.info("list is null");
			}
	}
	
	@Test
	public void testResource(){
		
		try{
		//获取用户的菜单
		List<Resource> list = userService.getResources(email, ResourceType.MENU);
		if(list != null && list.size() > 0){
			
			
			for (Resource resource : list) {
				
				log.info("菜单:"+resource.getResourceName()+"\n");
			}
			
		}
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	//添加一个用户
	@Test
	public void testInsert(){
		try{
			
		User entity = new User();
		entity.setEmail("60606500@qq.com");
		entity.setMobile("2222222222");
		entity.setPassword("789456");
        List<Role> role = new ArrayList<>();
        Role r = new Role();
        r.setId("1");
        Role r1 = new Role();
        r1.setId("2");
        role.add(r);
        role.add(r1);
        entity.setRoles(role);
		userService.insert(entity);
		
          }catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	/*
	 * 删除一个用户，还需要把分配给用户的sys_user_role删除掉,
	 * 我们是通过给角色表分配资源的，所以删除以个用户只需要删除和用户关联的用户角色表
	 * */
	/*删除单条*/
    @Test
    public void testDeleteById(){
    	try{
    		
    		
    	//删除一条
        userService.delete("4bb38641-f682-4985-89e7-cdf1af9902a7");
    		
    		
    		
    	}catch(Exception e){
    		
    		e.printStackTrace();
    	}
    	
    	
    }
	
    //删除多条
    @Test
    public void delete(){
    	
    	try{
    		
    		
    		String[] ids = new String[]{"10cacc04-1483-463e-aa4a-f3b80053abfc","24cee12f-5cf9-4aa0-9a9c-577cd0e0cf11","f4110396-5a2d-438d-b074-4d8720544c7a"};
    		
    		userService.delete(ids);
    		
    	}catch(Exception e){
    		
    		e.printStackTrace();
    	}
    	
    }
    
    //修改用户个人信息
    @Test
    public void testUpdate(){
    	
    	//获取一条记录
    	
    	User user = userService.get("f48b3fd1-372c-4c37-9481-ce28b08868d1");
    	
    	log.info("update:"+user.getId()+"---"+user.getEmail()+"---"+user.getImageURL());
    	
    	//已 id 作为更新数据,界面操作的时候需要hidden提交
    	user.setEmail("1000000@gmail");
    	user.setUserName("张三");
    	userService.update(user);
    }
    //修改用户与角色的关联   必须要获得用户的userId  和roleId  update 的时候还要两者相等
    
    @Test
    public void testUpdateUserRole(){
    	
    	
    	
    }
	@After
	public void destory(){
		
		if(userService != null){
			
			userService = null;
		}
		
	}
}
