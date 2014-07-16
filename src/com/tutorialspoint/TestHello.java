package com.tutorialspoint;

public class TestHello {
	private Integer iamint;

	public void getIamint() {
		System.out.println("TestHello : "+iamint);
	}

	public void setIamint(Integer iamint) {
		this.iamint = iamint;
	}

	public void init() {
		this.iamint = 5;
		System.out.println("Initializing TestHello with value : " + iamint);
	}
	
	public void destroy() {
		this.iamint = 0;
		System.out.println("Destroying TestHello with value : " + iamint);
	}
}
