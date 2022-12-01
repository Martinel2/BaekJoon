import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 전깃줄
// 동적 프로그래밍 문제 
public class Main {
	static int n;
	static int[] dp, powerPole;	// dp : 가장 긴 증가하는 부분수열과 같음. 가장 뒤에 있는 값은 이전까지의 전깃줄로 연결된 전봇대의 최대 번호 
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		dp = new int[101];	// 최대 전깃줄의 개수가 100개 있으므로 
		powerPole = new int[501];	// 최대 전봇대의 번호가 500번까지 있음 
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			powerPole[a] = b;
		}
		
		int count = 0;
		int dpLen = 1;
		// DP로 구하기 
		for(int i = 1; i < powerPole.length; i++) {
			if(powerPole[i] != 0) {	// 전깃줄이 연결되어 있는 경우 
				if(dp[dpLen - 1] < powerPole[i]) {	// 가장 최대의 전봇대 번호보다 더 큰전봇대와 연결되어있으면 
					dp[dpLen++] = powerPole[i];
				}
				else {	// 작으면 이분탐색 알고리즘을 사용해서 DP 배열안의 값과 교체하기 
					binarySearch(dpLen, i);
				}
			}
		}
		
		System.out.println(n - dpLen + 1);
	}
	
  // 이분탐색으로 DP배열 
	public static void binarySearch(int dpLen, int nowIndex) {
		int start = 0;
		int end = dpLen;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int midDpEle = dp[mid];
			
			if(midDpEle < powerPole[nowIndex]) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		dp[start] = powerPole[nowIndex];
	}
}

/*
8
1 8
3 9
2 2
4 1
6 4
10 10
9 7
7 6
*/ 
