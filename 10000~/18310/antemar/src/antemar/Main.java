package antemar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] dis = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			dis[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(dis);
		
		System.out.println(dis[(N-1)/2]);
	}
}
