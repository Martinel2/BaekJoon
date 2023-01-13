import java.io.*;
import java.util.*;

//1783 병든 나이트
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans;
		if(N>=3 && M>=7) {
			ans = 5 + (M-7);
		}
		else {
			if(N<=1 || M<=1)
				ans = 1;
			else if(N==2)
			{
				if(M%2 == 0)
					ans = Math.min(4, M/2);
				else
					ans = Math.min(4,M/2 +1);
			}
			else if(M>4)
				ans = 4;
			else
				ans = M;
		}
		
		System.out.println(ans);
	}
}

