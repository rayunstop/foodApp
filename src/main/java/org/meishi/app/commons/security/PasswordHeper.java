package org.meishi.app.commons.security;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.meishi.app.commons.orm.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class PasswordHeper {

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
    private int hashIterations = 2;
    
	public String getAlgorithmName() {
		return algorithmName;
	}
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	public int getHashIterations() {
		return hashIterations;
	}
	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}
    
	public void encryptPassword(UserEntity userEntity){
		userEntity.setSalt(randomNumberGenerator.nextBytes().toHex());
		
		String afterEncryptPassword = new SimpleHash(
				algorithmName, 
				userEntity.getPassword(), 
				ByteSource.Util.bytes(userEntity.getSalt()), 
				hashIterations).toHex();
		userEntity.setPassword(afterEncryptPassword);
	}
    
	
}
