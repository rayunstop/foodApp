package org.meishi.app.modules.admin.dao;

import org.meishi.app.commons.orm.BasicJpaRepository;
import org.meishi.app.modules.admin.model.CompanyBackUser;

public interface ICompanyBackUserDao extends BasicJpaRepository<CompanyBackUser, Long>{

	public CompanyBackUser findByUsername(String username);
}
