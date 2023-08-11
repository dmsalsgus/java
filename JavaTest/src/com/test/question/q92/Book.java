package com.test.question.q92;

class Book {
	private String title;  //제목
	private int price;  //가격
	private String author;  //저자
	private String publisher;  //출판사
	private String pubYear = "2019";  //발행년도
	private String isbn;   //ISBN
	private int page;  //페이지 수

	// getter, setter 설정하기
	
	//제목
	public String getTitle() {  //보여주기, 읽기
		return title;
	}
	public void setTitle(String title) {  //쓰기, 값 넣어주기
		if(title.length()>50) return;
		
		for(int i=0; i<title.length(); i++) {
			char c =title.charAt(i);
			if((c<'가'||c>'힣')&&(c<'A'||c>'Z')&&(c<'a'||c>'z')&&(c<'0'||c>'9')&&c!=' ') return;
		}
		this.title=title;
		
	}
	// 가격
	public int getPrice() {  //읽기
		return price;
	}
	public void setPrice(int price) {  //쓰기
		if(price>=0&&price<=1000000) this.price=price;
		else return;
	}
	// 작가
	public String getAuthor() {  //읽기에는 매개변수 필요없음.
		return author;
	}
	public void setAuthor(String author) {  //쓰기
		this.author=author;
	}
	// 페이지 수
	public int getPage() {  //읽기
		return page;
	}
	public void setPage(int page) {  //쓰기
		if(page>0) this.page=page;
		else return;
	}
	// 출판사
	public void setPublisher(String publisher) {  //쓰기
		this.publisher=publisher;
	}
	// 발행년도
	public String getPubYear() {  //읽기
		return pubYear;
	}
	// ISBN
	public String getIsbn() {  //읽기에는 매개변수 필요없음.
		return isbn;
	}
	public void setIsbn(String isbn) {  //쓰기
		this.isbn=isbn;
	}
	// 전체 정보 출력
	public String info() {
		return String.format("제목 : %s\r\n"+"가격 : %,d원\r\n"+"저자 : %s\r\n"+"출판사 : %s\r\n"+"발행년도 : %s년\r\n"+"ISBN : %s\r\n"+"페이지 : %,d장",
				this.title,this.price,this.author,this.publisher,
				this.pubYear,this.isbn,this.page);
		
	}
}