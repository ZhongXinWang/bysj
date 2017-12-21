package graduation.design.colleges.schoolroom.help.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import graduation.design.colleges.schoolroom.help.entity.User;
import graduation.design.colleges.schoolroom.help.service.UserService;


/**
 @Author 王钟鑫
 @date 2017年12月13日 下午9:59:06
 * 用于用户验证，授权，设置角色
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService<User> userService;


	//授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	super.clearCachedAuthenticationInfo(principals);
    	String email = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        
        
        Set<String> roles = userService.getRoles(email);
        Set<String> perms = userService.getPerms(email);
        //设置角色
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(perms);
        return authorizationInfo;
    }
   //身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

    //	System.out.println("验证"+token.getPrincipal().toString()+"---"+(String)token.getCredentials());
        String email = (String)token.getPrincipal();

       User user = userService.login(email);
  
       System.out.println("hello");
        if(user == null) {
        	
            throw new UnknownAccountException();//没找到帐号
        }
        System.out.println(user.getEmail()+"---"+user.getPassword()+"--"+ ByteSource.Util.bytes(user.getUserName()+user.getSalt()));
        if("0".equals(user.getStatus())) {
            throw new LockedAccountException(); //帐号锁定
        }
        //从数据库读取的数据，加密放到authenticationInfo中
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getEmail(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getUserName()+user.getSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
        
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
	public void setUserService(UserService<User> userService) {
		this.userService = userService;
	}

}