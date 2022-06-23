import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		StringBuilder st = new StringBuilder();
		int i,j;
		int row = Integer.parseInt(tk.nextToken());
		int col = Integer.parseInt(tk.nextToken());
	
		int[][] A = new int[row][col];
		int[][] B = new int[row][col];
		
		for(i =0; i<row; i++) // 행렬 초기화
		{
			tk = new StringTokenizer(br.readLine(), " ");
			for(j = 0; j<col; j++)
				A[i][j] = Integer.parseInt(tk.nextToken());
		}
		for(i =0; i<row; i++) // 행렬 초기화
		{
			tk = new StringTokenizer(br.readLine(), " ");
			for(j = 0; j<col; j++) {
				B[i][j] = Integer.parseInt(tk.nextToken()) + A[i][j];
				st.append(B[i][j]);
				st.append(" ");
			}
			st.append("\n");
		}
		System.out.print(st);
	}
}
