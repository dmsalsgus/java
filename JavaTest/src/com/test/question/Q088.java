package com.test.question;
import java.util.*;

public class Q088 {  //금지어를 마스킹 처리 하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		String line=sc.nextLine();
		String[] taboo_word= {"바보","멍청이"};   //word[0]="바보", word[1]=멍청이;
		int cnt=0;
		
		for(int i=0; i<taboo_word.length; i++) {	//taboo_word.length==2
				String mask = "";
				for (int j=0; j<taboo_word[i].length(); j++) {  //taboo_word[0].length() ==2 / taboo_word[1].length()==3
					mask += "*";
				}
				line=line.replace(taboo_word[i], mask );  //금지어가 있으면 mask값으로 변경.
				
				String temp = line.replace("*", "");  //temp는 *을 제거한 문장.
				
				cnt+=(line.length() - temp.length()) / mask.length();  // 원래문장 - *제거한 문장 =2인데, mask길이만큼 나눠주면 그게 cnt값이랑 동일.
		}	
		System.out.println(line);  //마스킹 한 문장.
		System.out.printf("금지어를 %d회 마스킹했습니다.\n",cnt);
		
	}
}