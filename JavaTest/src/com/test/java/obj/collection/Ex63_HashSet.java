package com.test.java.obj.collection;
import java.util.*;

public class Ex63_HashSet {
	public static void main(String[] args) {
		//List : 순서가 있는 데이터 집합, 첨자로 방번호를 구분하므로 데이터 중복을 허용
		//Map : 순서가 없는 데이터 집합, 키+값으로 구분하므로 데이터 중복을 허용.
		
		//Set : 순서가 없는 데이터 집합, 요소를 구분하는 식별자 자체가 없다. -> 데이터 중복을 허용하지 않는다.
		
		//m1();
		//m2();
		m3();
		
		
	}

	private static void m3() {
		HashSet<String> name = new HashSet<String>();
		name.add("홍길동");
		name.add("홍길동");   //얘는 같은 사람이라고 나옴. -> 문자열은 데이터 vs 데이터로 생각한다.
		System.out.println(name);
		System.out.println();
		
		HashSet<Person> set = new HashSet<Person>();
		
		set.add(new Person("홍길동",20));
		set.add(new Person("아무개",25));
		set.add(new Person("이순신",23));
		
		set.add(new Person("홍길동",20));  //새로 추가.
		// 중복값 배제가 아닌 동명이인으로 본다.
		///new로 새로운 사람을 만들었고, 주소값 비교로 동명이인이라고 판단함.
		
		System.out.println(set);
		System.out.println();
		
		
		//p1과 p2를 같은 사람이라고 인식하도록 수정하기.
		Person p1=new Person("홍길동",20);
		Person p2=new Person("홍길동",20);
		
		System.out.println(p1.equals(p2));  ////false.  p1과 p2의 주소값은 다르니까.
		System.out.println("p1 : "+p1.hashCode());   //p1 : 589446616
		System.out.println("p2 : "+p2.hashCode());   //p2 : 1321640594
		
		
		String s1="홍길동";
		String s2="홍길동";
		String s3="홍";
		s3=s3+"길동";
		
		System.out.println(s1.equals(s2));   //주소값 비교
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3));
		
		System.out.println(s1.hashCode());    //54150062
		System.out.println(s1.hashCode());   //54150062
		
	}

	private static void m2() {
		//중복값을 제거한 로또번호->중복되지 않는 난수 생성하기
		
		//Case 1. ArrayList
		ArrayList<Integer> lotto =new ArrayList<Integer>();
		/*
		for(int i=0; i<6; i++) {
			int n=(int)(Math.random()*45)+1;
			boolean flag=false;
			for(int j=0; j<i; j++) {
				if(lotto.get(j)==n) {
					flag=true;   //true이면 중복값.
					break;
				}else i--;
			}
			if(!flag) {
				lotto.add(n);
			}else i--;
		}
		System.out.println(lotto);
		*/
		
		//Case 2. HashSet
		HashSet<Integer> lotto2 = new HashSet<Integer>();
		
		while(lotto2.size()<6) {
			int n=(int)(Math.random()*45)+1;
			lotto2.add(n);   //애초에 set이라서 중복값을 넣을 수 없음.
		}
		System.out.println(lotto2);
		
		
		//set의 탐색
		for(int num : lotto2) {  //향상된 for문은 내부에 iterator 구현이 되어있다.
			System.out.println(num);
		}
		
		//**********list, set도 지원가능
		Iterator<Integer> iter = lotto2.iterator();
		///iterator는 탐색 도구이다.
		
		while(iter.hasNext()) {         ///개별 호출은 불가능. 전부 다 호출만 가능.
			System.out.println(iter.next());	
		}
		
		/*
		System.out.println(iter.hasNext());   //요소의 존재 유무를 반환.
		System.out.println(iter.next());      //요소를 가져오기.
		
		System.out.println(iter.hasNext());   //요소의 존재 유무를 반환.
		System.out.println(iter.next());      //요소를 가져오기.
		
		System.out.println(iter.hasNext());   //요소의 존재 유무를 반환.
		System.out.println(iter.next());      //요소를 가져오기.
		
		System.out.println(iter.hasNext());   //요소의 존재 유무를 반환.
		System.out.println(iter.next());      //요소를 가져오기.
		
		System.out.println(iter.hasNext());   //요소의 존재 유무를 반환.
		System.out.println(iter.next());      //요소를 가져오기.
		
		System.out.println(iter.hasNext());   //요소의 존재 유무를 반환.
		System.out.println(iter.next());      //요소를 가져오기.
		
		System.out.println(iter.hasNext());   //false를 반환.
		System.out.println(iter.next());      //요소를 가져오기.
		//마지막에 없는 데이터를 부르면 에러남.
		*/
		
	}

	private static void m1() {
		ArrayList<String> list =new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		
		list.add("강아지");
		list.add("고양이");
		list.add("거북이");
		
		set.add("강아지");
		set.add("고양이");
		set.add("거북이");
		//[고양이, 거북이, 강아지]
		//set은 순서가 없는 데이터 집합이므로 순서가 뒤죽박죽인게 정상임.
		
		System.out.println(list.size());
		System.out.println(set.size());
		
		System.out.println(list);
		System.out.println(set);
		
		list.add("고양이");   //중복 -> 구분 가능
		System.out.println(list);
		
		System.out.println(set.add("고양이"));  //출력하면 false를 반환.
		System.out.println(set);  // 방번호 없어서 구분이 불가능하므로 중복값을 가질 수 없다.
		
		list.remove(1);
		list.remove("거북이");
		System.out.println(list);
		
		set.remove("거북이");
		System.out.println(set);
		
		System.out.println(set.contains("고양이"));  //true를 반환.
		
	}
}
class Person{
	private String name;
	private int age;
	
	
	public Person(String name, int age) {
		this.age=age;
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return String.format("Person [name=%s, age=%s]\n", name, age);
	}	
	
	//값이 동일하면 객체가 동일하게 처리
	//1. hashCode()를 오버라이드 하거나
	@Override
	public int hashCode() {
		//원래는 자신의 메모리 주소값을 반환한다.
		//p1은 "홍길동", 20을 하나의 문자열로 -> "홍길동20" -> 100번지
		//p2은 "아무개", 25을 하나의 문자열로 -> "아무개25"  -> 200번지
		//p3은 "홍길동", 20을 하나의 문자열로 -> "홍길동20"  -> 100번지
		
		return (this.name+this.age).hashCode();  //--> 문자열을 합쳐서 하나의 동일한 상태로 재정의. 
	}
	
	//2. equals()를 오버라이드 하거나
	@Override
	public boolean equals(Object obj) {
		// p1.equals(p2)
		return this.hashCode()==obj.hashCode();   //--> 주소값 비교가 아닌 내부 멤버  변수 비교로 바뀜.
	}
	//근데 보통 1, 2번 둘 다 오버라이딩을 같이 한다.
}