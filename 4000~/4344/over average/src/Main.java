import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//4344
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t= Integer.parseInt(br.readLine());
		
		for(int T = 0; T<t; T++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			double avg;
			long sum = 0;
			int[] score = new int[N];
			
			for(int i = 0; i<N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				sum += score[i];
			}
			avg = (double)sum/N;
			
			double overavg;
			int overstu = 0;
			for(int i = 0; i<N; i++) {
				if(score[i] > avg)
					overstu++;
			}
			
			overavg = (double)overstu/N * 100;
			
			long intavg = Math.round(overavg*1000);
			avg = (double)(intavg)/1000;
			
			sb.append(avg).append("%\n");
		}
		
		System.out.println(sb);
	}
}

/*
5
5 50 50 70 80 100
7 100 95 80 70 60 50 80
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91
 */
