package graduation.design.colleges.schoolroom.help.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 王钟鑫
 * @date 2017年12月14日 下午9:35:26
 * 
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public String showLoginForm(HttpServletRequest req, Model model) {
		//获取shiro上面的错误信息
		String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");
		String error = null;
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if("jCaptcha.error".equals(exceptionClassName)) {
	        error = "验证码错误";
		}else if (exceptionClassName != null) {
			error = "其他错误：" + exceptionClassName;
		}
		model.addAttribute("error", error);
		return "login";
	} 
}
