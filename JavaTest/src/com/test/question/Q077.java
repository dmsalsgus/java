package com.test.question;

public class Q077 {  // //아래와 같이 출력하시오.
	/*
	1	  2    4	  7    11        
	3	  5	    8    12	16      
	6	  9	    13  17	20
	10	  14  18  21	23
	15	  19  22  24	25    //좌표값을 계산하면 5를 기준으로 x와 y가 대응된다.
	*/
	public static void main(String[] args) { 
		int[][] nums=new int[5][5];
		int n=1;
		
		for(int i=0; i<9; i++) {  //대각선
			for(int j=0; j<5; j++) {  //행
				if(i-j>=0&&i-j<5) {  // i-j == 열
					nums[j][i-j]=n;
					n++;
				}
			}
		}
		//출력
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.printf("%5d",nums[i][j]);
			}
			System.out.println();
		}
	}
}
