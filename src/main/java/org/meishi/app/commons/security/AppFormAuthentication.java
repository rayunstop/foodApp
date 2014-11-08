package org.meishi.app.commons.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.meishi.app.modules.admin.model.CompanyBackUser;
import org.meishi.app.modules.admin.service.ICompanyBackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="appFormAuthentication")
public class AppFormAuthentication extends FormAuthenticationFilter {
	
	private final static String CAPTCHACODE = "captcha";
	
	@Autowired
	private ICompanyBackUserService companyBackUserService;
	
	@Override
	protected AuthenticationToken createToken(ServletRequest request,
			ServletResponse response) {
		
		String username = getUsername(request);
		String password = getPassword(request);
		String captcha = getCaptcha(request);
		return new UsernamePasswordToken(username, password.toCharArray(),isRememberMe(request), getHost(request), captcha);
	}
	
	public String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, CAPTCHACODE);
	}

	//统计登陆次数
	@Override
	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		UsernamePasswordToken tokenApp = (UsernamePasswordToken) token;
		CompanyBackUser cbu = companyBackUserService.findByName(tokenApp.getUsername());
		cbu.setFailLoginCount(cbu.getFailLoginCount()+1);
		companyBackUserService.saveOrUpdate(cbu);
		return super.onLoginFailure(token, e, request, response);
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		UsernamePasswordToken tokenApp = (UsernamePasswordToken) token;
		CompanyBackUser cbu = companyBackUserService.findByName(tokenApp.getUsername());
		if(cbu != null && cbu.getLocked().equals(Boolean.FALSE)){
			cbu.setSuccessLoginCount(cbu.getSuccessLoginCount()+1);
			companyBackUserService.saveOrUpdate(cbu);
		}
		return super.onLoginSuccess(token, subject, request, response);
	}

	@Override
	protected boolean isLoginSubmission(ServletRequest request,
			ServletResponse response) {
		String username = getUsername(request);
		if(username == null ){
			return false;
		}
		if(username.trim().equals("")){
			return false;
		}
		return super.isLoginSubmission(request, response);
	}


	
	

	
	
	
	
	
	
	

	
}
