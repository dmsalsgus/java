package com.test.question;  
import java.util.*;

public class Q045 {  //사용자가 입력한 범위의 숫자까지 369 게임 과정을 출력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("최대 숫자(3자리까지만 입력가능) : ");
		 int input=sc.nextInt();
		 int cnt=0,result=0;
		
		for(int i=1; i<=input; i++) {
			cnt=0;
			if(i%10==3||i%10==6||i%10==9) {
				result=i/10;
				cnt+=1;
			}else result=i/10;	
			if(result%10==3||result%10==6||result%10==9) {
				result=result/10;
				cnt++;
			}else result=result/10;
			if(result%10==3||result%10==6||result%10==9) {
				result=result/10;
				cnt++;
			}else result=result/10;
			
			if(cnt==1) System.out.print(" 짝 ");
			else if(cnt==2) System.out.print(" 짝짝 ");
			else if(cnt==3) System.out.print(" 짝짝짝 ");
			else System.out.printf(" %d ",i);
		}
	}
}