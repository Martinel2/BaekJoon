import java.io.*;
import java.util.*;


//2828 사과 담기 게임
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int left = 0;
		int right = M;
		int ans = 0;
		int j = Integer.parseInt(br.readLine());
		for(int i = 0; i<j; i++)
		{
			int apple = Integer.parseInt(br.readLine());
			if(left <= apple && apple <= right)
				continue;
			else if(left > apple)
			{
				ans += left - apple;
				right = apple + M -1;
				left = apple;
			}
			else
			{
				ans += apple - right;
				right = apple;
				left = right - M + 1;
			}
		}
		System.out.println(ans);
	}
}