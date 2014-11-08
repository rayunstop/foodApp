package org.meishi.app.modules.user.dao;

import org.meishi.app.commons.orm.BasicJpaRepository;
import org.meishi.app.modules.user.model.User;

public interface IUserDao extends BasicJpaRepository<User, Long> {

}
