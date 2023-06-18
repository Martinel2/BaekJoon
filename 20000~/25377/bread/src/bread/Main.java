package bread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//25377
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int ans = 9999;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int go = Integer.parseInt(st.nextToken());
			int bread = Integer.parseInt(st.nextToken());
			
			int time = go <= bread ? bread : 9999;
			if(ans > time)
				ans = time;
		}
		if(ans == 9999) ans = -1;
		System.out.println(ans);
	}
}
