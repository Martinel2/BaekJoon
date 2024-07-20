package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			double n = Double.parseDouble(st.nextToken());
			double x = Double.parseDouble(st.nextToken());
			double dist = 0;
			
			double left = n * 100 - (16.0 / Math.sin(Math.PI * x / 180.0));
			double right = n * 100 + (16.0 / Math.sin(Math.PI * x / 180.0));
			double step = (85.0 / Math.tan(Math.PI * x / 180.0));
			
			while(dist < right) {
				if(left < dist && dist < right) {
					sb.append("yes\n");
					break;
				}
				dist += step;
			}
			if(dist >= right) {
				sb.append("no\n");
			}
		}
		System.out.println(sb);
	}
}