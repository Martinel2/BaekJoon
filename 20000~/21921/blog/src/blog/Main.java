package blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, X;
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		
		int[] arr= new int[N];
		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		for(int i = 1; i<N; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int i = 0;
		int max = 0;
		int cnt = 0;
		while(i+X < N) {
			int visit = arr[i+X]-arr[i];
			if(max < visit) {
				max = visit;
				cnt = 1;
			}
			else if(max == visit)
				cnt++;
				
			
			i++;
		}
		
		if(max == 0)
			System.out.println("SAD");
		else
			System.out.println(max + "\n" + cnt);
	}
}
