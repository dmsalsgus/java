package com.test.java.obj;

public class Ex37_Class {
	public static void main(String[] args) {
		
		User u1= new User();  //User 클래스 선언.
		u1.name="홍길동";
		u1.age=20;
		u1.hello();
		
		User u2=new User();
		u2.name="아무개";
		u2.age=22;
		u2.hello();
		////////////////////////
		MyMath m1=new MyMath();
		m1.add(10,20);
		m1.substract(100, 50);
		
		MyMath m2=new MyMath();
		m2.add(10,20);
		m2.substract(100, 50);
		
	}
}
//클래스 = 데이터(클래스 변수) + 행동(클래스 메소드)의 집합
class User{  //틀
	//클래스 멤버 변수(==프로퍼티, 특성)
	public String name;
	public int age;
	
	//클래스 멤버 메소드 : 호출되는 객체에 따라 다른 결과가 나와야 한다.
	//***클래스 멤버 메소드는 멤버 변수를 활용해서 행동을 해야 한다.(필수) 
	public void hello() {
		System.out.println("안녕하세요. 저는 "+name+"입니다.");
	}
}
class MyMath{  //메소드만 있는 class도 존재 가능.
	//개성 없는 메소드이다. 객체간의 행동 구분이 불가능하기때문에.
	public void add(int a, int b) {
		System.out.println(a+b);
	}
	public void substract(int a, int b){
		System.out.println(a-b);
	}
}
