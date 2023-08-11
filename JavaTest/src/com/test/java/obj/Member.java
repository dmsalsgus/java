package com.test.java.obj;

public class Member {
	private String id;
	private String pw;
	private String name;
	private int lv;
	
	public Member(String id, String pw, String name, int lv) {
		//super(); -> 상속 배우고 나서.
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.lv = lv;
	}

	//생성자 vs setter
	//1. 생성자 : 초기화 역할
	//2. setter  : 초기화 이후 수정하는 역할
	/*
	public Member(String id, String pw, String name, int lv) {  //setter는 안만듬
		//오버로딩
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.lv=lv;
	}
	*/
	
	public String info() {
		return String.format("아이디 : %s, 암호 : %s, 이름 : %s, 등급 : %d",this.id,this.pw,this.name,this.lv);
	}
	
	
	
	
	
	
}
