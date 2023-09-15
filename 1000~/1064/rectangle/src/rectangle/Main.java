package rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1064
public class Main {
	
	static class dot{
		int x;
		int y;
		
		dot(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		double length(dot d) {
			return Math.sqrt(Math.pow((this.x - d.x), 2) + Math.pow((this.y - d.y),2) );
		}
		
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		dot[] D = new dot[3];
		double ans = 0;
		for(int i = 0; i<3; i++) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			D[i] = new dot(x,y);
		}
		
		if((D[0].x-D[1].x)*(D[0].y - D[2].y) == (D[0].x - D[2].x)*(D[0].y-D[1].y))
			ans = -1;
		else {
			double[] rect = new double[3];
			rect[0] = D[0].length(D[1])*2 + D[0].length(D[2])*2;
			rect[1] = D[0].length(D[2])*2 + D[1].length(D[2])*2;
			rect[2] = D[1].length(D[2])*2 + D[0].length(D[1])*2;
			
			Arrays.sort(rect);
			ans = rect[2] - rect[0];
		}
		System.out.println(ans);
	}
}
