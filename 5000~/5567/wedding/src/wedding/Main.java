package wedding;
import java.io.*;
import java.util.*;

//5567 °áÈ¥½Ä
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> Q = new LinkedList<>();
		HashSet<Integer> list = new HashSet<>();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][n+1]; 
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		for(int i = 2; i<=n; i++) {
			if(arr[1][i] != 0) {
				Q.add(i);
				list.add(i);
			}
		}
		while(!Q.isEmpty()) {
			int str = Q.poll();
			for(int i = 2; i<=n; i++) {
				if(arr[str][i] !=0)
					list.add(i);
			}
		}
		System.out.print(list.size());
	}
}
