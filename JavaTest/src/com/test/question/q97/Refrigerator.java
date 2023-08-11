package com.test.question.q97;

class Refrigerator {
	   private Item[] list = new Item[100];
	   private int index=0;

	   public void add(Item item) {  //마카롱이랑 다른 이유는 인자가 있느냐 없느냐의 차이.
		   list[index]=item;
		   index++;  //냉장고에 넣은 아이템의 개수
		   System.out.printf("'%s'를 냉장고에 넣었습니다.\n",item.getName());
	   }
	   public Item get(String name) {  //아이템 냉장고에서 꺼내기
		  Item item=null; // null 초기화
		  int j=-1;  //list의 i값을 저장해줄 변수. 0이면 배열 첫번째 방을 가리키므로 -1로 초기화.
		  for(int i=0; i<index; i++) { //아이템 꺼내기
			  if(list[i].getName().equals(name)) {  //이름 같은게 있으면
					   item=list[i];  //null인 item에 넣어주기
					   j=i;
					   this.index--;  // 총 아이템 개수에서 하나빼주기
			  } 
		  }
		  if(item!=null) {
			  for(int i=j; i<list.length-1; i++) {
				  list[i]=list[i+1];
			  }
			  list[list.length-1]=null;  //list의 마지막 방은 null로 초기화.
		  }
		  return item;
	   }
	   public int count() {  //냉장고 안의 총 아이템 개수
		   return this.index;  //
	   }
	   public void listItem() {    //냉장고 아이템 목록
		   System.out.println("냉장고 아이템 목록");
		   for(int i=0; i<index; i++) {
			   System.out.printf("%s(%s)\n",list[i].getName(), list[i].getExpiration());
		   }
	   }	   
}