package com.test.java.obj.inheritance;

public class Ex46_Object {
	public static void main(String[] args) {
		//Object이름의 클래스가 있음(객체를 의미하는 것이 아님.) : jdk에서 제공되는 클래스
		//모든 클래스의 근원이 되는 클래스이므로, 루트 클래스라고도 불림. (트리 구조 생각하기)
		//9개의 메소드가 존재하는데, 모든 클래스들에게 공통으로 필요하다 생각하다고 생각하는 기능을 구현.
		
		Object o1=new Object();  //자바에서 가장 중요한 클래스**
		
		
		TestChild c= new TestChild();
		c.a=10;
		c.b=20;
		c.c=30;
		c.d=40;
		
	}
}
//개발자가 만드는 모든 클래스는 명시적으로 상속을 구현하지 않으면 자동으로 Object 클래스의 자식 클래스가 된다.
class TestParent { //extends Object{
	public int a;
	public int b;
}

class TestChild extends TestParent{
	public int c;
	public int d;
	
}


