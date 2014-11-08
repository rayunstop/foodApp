package org.meishi.app.modules.user.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.meishi.app.commons.orm.UserEntity;

@Entity
@Table(name = "user")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends UserEntity implements Serializable{


	private static final long serialVersionUID = 371495163136675129L;
	
	
}
