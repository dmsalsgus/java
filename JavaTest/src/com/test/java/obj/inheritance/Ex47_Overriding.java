package com.test.java.obj.inheritance;

public class Ex47_Overriding {
	public static void main(String[] args) {
		//메소드 오버로딩(Method Overloading) : 메소드 이름을 동일하게 만들어서 여러 개가 생성가능한 것(단, 인자에 변화를 줘야한다.)
		
		//메소드 오버라이딩(Method Overriding) : 클래스 상속 시에 발생하며, 메소드를 재정의할 때 사용(상속받은 메소드를 수정하는(덮어쓰는) 기술).
		
		OverrideParent hong = new OverrideParent();
		hong.name="홍길동";
		hong.hello();
		
		OverrideChild jhong = new OverrideChild();
		jhong.name="홍철수";
		jhong.hello();
		//jhong.hi();
		
	}

}
//동네 사람
class OverrideParent{
	public String name;
	
	public void hello() {
		System.out.printf("안녕하세요. 좋은 아침입니다. 저는 %s입니다.\n",this.name);
	}
	
}
class OverrideChild extends OverrideParent{
	//시간이 흘러서 철수가 중2학년이 되고, 질풍노도의 시기로 아빠의 인사가 맘에 안듬. -> 자신만의 인사방식을 만들고 싶다.
	//=> 부모클래스가 물려준 hello()사용하기 싫음. -> 근데 상속은 물려준 멤버를 자식이 거부할 방법이 없음. -> 그럼 어떻게? -> 메소드를 새로 만들기
	/*  문법적으로는 상관은 없지만 헷갈리니까 이런 방식은 지양하기.
	public void hi() {
		System.out.printf("하이! 난 %s야\n",this.name);
	}
	*/
	//동일한 hello()를 2개 가지고 있지만 에러 안남. -> 자식 이기는 부모 없다ㅋㅋㅋㅋ
	//왜? 무조건 자식을 우선하기 때문에 자식의 hello()가 호출되는 것.
	//@Override
	public void hello() {  //메소드 재정의==메소드 오버라이딩
		System.out.printf("하이! 난 %s야\n",this.name);
	}
}

