package com.test.question.q96;

class Box {
	private Macaron[] list = new Macaron[10];

	public void cook() {  //마카롱 만들기
		String[] color= {"red","blue","yellow","white","pink","purple","green","black"};  //가능한 생산 색상들
		
		   for(int i=0; i<list.length; i++) {
				Macaron m=new Macaron();   //마카롱 객체 생성하기
				
			   m.setSize((int)(Math.random()*11)+5);  //5~15크기 까지 크기 랜덤으로 생산. 5부터 15까지는 11개니까 시작이 5, 그리고 11개 보겠다.
				m.setColor(color[(int)(Math.random()*color.length)]);  //색상 랜덤으로 생산.
				m.setThickness((int)(Math.random()*20)+1);   //두께 랜덤 생산.
			   
			   this.list[i]=m;  //마카롱 10개 무작위 생산.
		   }
		   System.out.println("마카롱을 10개 만들었습니다.\n");
	   }

	public void check() {
		int pass=0, fail=0;
		
		for(int i=0; i<list.length; i++) {
			if(check(list[i])) pass++;
			else fail++;
		}
		System.out.println("[박스 체크 결과]");
		System.out.printf("QC 합격 개수 : %d\n",pass);
		System.out.printf("QC 불합격 개수 : %d\n\n",fail);
	}

	public void list() {
		System.out.println("[마카롱 목록]");
		for(int i=0; i<list.length; i++) {
			System.out.printf("%d번 마카롱 : %dcm(%s, %dmm) : %s\n",i+1, list[i].getSize(), list[i].getColor(), list[i].getThickness(),check(list[i])?"합격":"불합격");
		}
	}
	
	private boolean check(Macaron m) {
			if(m.getSize()<8||m.getSize()>14) return false;
			else if(m.getColor().equals("black")) return false;
			else if(m.getThickness()<3||m.getThickness()>18) return false;
			else return true;
	}
	
}
class Macaron {  //마카롱 정보
	private int size;
	private String color;
	private int thickness;

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getThickness() {
		return thickness;
	}
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
}