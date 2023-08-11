package com.test.question.q94;

public class Main {
	public static void main(String[] args) {
		Bugles snack = new Bugles();

		snack.setSize(500);
		snack.setCreationTime("2023-07-27");
		System.out.println("가격 : " + snack.getPrice() + "원");
		System.out.println("유통 기한이 " + snack.getExpiration() + "일 남았습니다.");

		snack.eat();
		////////////////////////////
		Bugles snack2 = new Bugles();

		snack2.setSize(300);
		snack2.setCreationTime("2023-07-19");
		System.out.println("가격 : " + snack2.getPrice()+ "원");
		System.out.println("유통 기한이 " + snack2.getExpiration() + "일 남았습니다.");

		snack2.eat();
	}
}
