package com.test.java.obj.cast;

public class Ex55_Casting {
	public static void main(String[] args) {
		//Type Casting(형변환)
		//1. 값형 형변환 : 값형끼리 형변환(boolean 제외), 숫자형끼리 형변환(char 포함)
		//2. 참조형 형변환 : 참조형끼리 형변환, 클래스끼리 형변환.
		
		//참조형 형변환 : 상속 관계의 클래스간 형변환만 지원. 직계끼리만 가능.(방계 불가능 ex)형제끼리)
		//                   : A클래스를 B클래스로.
		//참조값 복사는 주소값 복사와 동일.
		
		//1. 업캐스팅(Up Casting) : 암시적 형변환으로, 생략가능.
		//                               : 자식 클래스 타입(원본) > 부모 클래스 타입(복사본)
		
		//2. 다운캐스팅(Down Casting) : 명시적 형변환으로, 불안정(어떤것은 안정이고, 어떤것은 불안정 한 것을 구분하기 어렵기 때문에 100% 불가능)
		//                                      : 부모 클래스 타입(원본) > 자식 클래스 타입(복사본)
		
		
		
		
		///1. 업캐스팅
		Parent p1;
		Child c1;
		
		c1=new Child();  //원본
		
		//복사
		//Parent=Child  //암시적 형변환 / 업캐스팅 : 안전.
		p1=c1;  //--> p1=(Parent)c1;
		
		//복사 후 검증방법? -> 복사된 참조 변수(p1)의 모든 멤버 접근 테스트
		p1.a=10;
		p1.b=20;
		
		System.out.println(p1.a);
		System.out.println(p1.b);
		
		//p1.c과 없는 이유는 Child타입으로 가면 4개 다 인식이 가능한데, Parent는 a,b만 가지고 있어서 두개만 볼 수 있다.
		////////////////////////////////
		/////////////////////////////////
		
		////2. 불가능한 다운 캐스팅
		/*
		Parent p2;
		Child c2;
		p2= new Parent();  //원본
		
		//Child=Parent / 명시적인 형변환 / 다운 캐스팅
		c2=(Child)p2;    //여기서 에러.
		//Parent는 a,b만 가지고 있어서 c,d는 볼 수 없다.
		
		c2.a=10;
		c2.b=20;
		c2.c=30;  //불안정
		c2.d=40;  //불안정
		
		System.out.println(c2.a);
		System.out.println(c2.b);
		System.out.println(c2.c);
		System.out.println(c2.d);
		*/
		
		////////////////////////////
		
		/////3. 가능한 다운캐스팅
		Parent p3;
		Child c3;
		
		c3=new Child();
		
		//업캐스팅
		p3=c3;
		
		
		
		//다운 캐스팅 -> 100% 불가능? 가능??
		//밑의 다운 캐스팅은 가능.
		//현재 p3 안에는 c3가 들어있기 때문에-> a,b,c,d 다 볼 수 있다는 뜻.
		Child c4;
		c4=(Child) p3;
		
		c4.a=10;
		c4.b=20;
		c4.c=30;
		c4.d=40;
		
		System.out.println(c4.a);
		System.out.println(c4.b);
		System.out.println(c4.c);
		System.out.println(c4.d);
		
	}
}
class Parent{
	public int a;
	public int b;
}
class Child extends Parent{
	public int c;
	public int d;
}

