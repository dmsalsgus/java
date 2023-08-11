package com.test.java.obj.inheritance;
import java.util.*;

public class Ex57_Generic {
	public static void main(String[] args) {
		//클래스 종류
		//1. 기본 클래스
		//2. 인터페이스
		//3. 추상클래스
		//4. enum
		//5. 제네릭 클래스
		
		//제네릭 클래스
		
		//Q. 클래스 설계해줘. 조건-> int 멤버 변수 선언, 멤버 변수를 중심으로 여러가지 행동을 하는 메소드 선언. 
		
		//전용 클래스
		WrapperInt n1=new WrapperInt(100);
		System.out.println(n1.toString());
		System.out.println(n1.getData()*2);
		System.out.println();
		
		//범용클래스 / Object 클래스 -> 바로 연산 불가능. 
		WrapperObject n2=new WrapperObject(200);
		System.out.println(n2.toString());
		System.out.println((int)n2.getData()*2);
		System.out.println();
		
		// 전용클래스+범용클래스 = 제네릭 클래스 -> 바로 연산 가능. & 중복사용 가능.
		Wrapper<Integer> n3=new Wrapper<Integer>(300);
		System.out.println(n3.toString());
		System.out.println(n3.getData()*2);
		System.out.println();
		/////////////////////////////////////////////////////////////////////////////////
		
		//추가 : String을 중심으로 하는 클래스도 설계해줘.(나머지 업무는 동일)
		WrapperString s1=new WrapperString("홍길동");
		System.out.println(s1.toString());
		System.out.println(s1.getData().length());
		System.out.println();
		
		//Object 변수
		WrapperObject s2=new WrapperObject("아무개");
		System.out.println(s1.toString());
		System.out.println(((String)s1.getData()).length());    //괄호를 잘 표시해줘야 한다. 형변환 괄호 먼저 감싸주고, 그다음 길이.
		System.out.println();
		
		//
		Wrapper<String> s3=new Wrapper<String>("이순신");
		System.out.println(s3.toString());
		System.out.println(s3.getData().length());
		System.out.println();
		///////////////////////////////////////////////////////////////////////////////////
		
		//추가 : boolean을 중심으로 하는 클래스도 설계해줘.(나머지 업무는 동일)
		WrapperBoolean b1=new WrapperBoolean(true);
		System.out.println(b1.toString());
		System.out.println(b1.getData()?"참":"거짓");
		System.out.println();
	
		//
		WrapperObject b2=new WrapperObject(false);
		System.out.println(b2.toString());
		System.out.println((boolean)b2.getData()?"참":"거짓");
		System.out.println();
		
		//
		Wrapper<Boolean> b3=new Wrapper<Boolean>(true);
		System.out.println(b3.toString());
		System.out.println(b3.getData()?"참":"거짓");
		System.out.println();
		//////////////////////////////////////////////////////////////////////////////////////////
		
		
		//추가 : byte을 중심으로 하는 클래스도 설계해줘.(나머지 업무는 동일)
		//추가 : Calendar을 중심으로 하는 클래스도 설계해줘.(나머지 업무는 동일)
		//추가 : Student을 중심으로 하는 클래스도 설계해줘.(나머지 업무는 동일)
		//계속 무한대 추가.....
	
		
		//위의 문제점을 해결하는 방법 1. Object 클래스 : 오래전부터 현재까지 사용하는 방식
		//                                     2. 제네릭 클래스 : 최신부터 현재까지 사용하는 방식
		
		
		//***절대적으로 값형과 참조형간에 형변환 불가능하다!!!
		//Object 변수는 만능주머니! ==> 모든 자료형을 담을 수 있는 변수! -> 왜? 루트라서.
		Object o1= new Object();
		Object o2=new Hong();  //업캐스팅
		Object o3=new Scanner(System.in);  //업캐스팅
		Object o4=new WrapperInt(100);  //업캐스팅
		Object o5="홍길동";
		//-----------------------------------//위는 참조형, 아래는 값형.
		//근데 이건 왜 가능? -> 'Boxing'이라는 현상때문에(오토박싱)
		Object o6=10;  //= new Integer(10);  //정수 10을 주소값으로 정하고, 그 주소값을 넘겨준거임.
		Object o7=true;
		
		//단점은..System.out.println(o6*2); 과 같은 연산은 실행안됨.
		//-> 데이터가 아닌 주소값이라서 연산의 대상이 될 수 없다.
		System.out.println((Integer)o6*2);  //다운캐스팅  //-> System.out.println((int)o6*2); 도 같다.  //==> 언박싱(Unboxing).
		//다운캐스팅하면 가능해짐.
		Integer num=new Integer(10);  //작대기는 나중에 사라질 것이라고 표시한거임. 무시ㅇㅇ.
		System.out.println(num);
		System.out.println(num+1);
		
		((Scanner)o3).nextLine();  //다운캐스팅
		
		//Object의 단점은 꺼낼 때 다운캐스팅을 해야해서 매우 귀찮다.
		
		
	}
}
class WrapperInt{
	private int data;   //클래스의 중심이 되는 멤버 변수 선언.
	
	//데이터 중심의 행동을 만들기
	public WrapperInt(int data) {  //생성자
		this.data=data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return String.format("[data=%s]", data);
	}
	
}
class WrapperString{
	private String data;   //클래스의 중심이 되는 멤버 변수 선언.
	
	//데이터 중심의 행동을 만들기
	public WrapperString(String data) {  //생성자
		this.setData(data);
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return String.format("[data=%s]", data);
	}
	
}
class WrapperBoolean{
	private boolean data;   //클래스의 중심이 되는 멤버 변수 선언.
	
	//데이터 중심의 행동을 만들기
	public WrapperBoolean(boolean data) {  //생성자
		this.setData(data);
	}
	public boolean getData() {
		return data;
	}
	public void setData(boolean data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return String.format("[data=%s]", data);
	}
	
}
class WrapperObject{
	private Object data;
	
	public WrapperObject(Object data) {  //생성자
		this.setData(data);
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
class Wrapper<T>{
	private T data;    //클래스 설계시에는 무슨 타입인지 알수없음.
	
	public Wrapper(T data) {    //생성자에는 <T> 안붙임.
		this.data=data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return String.format("Wrapper [data=%s]", data);
	}
	
}


