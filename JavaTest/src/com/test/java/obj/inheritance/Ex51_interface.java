package com.test.java.obj.inheritance;

public class Ex51_interface {
	public static void main(String[] args) {
		//인터페이스(interface) : 클래스의 일종으로 클래스의 변형된 형태. 자료형이다.
		//                            : 인터페이스는 객체를 생성할 수 없다. but 참조변수는 생성할 수 있다.
		//                            : 클래스의 부모역할을 하며, 상속관계로 만들어진다.
		
		//인터페이스는 상속받는 여러 클래스들을 행동(사용법, 메소드)들을 통일시키는 역할을 한다. -> 즉, 행동 규약 정의.
		
		//Mouse m1=null;  //=new Mouse();
		//m1.click();
		
		M705 m1=new M705();
		m1.click();
		m1.click();
		
		G304 g1=new G304();
		//g1.push();
		g1.click();  //상속받고 나서 호출한 것.
		
		//위의 큰 문제점 : 클릭은 잘 되지만 사용자 경험을 살리지 못했다...!!-> 인터페이스 상속만 받으면됨.
		
		
	}
}
//class 밖에서 interface선언.
interface Mouse {
	//인터페이스 멤버
	//멤버 변수
	//멤버 메소드
	//인터페이스는 추상 멤버만을 가질 수 있다.(추상 메소드만 가질 수 있다.)
	
	/* -> 에러 : 인터페이스는 구현된 멤버를 가질 수 없다.****
	//****인터페이스는 구현부를 가진 메소드를 소유할 수 없다.
	public int a;
	public void aaa() {
		//구현부
	}
	*/
	public void click();  //이렇게 표현 가능.
	//껍데기만 가지고 있고 애매모호해서 추상 메소드(Abstract Method)라고 부름.(구현부 없이 선언부만 가지는 메소드)
	
}
class M705 implements Mouse{
	//부모가 인터페이스일 경우 extends말고 implements로 써야한다.
	//인터페이스를 상속받는 클래스는 반드시 인터페이스의 추상 메소드를 구현해야 한다.*********
	//상속받은 클릭을 무조건 구현해야함.
	/*
	public void click() {  //추상메소드를 구현했다. 없던 구현부를 만든것. -> 일종의 오버라이딩
		
	}
	*/
	//@Override
	public void click() {
		//System.out.println("클릭");
	}
	
}
class G304 implements Mouse{  //새로운 마우스
	//M705의 click()과 동일한 기능이지만, 제품이 달라서 사용법이 다르다.
	@Override
	public void click() {
		System.out.println("클릭!!");
	}
}

