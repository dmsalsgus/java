package com.test.java.obj;

public class Ex43_Constructor {
	public static void main(String[] args) {
		
		//Member m1=new Member();   //매개변수가 있기때문에 기본 생성자는 호출 불가능.
		Member m1=new Member("hong","1111","홍길동",1);
		System.out.println(m1.info());
		
	}
}
