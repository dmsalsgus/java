package com.test.question.q93;

class Note  {
	   private String size;
	   private String color;
	   private int page;
	   private String owner;
	   private int price=500; //기본가격  //기본 노트 : A5+흰색+10페이지

	   private String thickness;  //두꺼운지 얇은지 판단하는 변수
	   //setter, getter 구현
	   
	   //크기
	   public void setSize(String size) {  //쓰기
		   if(size.equals("A3")||size.equals("A4")||size.equals("A5")||size.equals("B3")||size.equals("B4")||size.equals("B5")) this.size=size;
		   
		   if(size.equals("A3")) {  //크기에 따른 가격을 바로바로 반영하기.
			   price+=400;
		   }else if(size.equals("A4")) {
			   price+=200;
		   }else if(size.equals("B3")) {
			   price+=500;
		   }else if(size.equals("B4")) {
			   price+=300;
		   }else if(size.equals("B5")) {
			   price+=100;
		   }
		   
	   }
	   //표지 색상
	   public void setColor(String color) {   //쓰기
		   if(color.equals("검정색")||color.equals("흰색")||color.equals("노란색")||color.equals("파란색")) this.color=color;
		   
		   if(color.equals("검은색")) {  //색상에 따른 가격을 바로바로 반영하기.
			   price+=100;
		   }else if(color.equals("노란색")||color.equals("파란색"))  price+=200;
		   
	   }
	   //페이지수 
	   public void setPage(int page) {  //쓰기
		   if(page<10||page>200) return;    //범위밖이면 stop
		   
		   if(page<=200&&page>=101) {
				this.thickness="두꺼운";
			}else if(page>=51) {
				this.thickness="보통";
			}else this.thickness="얇은";
			
			this.page=page;
		}
	   //소유자이름
	   public void setOwner(String owner) {
		   //유효성 검사는 잘못된 것을 찾아서 작성하는게 더 예쁜 코드
		   if(owner.length()<2||owner.length()>5) {   //글자수가 2~5이내가 아니면 stop
			   return;
		   }
		   for(int i=0; i<owner.length(); i++) {  //글자가 한글이 아니면 stop
			   char c=owner.charAt(i);
			   if(c<'가'||c>'힣') {
				   return;
			   }
		   }
		   this.owner=owner;
	   }
	   
	   public String info() {
		   String result="";
		   price+=(page-10)*10;
		   
		   if(this.owner==null) System.out.print("■■■■■■ 노트 정보 ■■■■■■"+"\n"+"주인없는 노트\n"+"■■■■■■■■■■■■■■■■■■■■■■");
		   //문자열은 null일 때는 if(owner != null) 연산자 사용 또는 빈 문자일때 if(owner.equals(" "))
		   else {
			   result+="■■■■■■ 노트 정보 ■■■■■■"+"\n"
					   +"소유자 : "+this.owner+"\n"
					   +"특성 : "+this.color+" "+this.thickness+" "+this.size+"노트\n"
					   +"가격 : "+String.format("%,d",this.price)+"원\n" //이렇게도 가능. format==printf
					   +"■■■■■■■■■■■■■■■■■■■■■■";
		   }
		   return result;
	   }
	}