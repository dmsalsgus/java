package com.test.question;

public class Q078 {  // //아래와 같이 출력하시오.
	/*
	1	  2    3	  4    5        
	16	  17  18  19	6      
	15	  24  25  20	7
	14	  23  22  21	8
	13  12  11  10	9    // 0,0 -> 0,4 -> 4,4 -> 4,0 -> 1,0 -> 1,3
	*/
	public static void main(String[] args) { 
		int[][] nums=new int[5][5];
		int[] dx= {0, 1, 0, -1};   //x의 우 -> 하 -> 좌 -> 상
		int[] dy= {1, 0, -1, 0};   //y의 우 -> 하 -> 좌 -> 상
		int n=1;
		int x=0, y=0;  //배열의 시작위치
		int dir=0;    //방향 바꿀 변수
		
		while(n<=25) {  
			nums[x][y]=n++;
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(nx<0||nx>4||ny<0||ny>4 || nums[nx][ny] != 0) {  //숫자를 넣을 위치에 숫자가 있거나, 배열의 크기를 넘어가면
				dir=(dir+1)%4;  //방향전환.
				nx = x + dx[dir];
				ny = y + dy[dir];
			}	
			x=nx;
			y=ny;
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