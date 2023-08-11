package com.test.java.obj.inheritance;

public class Ex45_Inheritance {
	public static void main(String[] args) {
		//상속_Inheritance : 부모(클래스)가 가지는 재산(클래스가 소유하고 있는 변수 및 메소드)을 자식(클래스)에게 물려주는 행동
		//                     : 자식 클래스가 코드를 구현하지 않아도, 부모 클래스로부터 구현된 코드를 물려받는 행동
		//                     : 상속하는 이유 => *****코드 재사용으로 비용이 절감.
		
		//상속 관계에 있는 간의 클래스 호칭
		//- 부모 클래스 : 슈퍼 클래스 : 기본 클래스 : 기본 클래스
		//- 자식 클래스 : 서브 클래스 : 확장 클래스 : 파상 클래스
		
		Parent p=new Parent();
		p.a=10;
		p.b=20;
		
		Child c = new Child();   //이게 상속.
		c.a=10;
		c.b=20;   //부모 클래스가 물려준 멤버, 변수 상속
		c.aaa();   //메소드 상속.
		
		c.c=30;
		c.d=40;
		c.ccc();
		
		
	}
}
class Parent{  //부모 클래스
	public int a;
	public int b;
	//private으로 만들면 getter/setter를 만들어야 하므로 간략하게 public으로.
	
	public void aaa() {
		System.out.println("aaa");
	}
	
}
//자식이 부모를 내 부모라고 가리키는 방식. 반대는 없음. 부모가 먼저 태어나기 때문에. 부모는 없는 자식을 가리킬수 없음.
class Child extends Parent{  //자식 클래스  //물려받을 건 받고, 자신만의 활동도 하기.
	public int c;
	public int d;
	
	public void ccc() {
		System.out.println("ccc");
	}
	
}
//////////////
//회원  1. 일반회원 : 이름, 아이디, 암호, 이메일 주소 / 2. 관리자 회원 : 이름, 아이디, 암호, 관리자 등급이 있음.
class Member{  //부모는 자식 여러명 가질 수 있음.
	public String name;
	public String id;
	public String pw;
}
class User extends Member{  //일반회원  
	public String email;
	
}
class Administrator extends Member{  //관리자 회원
	public String lv;

}
/////////////////////
class AAA{
	public int a=10;
}
class BBB extends AAA {
	public int b=20;
}
class CCC extends BBB{
	public int c=30;
}
class DDD extends CCC{
	public int d=40;
}


