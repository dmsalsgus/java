package com.test.java.obj;

public class Person {    //Ex40_Class
	private String name;
	private int age;
	private String gender;
	
	private Person father;  //아빠
	private Person mother;  //엄마
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Person getFather() {
		return father;
	}
	public void setFather(Person father) {
		this.father = father;
	}
	public Person getMother() {
		return mother;
	}
	public void setMother(Person mother) {
		this.mother = mother;
	}
	
	public String info() {
		String temp="";
		
		temp+="아빠 : "+this.father.getName()+"\n";
		temp+="엄마 : "+this.mother.getName()+"\n";
		temp+="본인 : "+this.getName()+"\n";
		
		return temp;
	}
	
}
