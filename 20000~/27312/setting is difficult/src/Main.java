import java.io.*;
import java.util.*;

//27312 운영진에게 설정 짜기는 어려워
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int M,N,Q;
		M = Integer.parseInt(st.nextToken()); // 캐릭터 수
		N = Integer.parseInt(st.nextToken()); // 속성 갯수
		Q = Integer.parseInt(st.nextToken()); // 질문 갯수
		
		int[] arr = new int[N]; // i번째 속성값
		int[] newC = new int[N]; // 새로운 캐릭터 속성값
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			newC[i] = arr[i];
		}
		
		for(int i = 1; i<=M; i++) {
			System.out.println("? "+(i)+" "+(i));
			System.out.flush();
			int ans = Integer.parseInt(br.readLine());
			if(newC[i-1] == ans)
				newC[i-1]--;
		}
		
		sb.append("! ");
		for(int val : newC)
			sb.append(val+" ");
		System.out.print(sb);
		System.out.close();
		System.exit(0);
	}
}