import java.io.*;
import java.util.*;

//1244 스위치 켜고 끄기
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int on = 1; int off = 0;
		int[] sw = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i<=N; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		
		int stu = Integer.parseInt(br.readLine());
		for(int i = 0; i<stu; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int gen = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			//남자
			if(gen == 1) {
				int k = 1;
				while(k*num <= N) {
					if(sw[k*num] == on) sw[k*num] = off;
					else sw[k*num] = on;
					k++;
				}
			}
			//여자
			else {
				if(sw[num] == on)
					sw[num] = off;
				else
					sw[num] = on;
				int k = 1;
				while( 0 < (num-k) && (num+k) <= N ) {
					if(!(sw[num-k] == sw[num+k]))
						break;
					
					if(sw[num-k] == on) sw[num-k] = off;
					else sw[num-k] = on;
					
					if(sw[num+k] == on) sw[num+k] = off;
					else sw[num+k] = on;
					
					k++;
				}
				
			}
		}
		for(int i = 1; i<=N; i++) {
			sb.append(sw[i]).append(" ");
			if(i%20 == 0)
				sb.append("\n");
		}
		System.out.print(sb);
	}
}
