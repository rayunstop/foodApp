package org.meishi.app.commons.orm;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * spring data jpa »ùÀà
 * @author Rui
 * @since 2014-06-19
 */
public interface BasicJpaRepository<T,PK extends Serializable> extends JpaRepository<T, PK>,JpaSpecificationExecutor<T>{

}
