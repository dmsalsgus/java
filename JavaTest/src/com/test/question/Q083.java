package com.test.question;
import java.util.*;

public class Q083 {  //파일명 10개를 입력받아 각 확장자별로 총 개수를 출력하시오.
	//파일 종류는 5가지 중 하나이다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mp3=0, jpg=0, java=0, hwp=0, doc=0;
		for(int i=0; i<10; i++) {  
			System.out.print("파일명 : ");
			String file_name=sc.nextLine();   //파일 10개 입력.
			int index=file_name.lastIndexOf(".");
			switch(file_name.charAt(index+3)) {  //"."기준 앞에 3번째 글자로 비교.
			case '3':
				mp3++; break;
			case 'g':
				jpg++; break;
			case 'v':
				java++; break;
			case 'p':
				hwp++; break;
			case 'c':
				doc++; break;
			}
		}
		System.out.printf("mp3 : %d개\n", mp3);
		System.out.printf("jpg : %d개\n", jpg);
		System.out.printf("java : %d개\n", java);
		System.out.printf("hwp : %d개\n", hwp);
		System.out.printf("doc : %d개\n", doc);
	}
}
/*
//파일명 입력
for (int i = 0; i < file.length; i++) {
   System.out.print("파일명: ");
   file[i] = scan.nextLine();

   // 파일 확장자 추출
   int index = file[i].lastIndexOf(".");
   String fileExtension = file[i].substring(index);

   // 확장자 누적 합계
   for (int j = 0; j < extension.length; j++) {
      if (fileExtension.replace(".", "").equals(extension[j])) {
         sum[j]++;
      }
   }
}
*/