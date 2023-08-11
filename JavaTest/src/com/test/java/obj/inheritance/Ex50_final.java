package com.test.java.obj.inheritance;

import java.util.Calendar;

public class Ex50_final {
	public static void main(String[] args) {
		//final 변수 : 한번 결정하면 바꿀 수 없다. 왜 사용? -> 안정성이 높기 때문에
		
		//변수(지역변수, 멤버변수) : 초기화 이후 값을 변경할 수 없는 상수 역할을 한다.                => 얘만 자주 사용함.
		//메소드 : 상속에서만 나타남, 오버라이드 금지 => 부모 메소드를 수정하지 못하게 하는 것
		//클래스 적용가능 : 상속에서만 일어남. 부모 클래스를 수정하지 못하게 하는 것
		
		int a=10;  //지역변수
		a=20;
		a=30;
		
		//final 변수 = 상수
		final int b=10;
		//b=20;  //변경 불가능.
		
		final int c;  //단순 변수처럼 보이기 때문에 권장안함. 권장은 아예 선언하고 초기화까지 한번에.
		c=10;  //초기화를 나중에 하는 건 가능.
		//c=20;  //나중에 초기화해도 변경은 불가능.
		
		final int d=10;
		final int E=10;
		//////////////////
		
		Test t= new Test();
		t.a=20;
		//t.b=30;  //final로 선언해서 값 변동못함.
		
		test(100);
		////////////
		
		System.out.println(Calendar.YEAR);  //캘린더 상수
		//Calendar.YEAR=2;   //에러->static final 변수이기 때문에.
		
		int gender;  //무의미한 코드
		gender=1;
		gender=2;
		
		final int MALE=1;
		final int FEMALE=2;
		
		System.out.println(Gender.MALE);
		System.out.println(Gender.FEMALE);
		
	}
	public static void test(final int a) {
		System.out.println(a);
		//a=200;   => 변동 불가능.
		
	}
}
class Test{
	public int a=10;
	public final int b=20;   //멤버변수
}

//남자=1, 여자=2  ==>열거값 : 비슷한 형태의 값들이 나열되어있는 경우
class Gender{
	public final static int MALE=1;  //object를 안만들고 손쉽게 접근할 수 있도록 사용하는 용도.
	public final static int FEMALE=2;
	
}
////////////////////////////////////
class finalParent{
	final public void test() {  //test() 메소드가 중요해서 나중에 상속받은 자식 클래스가 이 test() 메소드를 정의하면 안될 것 같을때 사용.
		System.out.println("부모 메소드");
		//final을 붙이면 오버라이드를 못함.
	}
	
}
class finalChild extends finalParent{
	/*
	@Override
	public void test() {
		System.out.println("자식 메소드");
	}
	*/
	
}
///////////////////////////
final class FinalMember{   //final => 나도 힘드니까, 상속을 불가능하게 할 수 있다.
	
}

//
//class FinalUser extends FinalMember{	
//}
