import java.io.*;
import java.util.*;


//25581 땅 두배로 따먹기
public class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] san = new int[N];
		int[] heun = new int[N];
		for(int i = 0; i<N; i++){
			arr[i]= Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int len = arr.length-1;
		int k  = 0;
		while(k*2 < N)
		{
			int temp = arr[k];
			arr[k] = arr[len-k];
			arr[(N-1)-k] = temp;
			k++;
		}
		int sant = 0;
		int hnt = 1;
		heun[0] = 0;
		for(int i = 0; i<=len; i++) {
			if(i % 2 == 0)
			{
				if(sant == 0)
					san[sant] = arr[i];
				else
					san[sant] = arr[i] + san[sant-1];
				if(sant < len) {
					san[sant+1] = san[sant];
					sant+=2;
				}
			}
			else{
				if(hnt == 1)
					heun[hnt] = arr[i];
				else
					heun[hnt] = arr[i] + heun[hnt-1];
				if(hnt < len) {
					heun[hnt+1] = heun[hnt];
					hnt+=2;
				}
			}
		}
		int[][] dp = new int[N][2];
		dp[len][0] = san[len]; dp[len][1] = heun[len];
		int i,j;
		for(i = len-1; i>=0; i--) {
			int A,B;
			if(i % 2 == 0)//산지니가 먼저
			{
				if(len-3 >= i) {
					for(j = i+2; j<len; j+=2){
						//  (2번을 사용해서 두배가 된 값) + (현기의 i+1~j까지의 누적합=그사이 산지니가 고른값) + (j번째부터 산지니가 고른 값)
						A = (san[i] + arr[i+1])*2 + (heun[j]-heun[i+1]) + (san[len]-san[j]);
						//  (현기가 j번째에서 2번을 사용한 값) + (현기가 j번째부터 끝까지 고른값)
						B = (heun[i] + (san[j]-san[i]) + arr[j+1])*2 + (heun[len]-heun[j+1]);
						// i 이상인 수에서 2번을 사용했을때 j가 얻을수 있는 최선 = dp[i][x]
						if(dp[i][1] < B || (dp[i][1] == B && dp[i][0] > A)) {
							dp[i][0] = A;
							dp[i][1] = B;
						}
					}
					if(dp[i][0] < dp[i+1][0]) { // i 이상이므로 i+1이 범위가 더 좁음
						dp[i][0] = dp[i+1][0];
						dp[i][1] = dp[i+1][1];
					}
					else if(dp[i][0] == dp[i+1][0])
						dp[i][1] = Math.min(dp[i][1],dp[i+1][1]);
				}
				else {
					//  (2번을 사용해서 두배가 된 값)
					A = (san[i] + arr[i+1])*2;
					//  (현기가 i번째까지 고른값)+ (그뒤에 고른값)
					B = heun[i] + (san[len]-san[i+1]);
					dp[i][0] = A;
					dp[i][1] = B;	
				}
			}
			else {
				//현기가 먼저
				if(len-3 >= i) {
					for(j = i+2; j<len; j+=2){
						//  (2번을 사용해서 두배가 된 값) + (산지니의 i+1~j까지의 누적합=그사이 현기가 고른값) + (j번째부터 현기가 고른 값)
						B = (heun[i]+arr[i+1])*2 + (san[j]-san[i+1]) + (heun[len]-heun[j]);
						//  (산지니가 j번째에서 2번을 사용한 값) + (산지니가 j번째부터 끝까지 고른값)
						A = (san[i] + (heun[j]-heun[i]) + arr[j+1])*2 + (san[len]-san[j+1]);
						// i 이상인 수에서 2번을 사용했을때 j가 얻을수 있는 최선 = dp[i][x]
						if(dp[i][0] < A || (dp[i][0] == A && dp[i][1] > B)) {
							dp[i][0] = A;
							dp[i][1] = B;
						}
					}
					if(dp[i][1] < dp[i+1][1]) { // i 이상이므로 i+1이 범위가 더 좁음
						dp[i][0] = dp[i+1][0];
						dp[i][1] = dp[i+1][1];
					}
					else if(dp[i][1] == dp[i+1][1])
						dp[i][0] = Math.min(dp[i][0],dp[i+1][0]);
			    }
				else {
					//  (2번을 사용해서 두배가 된 값)
					B = (heun[i]+arr[i+1])*2;
					//  (산지니가 i번째까지 더한 값) + (i+1부터 N-1까지 고른값)
					A = san[i] + (heun[len]-heun[i+1]);
					dp[i][0] = A;
					dp[i][1] = B;
				}
			}
		}
		for(i = 0; i<=len; i++)
		{
			System.out.println("산지니:" + dp[i][0] + "   " + "현기:"+ dp[i][1]);
		}
		System.out.println(dp[0][0]);
	}
}