package brush;

import java.io.*;
import java.util.*;
 

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long W = Long.parseLong(st.nextToken());
		long t = W*Long.parseLong(st.nextToken());
		long f = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());
		long xf = 0;
		if (f > W-f) {
			xf = W-f;
		}
		else {
			xf = f;
		}
		if (xf <= x1) {
			t -= (x2-x1)*(y2-y1)*(c+1);
		}
		else if (xf < x2) {
			t -= (xf-x1)*(y2-y1)*2*(c+1);
			t -= (x2-xf)*(y2-y1)*(c+1);
		}
		else {
			t -= (x2-x1)*(y2-y1)*2*(c+1);
		}
		System.out.println(t);
	}
}
