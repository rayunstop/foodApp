package org.meishi.app.commons.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.meishi.app.commons.servlet.ValidateCodeServlet;
import org.meishi.app.modules.admin.model.CompanyBackUser;
import org.meishi.app.modules.admin.service.ICompanyBackUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class AppRealm extends AuthorizingRealm {

	@Autowired
	private ICompanyBackUserService companyBackUserService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authToken;
		String captcha = (String) SecurityUtils.getSubject().getSession().getAttribute(ValidateCodeServlet.VALIDATE_CODE);
		CompanyBackUser cbu = companyBackUserService.findByName(token.getUsername());
		if(cbu == null){
			throw new UnknownAccountException();
		}
		if(cbu.getLocked().equals(Boolean.TRUE)){
			throw new LockedAccountException();
		}
		if(token.getCaptcha() != null &&!captcha.equalsIgnoreCase(token.getCaptcha())){
			throw new IncorrectCaptchaException("验证码错误！");
		}
		return new SimpleAuthenticationInfo(
				cbu.getUsername(),
				cbu.getPassword(),
				ByteSource.Util.bytes(cbu.getSalt()),
				getName()
				);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("***********************************");
		return null;
	}
}
