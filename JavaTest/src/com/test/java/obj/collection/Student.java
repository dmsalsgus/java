package com.test.java.obj.collection;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	//private int total;
	//private double avg; -> 이 두개는 위의 값들을 이용해서 만들 수 있기 때문에 굳이 만들지 않음.
	
	public Student(String name, int kor, int eng, int math) {  //생성자
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	//setter는 필요 없고, getter는 읽어야하니까 생성하기.
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	@Override
	public String toString() {
		return String.format("Student [name=%s, kor=%s, eng=%s, math=%s]", name, kor, eng, math);
	}
	
}
