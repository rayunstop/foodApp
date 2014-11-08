package org.meishi.app.commons.test;

public class TestBean {

	private int age;
	private String sex;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "TestBean [age=" + age + ", sex=" + sex + "]";
	}
	
	
}
