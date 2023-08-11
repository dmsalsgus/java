package com.test.java.obj;

public class Ex41_Class {
	public static void main(String[] args) {
		//연필과 필통 -> 하나의 클래스가 또 다른 클래스를 멤버로 받을 수 있다.
		
		PencilCase pcase = new PencilCase();
		pcase.setColor("파란색");
		/* 가독성이 떨어지는 안좋은 코드
		for(int i=0; i<5; i++) {  //집어넣은 것
			Pencil p1=new Pencil();
			p1.setHardness("HB");
			p1.setColor("검은색");
			
			//[index] : 인덱서(Indexer)라는 표기법
			pcase.getPencil()[i]=p1;  //필통이 연필 5개로 꽉 참.
		}
		
		for(int i=0; i<5; i++) {
			System.out.println(pcase.getPencil()[i].info());
		}
		*/
		
		for(int i=0; i<5; i++) {  
			Pencil p=new Pencil(); //Pencil클래스를 사용하기 위한 객체 생성.
			p.setHardness("B");
			p.setColor("파란색");
			
			pcase.add(p);  //연필 5개 만들어서 필통에 넣기
		}
		System.out.println(pcase.info());  //필통꽉찼는지 확인하기
		Pencil p2=pcase.get(2);
		
		//문자열 난수 만들기
		String[] color= {"red","blue","yellow","black"};  //방번호는 난수로 만들기 가능
		
		System.out.println(color[(int)(Math.random()*color.length)]);  //색상 난수만들기
		
		
		
		
		
	}
}
