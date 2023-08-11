package com.test.question;
import java.io.*;
import java.util.*;

public class Q124 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String address = "";
		String num = "";
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		try {
			BufferedReader member = new BufferedReader(new FileReader("C:\\Users\\leeje\\OneDrive\\바탕 화면\\학원\\과제 문제\\파일_입출력_문제\\검색_회원.dat"));
			BufferedReader order = new BufferedReader(new FileReader("C:\\Users\\leeje\\OneDrive\\바탕 화면\\학원\\과제 문제\\파일_입출력_문제\\검색_주문.dat"));
			
			String line = null;
			
			while((line = member.readLine()) != null) {
				if (line.contains(name)) {
					String[] temp = line.split(",");
					
					num = temp[0];
					address = temp[2];
					
					break;
				}
				
			}
			
			System.out.println("==== 구매내역 ====");
			System.out.println("[번호]\t[이름]\t[상품명]\t[개수]\t[배송지]");
			
			while((line = order.readLine()) != null) {
				String[] temp = line.split(",");
				
				if(temp[3].equals(num)) {
					System.out.printf("%4s\t%4s\t%4s\t%4s\t%4s", num, name, temp[1], temp[2], address);
					
				}
			}
			
			order.close();
			member.close();
			scan.close();
		} 
		catch (Exception e) {
			System.out.println("at Q124.main");
			e.printStackTrace();
		}
		
	}
	
}