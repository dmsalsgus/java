package com.test.java.obj;

public class Ex44_static {
	public static void main(String[] args) {
		//static 키워드 : 클래스나 클래스 멤버에 붙일 수 있다. 지역변수에는 못 붙임.
		
		//1. 클래스 로딩(Class Loading) : 프로그램을 실행하기 전에 클래스의 정의를 미리 읽는 작업
		//                                      : 클래스의 정의를 메모리에 얹는 작업
		//                                      : 클래스 로딩 과정에서 모든 static 키워드 인식을 하고 메모리를 실체화한다.(구현)
		//                                      : stack과 heap영역이 아닌 static 영역(울타리가 있는데, 울타리 이름은 클래스 이름과 동일)에 따로 만들어진다.
		
		//2. main() 실행
		
		
		//Q. 학생 3명이 있고, 3명의 정보를 객체화 시킨다. 3명은 역삼 중학교를 다닌다.  // 객체는 heap 영역에만 생성 가능.
		//근데 개명해서 대치 중학교
		
		Students.setSchool("역삼중학교");  //공통된 데이터이므로 3번이나 사용할 필요없음. 
		//정적 변수(공용 데이터)
		
		Students s1=new Students();  //객체 생성.
		s1.setName("홍길동");  //객체 변수, 개인 데이터(나만 가지고 있는 데이터)
		s1.setAge(15);
		//s1.setSchool("역삼 중학교"); -> static 안붙였을 경우 이런식으로 사용
		//static을 붙이고 이렇게 쓰면 에러. static멤버를 객체 참조 변수를 통해서 접근하려고 시도하는 것은 불가능.
		
		Students s2=new Students();
		s2.setName("아무개");
		s2.setAge(15);
		//s2.setSchool("역삼 중학교");
		
		Students s3=new Students();
		s3.setName("이순신");
		s3.setAge(16);
		//s3.setSchool("역삼 중학교");
		
		System.out.println(s1.info());
		System.out.println(s2.info());
		System.out.println(s3.info());
		
		///////////////////////////////////////
		/*
		//객체 메소드를 사용하려면 객체를 생성해야 한다.
		Util util=new Util();
		
		int result=util.add(10,20);
		System.out.println(result);
		
		result=util.add(30,40);
		System.out.println(result);
		
		Util util2=new Util();
		
		result=util.add(50,60);
		System.out.println(result);
		///////////////////////위와 같은 경우 객체를 2개 생성한 것인데, 그럴필요가 없다. => 어차피 같은 행동을 하기 때문에.
		*/
		//Util 클래스에 static을 붙이면 밑에처럼 사용이 가능.
		//객체를 생성할 필요가 없음.
		int result=Util.add(10,20);
		System.out.println(result);
		
		result=Util.add(30,40);
		System.out.println(result);
		
	}
}
class Students{
	private String name;  //객체변수, 클래스 멤버변수
	private int age;  //객체 변수, 클래스 멤버변수
	//private String school;
	private static String school;  //정적 변수, 클래스 변수, 공용 변수
	
	//사람마다 다른 값을 가져야 한다면 객체 변수, 사람이 달라도 같은 값을 가져야 한다면 정적 변수.
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {  //자기 자신을 this라고 표현.
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	/*  static 안붙였을 때
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	*/
	//static 붙인 메소드
	public static String getSchool() {
		return school;
	}
	public static void setSchool(String school) {  //자기 자신을 class이름으로 표현.
		Students.school = school;
	}
	
	public String info(){
		return String.format("%s (%d) %s", this.name, this.age, Students.school);	
	}
	////////////////////////////////////////////
	public void aaa() {  //객체 메소드 => 객체, 정적 둘다 접근 가능.
		//개인과 관련된 작업(객체), 집합과 관련된 작업(정적) => 둘다 가능.
		System.out.println(this.name);         //객체 변수
		System.out.println(Students.school);  //정적 변수
		this.setAge(15);                           //객체 메소드
		Students.setSchool("역삼중학교");     //정적 메소드
	}
	public static void bbb() {  //정적 메소드 => this 접근 불가능, 객체 접근 불가능. / 자기영역에 있는 애들만 접근 가능.
		////개인과 관련된 작업(객체) => 불가능
		////집합과 관련된 작업(정적) => 가능.
		System.out.println(Students.school);  //정적 변수
		Students.setSchool("역삼중학교");     //정적 메소드
		//System.out.println(this.name);         //객체 변수
		//this.setAge(15);                           //객체 메소드
	}
	
}

class Util{  //객체 메소드
	public static int add(int a, int b) {
		return a+b;
	}
}

class Phone{
	//객체 멤버
	private String color;
	private String number;
	public int size;
	
	//정적 멤버
	private static int weight;
	public static int battery;
	
	public Phone() {  //기본 생성자 =>ctrl + space
		// TODO Auto-generated constructor stub
	}
	public Phone(String color, String number) {  //생성자 오버로딩
		
	}
	
	private String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public static int getWeight() {
		return weight;
	}
	public static void setWeight(int weight) {
		Phone.weight = weight;
	}
	public static int getBattery() {
		return battery;
	}
	public static void setBattery(int battery) {
		Phone.battery = battery;
	}
	
}

