package com.test.question;
import java.io.*;

public class Q120 {
	public static void main(String[] args) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\leeje\\OneDrive\\바탕 화면\\학원\\과제 문제\\파일_입출력_문제\\이름수정.dat")); //수정 전 모습의 파일
			BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\leeje\\OneDrive\\바탕 화면\\학원\\과제 문제\\파일_입출력_문제\\이름수정_변환.dat")); //수정 후 모습의 파일

			String line=null;
			while((line=reader.readLine()) != null){   //null이 아니면 반복문으로 -> 읽다가 더 읽을게 없으면 null을 반환.
				line=line.replace("유재석","메뚜기");
				writer.write(line);
			}
			System.out.println("변환 후 다른 이름으로 저장하였습니다.");
			reader.close();
			writer.close();
		}catch(Exception e) {
			System.out.println("at Q120.java");
			e.printStackTrace();
		}
		
	}
}
