package solved;

import java.io.*;
import java.util.*;

public class Main {

	public static BufferedWriter bw;
	public static BufferedReader br;



	public static void main(String[] args) throws Exception {

		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int map [] = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		for(int i=1; i<W-1; i++) {
			int maxL =0;
			int maxR = 0;
			for(int j=0; j<i; j++) {
				maxL = Math.max(maxL, map[j]);
			}
			for(int k=i+1; k<W; k++) {
				maxR = Math.max(maxR, map[k]);
			}
			int max = Math.min(maxL, maxR);

			if(map[i] < max)
				sum += max - map[i];
		}

		System.out.println(sum);
	}


}