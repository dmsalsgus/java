package com.test.java.obj.inheritance;

public class Ex53_interface {
	public static void main(String[] args) {
		
		MxKeys keyboard=new MxKeys();
		
		keyboard.powerOn();
		keyboard.keyDown('A');
		System.out.println(keyboard.checkBatter());
		keyboard.powerOn();
		
	}
}
interface keyboard{  //키보드는 객체를 생성할 수 없다. 실체화할 수 없다는 뜻. 대신 누군가의 부모가 되서 자식들에게 제시해줌.
	//이 안에는 키보드로서 갖춰야할 행동을 정의해야한다.(선언부는 있지만 구현부는 없는.) -> 이것이 호출 사용법.
	//인터페이스가 가지는 모든 추상메소드는 반드시 public. -> private은 감춰져있는 것인데 눈에 안보이면 행동은 무쓸모.
	// 그래서 public 생략 가능.
	
	void keyDown(char c);  
	void powerOn();
	void powerOff();
	int checkBatter();
	//static도 안됨.
	
}
class MxKeys implements keyboard{  //구현은 내맘대로~

	@Override
	public void keyDown(char c) {
		System.out.println(c+"눌렀음");
		
	}

	@Override
	public void powerOn() {
		System.out.println("전원 켜짐");
		
	}

	@Override
	public void powerOff() {
		System.out.println("전원 꺼짐");
		
	}

	@Override
	public int checkBatter() {
		return 80;  //배터리 80 남음.
	}
		
}
