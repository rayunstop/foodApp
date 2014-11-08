package org.meishi.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.LockedAccountException;
import org.meishi.app.commons.security.IncorrectCaptchaException;
import org.meishi.app.commons.test.TestBean;
import org.meishi.app.modules.admin.service.ICompanyBackUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ICompanyBackUserService companyBackUserService;
	
	
	@RequestMapping(value = "/login" ,method = RequestMethod.GET)
	public String index(){
		return "login";
	}	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@ModelAttribute("username") String username,HttpServletRequest request,Model model){
		String error = (String) request.getAttribute("shiroLoginFailure");
		if(error != null){
			if(error.equals(IncorrectCaptchaException.class.getName())){
				error = "验证码错误！";
			}else if(error.equals(LockedAccountException.class.getName())){
				error = "账号被锁定！请联系管理员";
			}else{
				error = "用户名或密码错误！";
			}
		}
		model.addAttribute("error",error);
		return "login";
	}
	
	@RequestMapping(value = "/test")
	public @ResponseBody String test(@RequestParam(required = false,value = "data") TestBean beans,@RequestParam("param2") String param2){
		System.out.println(param2);
		
		if(beans != null){
			System.out.println(beans);
		}
		
		return "test";
	}
	
}
