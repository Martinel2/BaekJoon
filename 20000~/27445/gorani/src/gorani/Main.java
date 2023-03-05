package gorani;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//27445 gorani command
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N,M;
		N = Integer.parseInt(st.nextToken());//세로
		M = Integer.parseInt(st.nextToken());//가로
		
		int ymin = M;
		int xmin = N;
		for(int i = 0; i<N-1; i++) {
			int dis = Integer.parseInt(br.readLine());
			if(ymin>dis)
				ymin = dis;
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			int dis = Integer.parseInt(st.nextToken());
			if(i == 0) {
				if(ymin>dis)
					ymin = dis;
				if(xmin>dis)
					xmin = dis;
			}
			else {
				if(xmin>dis)
					xmin = dis;
			}
		}
		System.out.println(N-xmin+" "+(ymin+1));
	}
}
