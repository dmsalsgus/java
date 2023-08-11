package com.test.java.obj.cast;

public class Ex56_Casting {
	public static void main(String[] args) {
		//Q. 'LG500', 'HP600'이라는 프린터 기기를 만들자
		/*
		LG500 lg=new LG500();
		HP600 hp=new HP600();
		
		//용도는 같지만 사용법이 다름.
		lg.on();
		hp.powerOn();

		lg.print();
		hp.printing();
		
		lg.off();
		hp.powerOff();
		//
		*/
		
		LG500 lg=new LG500();
		HP600 hp= new HP600();
		
		lg.powerOn();
		hp.powerOn();
		
		lg.print();
		hp.print();
		
		lg.powerOff();
		hp.powerOff();
		
		//////////////////////////////
		
		Printer p1;
		LG500 lg2=new LG500();
		
		//Printer=LG500 / 업캐스팅
		p1=lg2;
		
		Printer p2=new HP600();  //-> Printer p2=(Printer)new HP600();
		//굳이 복사하는 이유는 유지보수를 편하게 하기위해.
		//p2. 으로 코드를 짜고, hp냐 lg냐 이것만 바꿔주면 됨.
		//만약 HP600에만 있는 메소드를 쓰고 싶다면 -> ((HP600)p2).clean(); 이런식으로 사용.
		
		//Object o1=new LG500(); -> 이렇게도 가능.
		//////////////////////////////////////////////////////////////////////////////////
		//Q. 프린터를 판매하는 대리점을 운영한다. 재고는 lg제품 5대, hp제품은 3대를 보유중.
		//    매일 하는 업무가 있는데, 프린터가 제대로 동작하는지 확인한다. 
		
		//1. 첫번째 방법 : 제일 무식한 방법...
		//추가로 lg가 500대, hp가 300대이면...;
		//m1();
		
		//2. 두번쨰 방법 : 배열
		//추가상황->새로운 제품이 입고됨.(BenQ700, Epson800)
		//그러면 새로 들어온 제품 수만큼 추가 배열을 만들어야함..
		//m2();
		
		//3. 세번째 방법 : 형변환을 이용한 방법
		//추가업무 : LG프린터는 selfTest도 점검하고, HP는 clean이라는 동작을 잘 하는지 확인.
		m3();
		
		
		
	}
	private static void m3() {
		Printer[] ps=new Printer[8];  //프린터라는 타입의 변수를 넣을 수 있는 변수를 만든것.
		
		//***서로 다른 클래스의 객체를 하나의 배열에 넣었다!!!!!
		//ps[0]=new LG500();  //업캐스팅
		//ps[1]=new HP600();  //업캐스팅
		
		//재고 확보
		for(int i=0; i<ps.length; i++) { 
			if(i<5) ps[i]=new LG500();
			else ps[i]=new HP600();
		}
		
		//업무
		for(int i=0; i<ps.length; i++) {
			ps[i].print();
			/*
			if(i<5) ((LG500)ps[i]).selfTest();  //다운캐스팅
			else ((HP600)ps[i]).clean();
			*/
			//▼
			System.out.println(ps[i] instanceof LG500);  //true 또는 false로.
			if(ps[i] instanceof LG500) ((LG500)ps[i]).selfTest();  //다운캐스팅
			else if(ps[i] instanceof HP600) ((HP600)ps[i]).clean();
			
		}
	}
	
	private static void m2() {
		//재고 확보
		LG500[] lg=new LG500[5];
		for(int i=0; i<lg.length; i++) {
			lg[i]=new LG500();
		}
		HP600[] hp=new HP600[3];
		for(int i=0; i<hp.length; i++) {
			hp[i]=new HP600();
		}
		
		//업무
		for(int i=0; i<lg.length; i++) {
			lg[i].print();
		}
		for(int i=0; i<hp.length; i++) {
			hp[i].print();
		}
	}
	
	private static void m1() {
		LG500 lg1=new LG500();
		LG500 lg2=new LG500();
		LG500 lg3=new LG500();
		LG500 lg4=new LG500();
		LG500 lg5=new LG500();
		
		HP600 hp1=new HP600();
		HP600 hp2=new HP600();
		HP600 hp3=new HP600();
		
		lg1.print();
		lg2.print();
		lg3.print();
		lg4.print();
		lg5.print();
		
		hp1.print();
		hp2.print();
		hp3.print();
		
	}
}
interface Printer{  //프린터기들의 공통행동들을 여기에 정의하자.
	//인터페이스는 변수는 만들지만 객체는 못만듬.
	void print();
	void powerOn();
	void powerOff();
	//이정도만 해줘도 엄청 깔끔해짐.
}
class LG500 implements Printer{
	private String type;
	private int price;
	/*
	public void print() {
		System.out.printf("%s 방식으로 출력합니다.\n",this.type);
	}
	public void on() {
		System.out.println("프린터 전원을 켭니다.");
	}
	public void off() {
		System.out.println("프린터 전원을 끕니다.");
	}
	*/
	@Override
	public void print() {
		System.out.printf("%s 방식으로 출력합니다.\n",this.type);
	}
	@Override
	public void powerOn() {
		System.out.println("프린터 전원을 켭니다.");
	}
	@Override
	public void powerOff() {
		System.out.println("프린터 전원을 끕니다.");
	}
	public void selfTest() {
		System.out.println("자가 점검을 합니다.");
	}
}
class HP600 implements Printer{
	private String color;
	private int price;
	/*
	public void printing() {
		System.out.println("출력합니다.");
	}
	public void powerOn() {
		System.out.println("전원 켜짐");
	}
	public void powerOff() {
		System.out.println("전원 꺼짐");
	}
	*/
	@Override
	public void print() {
		System.out.println("출력합니다.");
	}
	@Override
	public void powerOn() {
		System.out.println("전원 켜짐");
	}
	@Override
	public void powerOff() {
		System.out.println("전원 꺼짐");
	}
	public void clean() {
		System.out.println("헤더를 청소합니다.");
	}
}

