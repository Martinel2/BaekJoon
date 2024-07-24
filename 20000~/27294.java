package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int time = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int ans = 0;
		if(s==1 || (12 > time || 16 < time)) ans = 280;
		else ans = 320;
		
		System.out.println(ans);
	}
}