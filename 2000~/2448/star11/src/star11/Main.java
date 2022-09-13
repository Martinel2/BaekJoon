package star11;

import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][2 * N - 1];
		for(int i =0; i< N; i++)
		{
			for(int j = 0; j< 2*N-1; j++)
			{
				arr[i][j] = ' ';
			}
		}
		tri(N,0,N-1);
		for (int i = 0; i < arr.length; i++) {
			for (int j=0; j<arr[0].length;++j) {
				st.append(arr[i][j]);
			}
			st.append("\n");
		}
		System.out.println(st);
	}
	
	static char[][] arr;
	
	static void tri(int len, int row, int col)//재귀
	{
		if(len == 3)//기본형인 3이되면 그린다
		{
			StringBuilder st = new StringBuilder();
			arr[row][col] = '*';
			arr[row+1][col-1] = '*';
			arr[row+1][col+1] = '*';
			
			for(int i =0; i< 5; i++)
				arr[row+2][col-2+i] = '*';
			return;
		}
		//삼각형을 상 좌 우 로 3등분
		tri(len/2, row, col);
		tri(len/2, row + len/2, col - len/2);
		tri(len/2, row + len/2, col+len/2);
	}
	
}
