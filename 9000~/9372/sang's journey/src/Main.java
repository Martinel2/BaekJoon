import java.io.*;
import java.util.*;

//9372 ������� ����
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			for(int i = 0; i<M; i++) {
				br.readLine();
			}
			sb.append(N-1).append("\n");
		}
		System.out.println(sb);
	}
}
