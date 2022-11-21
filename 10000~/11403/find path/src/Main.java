import java.io.*;
import java.util.*;


//11403 경로찾기
public class Main {
	
	static Queue<Integer> q = new LinkedList<>();
	static int[][] arr;
	
	static void BFS(int start, int end) {
		arr[start][end] = 1;
		for(int i = 0; i<arr.length; i++) {
			if(arr[end][i] == 1 && arr[start][i] != 1)
				q.add(i);
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0; i<N; i++)
		{
			st= new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(arr[i][j]==1)
					q.add(j);
			}
			while(!q.isEmpty()) {
				int p = q.poll();
				BFS(i,p);
			}
		}
		
		for(int i = 0; i<N; i++)
		{
			for(int j = 0; j<N; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}