package com.test.java.obj;

public class Ex36_Class {
	public static void main(String[] args) {
		//언어의 성향
		//1. 절차 지향 프로그래밍
		//2. 함수 지향 프로그래밍
		//3. 객체 지향 프로그래밍
		
		//자바 : 객체 지향 프로그래밍 언어, Object Oriented Programming(=OOP)
		//객체를 선호하는 프로그래밍 방식의 언어
		
		// 클래스 Class
		
		//1. 객체, Object : 사전적인 정의로 실제 존재하는 것을 말한다. 
		//                    : 객체지향 이론에서는 사물과 같은 유형적인 것뿐만 아니라, 개념이나 논리와 같은 무형적인 것들도 객체로 간주한다.
		//                    : 객체 = 데이터와 행동의 집합 ex) 리모컨 = 데이터(색상, 무게, 크기 등등) + 행동(전원 온오프, 배터리 넣기 등등)
		//                                                          ex) 홍길동 = 데이터(머리 색상, 키, 몸무게 등) + 행동(먹는다, 말한다, 잔다, 달린다 등등)
		
		//2. 클래스, Class : 객체를 분류하는 단위, 객체를 생성하는 단위  
		//                    : ex) 붕어빵, 붕어빵틀 -> a. 붕어빵 틀을 만든다 (a를 클래스라고 한다.). / b. a를 사용해서 붕어빵을 만든다. (만들어진 붕어빵을 객체라고 한다.)/ c. 붕어빵을 먹는다.
		//                    : ex) 핸드폰 -> a. 설계도를 만든다.(핸드폰 틀을 만든다.) / b. a를 사용해서 핸드폰을 만든다. / c. 핸드폰을 사용한다.
		
		//3. 인스턴스, Instance : (==객체). 객체==인스턴스 / 객체!=인스턴스 => 같다고 보는 사람도 있고, 아닌 사람도 있다.
		//                           : 메모리에 실체화된 객체
		
		//4. 캡슐화, 정보은닉 : 객체의 내부를 외부로부터 보호하기 위한 장치
		
		//5. 인터페이스 : 캡슐화된 내부와 외부간의 최소한의 연결이 가능한 통로 역할 ex) 게임 인터페이스
		
		//6. 프로퍼티, Property : 객체가 가지는 정보(데이터)
		
		//7. 행동 : 객체가 가지는 행동
		
		//8. 상속 : 부모가 가지는 재산을 자식이 물려받는 행동
		//추천 책 : 토끼 모양의 '객체지향의 사실과 오해'
		
		
		
		
		//Q. 지도를 만드는 중에, 우리집의 좌표를 저장하고 싶다.
		//Case 1. 가장 간단한 방법이지만 식별자 문제가 있다. : 같은 성질의 식별자가 서로 다른 이름을 사용하고 있다.
		//                                                                  : x, y와 같은 한쌍의 집합을 물리적으로 관리가 불가능하다.
		//                                                                  : 구조도 없고, 규칙도 애매하고, 조작이 불편하다.
		// 우리집 좌표
		int x=100, y=200;
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n",x,y);
		//마트 좌표
		int x2=300, y2=400;
		System.out.printf("마트는 [%d, %d]에 위치합니다.\n",x2,y2);
		
		
		
		
		//Case 2.
		//배열 사용 : 데이터 저장 구조를 생성해서 그룹화시킴, 관리가 편하다.
		//             : 요소간의 성질을 구분하기 힘들다.(a1[0]==x좌표, a1[1]==y좌표라는 것이 헷갈림.)
		//             : 몇번째 방에 어떤 데이터를 넣었는지가 구분하기 힘들다.
		//우리집 좌표
		int[] a1= {100, 200};
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n",a1[0],a1[1]);
		//마트 좌표
		int[] a2= {300,400};
		System.out.printf("마트는 [%d, %d]에 위치합니다.\n",a2[0],a2[1]);
		
		
		
		
		//Case 3.
		//클래스 사용 : 데이터 집합의 역할을 한다.
		//                : 데이터 저장 구조를 생성해서 관리가 수월하다.
		//                : 같은 클래스의 객체이면, 멤버 이름이 동일하다. -> 데이터의 의미가 명확하다.
		//                : 멤버 변수의 이름이 존재하므로, 배열과 달리 멤버의 의미가 명확하다.
		//                : 클래스 선언하는데 고가비용이 든다.-> 개발자 할일 증가. 
		 //클래스명 변수명 = new 생성자();
		Point p1=new Point(); //객체 생성
		//new를 사용하는 애들은 heap을 사용한다.(stack 사용안함.)
		//우리집 좌표
		p1.x=100;
		p1.y=200;
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n",p1.x,p1.y);
		//마트 좌표
		Point p2=new Point();
		p2.x=300;
		p2.y=400;
		System.out.printf("마트는 [%d, %d]에 위치합니다.\n",p2.x,p2.y);
		
		
		
		
		//Q. 어떤 물건의 너비와 높이를 저장하고, 물건의 이름을 출력.
		Size s1=new Size();
		s1.name="모니터";
		s1.width=100;
		s1.height=150;
		
		System.out.println(s1.name);
		System.out.println(s1.width);
		System.out.println(s1.height);
		
		
		
		
		//Q. 이름, 국어, 영어, 수학 점수의 집합
		Score hong=new Score();
		hong.name="홍길동";
		hong.kor=100;
		hong.eng=90;
		hong.math=80;
		
		
		//이클립스에도 확장 프로그램이 있다.
		//Objectaid : UML 확장 프로그램.
		//- Class Diagram
		
		//UML(Unified Modeling Language) : 프로그램의 설계도를 만드는 언어.
		// 수많은 종류의 설계도가 있는데, 대표적인 것이 Class Diagram, Package Diagram, Object Diagram, Component Diagram, Sequence Diagram, UseCase Diagram, Activity, State 등등
		
	}
}
class Score{
	public String name;
	public int kor;
	public int eng;
	public int math;
	
}
class Size{
	public String name;
	public int width;
	public int height;
}
//클래스 선언. 클래스명은 파스칼표기법으로.
class Point{  //붕어빵 틀
	//클래스 내부에서는 클래스 멤버를 선언해야한다. -> 변수 or 메소드를 선언.
	
	//클래스 멤버 변수
	public int x;
	public int y;
	
}
