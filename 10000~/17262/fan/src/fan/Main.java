package fan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		
		int fast = 0, last=100001;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(fast < start)
				fast = start; //가장 마지막 시작점
			if(last > end)
				last = end; //가장 빠른 끝점
		}
		int ans = fast-last; //가장 빠른 끝점과 가장 마지막 시작시점사이에 존재해야함.
		if(ans < 0) //존재하고도 남는 경우는 0으로 하자
			ans = 0;
		System.out.println(ans);
	}
}
