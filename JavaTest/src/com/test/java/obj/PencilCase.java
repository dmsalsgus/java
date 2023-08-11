package com.test.java.obj;
import java.util.*;

public class PencilCase {  //Ex41_Class
	private String color;
	private Pencil[] pencil=new Pencil[5];  //연필을 최대 5개까지 담을 수 있는.
	private int index=0;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	/*
	public Pencil[] getPencil() {
		return pencil;
	}
	public void setPencil(Pencil[] pencil) {
		this.pencil = pencil;
	}
	*/
	
	//연필을 필통안에 넣는 메소드
	public void add(Pencil p) {
		if(this.index<this.pencil.length) {
			this.pencil[this.index]=p;
			this.index++;
		}else System.out.println("필통에 연필이 꽉 찼습니다.");

	}
	
	public Pencil get(int index) {  //연필꺼내기  //main보면 get(2) == index=2
		Pencil p=this.pencil[index];  //p에 2번째 연필넣기
		
		//Left Shift : 관리를 편하게 하기 위해
		for(int i=index; i<this.pencil.length-1; i++) {  //2번째 연필빼면 한칸씩 앞으로 땡겨주기
			this.pencil[i]=this.pencil[i+1];
		}
		this.pencil[this.pencil.length-1]=null;  //마지막 공간을 null로 초기화하기. 연필 넣기 쉽게.
		this.index--;  //총 연필 5개에서 1개 빼주기.
		
		return p;   //p 빼기
	}
	public String info() {
		return Arrays.toString(this.pencil);
	}
	
}
