package com.test.java.obj.collection;
import java.util.*;
import java.io.*;

public class Ex66_Anonymous {
	public static void main(String[] args) {
		//익명 객체(Anonymous Object), 익명 클래스(Anonymous Class)
		//이름 없는 클래스
		
		//Q. 인터페이스를 구현한 클래스 선언하고 객체를 생성하라.
		
		//1. 본인 타입으로 참조 변수 만들기
		BBB b1=new BBB();
		b1.aaa();
		System.out.println();
		
		//2. 부모 타입으로 참조변수 만들기 -> 여기서 부모는 인터페이스.
		AAA b2=new BBB();
		b2.aaa();
		System.out.println();
		
//		3. 껍데기만 있고 구현부는 없기 때문에 불가능. 객체생성 불가능
//		AAA b3=new AAA();
//		b3.aaa();
//		System.out.println();
		
		//4.
		AAA b3=new AAA() {
			@Override
			public void aaa() {
				System.out.println("aaa");
			}
		};
		b3.aaa();
		/*  머리통 없는 클래스라고 생각하기. -> 이름 없는 익명 클래스
		 new AAA()는 그냥 없다고 생각하기.(부모 인터페이스)
		 무조건 자동으로 new AAA()의 자식 클래스가 됨.
		{
			@Override
			public void aaa() {
				System.out.println("aaa");
			}
		};
		*///==AAA b2=new BBB(); 와 같다고 생각하면 된다.
		
		//b2 vs b3 비교
		//b2는 AAA인터페이스를 선언하고, BBB클래스를 구현
		
		//b3는 AAA인터페이스를 선언하고, 실명 클래스가 아닌 익명 클래스를 구현
		//왜? 익명 클래스를 구현하는 것은 클래스의 재사용성 때문인데,
		//익명 클래스는 재사용 의사가 없다는 뜻이고,
		//실명 클래스는 재사용 의사가 있다는 뜻이다.
		
		//클래스의 사용 목적은 객체를 생성하기 위해!
		Test t1=new Test();
		Test t2=new Test();
		Test t3=new Test();
		
		//익명 클래스는 딱 1개의 붕어빵을 만들기 위한 붕어빵 틀.
		//나는 여러개 필요없어. 목적에 필요한 인터페이스 하나를 잡고 인스턴스를 생성한다.
		AAA t4=new AAA() {
			@Override
			public void aaa() {
				
			}
		};
		//위와 아래는 전혀 다른 별도의 클래스->동명이인 같은 느낌.
		AAA t5=new AAA() {
			@Override
			public void aaa() {
				
			}
		};
		
	}
}
class Test{
	public int a;
	public int b;
	public void ccc() {
		
	}
}
interface AAA{
	void aaa();
}
//The type BBB must implement the inherited abstract method AAA.aaa()
class BBB implements AAA{
	@Override
	public void aaa() {
		System.out.println("aaa");
	}
	
}
