import java.util.*;
import java.io.*;

//2294 µ¿Àü 2
public class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		PriorityQueue<Integer> arr = new PriorityQueue<>();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[10001];
		for(int i = 0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(!arr.contains(num) && num <= 10000){
				arr.add(num);
			}
		}
		int len = arr.size();
		int[] numarr = new int[len];
		for(int i = 0; i<len; i++) {
			int num = arr.poll();
			numarr[i] = num;
			dp[num] = 1;
		}
		for(int i = numarr[0]; i<=k-numarr[0]; i++) {
			if(dp[i] == 0)
				continue;
			else {
				for(int j = 0; j<len; j++) {
					int plus = i + numarr[j];
					if(plus <= k) {
						if(dp[plus] == 0 || dp[plus] > dp[i]+1)
							dp[plus] = dp[i]+1;
					}
					else {
						len--;
						break;
					}
				}
			}
		}
		
		if(dp[k] != 0)
			System.out.print(dp[k]);
		else
			System.out.println("-1");
	}
	
}
