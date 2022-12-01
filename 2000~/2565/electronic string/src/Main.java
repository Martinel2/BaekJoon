import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ������
// ���� ���α׷��� ���� 
public class Main {
	static int n;
	static int[] dp, powerPole;	// dp : ���� �� �����ϴ� �κм����� ����. ���� �ڿ� �ִ� ���� ���������� �����ٷ� ����� �������� �ִ� ��ȣ 
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		dp = new int[101];	// �ִ� �������� ������ 100�� �����Ƿ� 
		powerPole = new int[501];	// �ִ� �������� ��ȣ�� 500������ ���� 
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			powerPole[a] = b;
		}
		
		int count = 0;
		int dpLen = 1;
		// DP�� ���ϱ� 
		for(int i = 1; i < powerPole.length; i++) {
			if(powerPole[i] != 0) {	// �������� ����Ǿ� �ִ� ��� 
				if(dp[dpLen - 1] < powerPole[i]) {	// ���� �ִ��� ������ ��ȣ���� �� ū������� ����Ǿ������� 
					dp[dpLen++] = powerPole[i];
				}
				else {	// ������ �̺�Ž�� �˰����� ����ؼ� DP �迭���� ���� ��ü�ϱ� 
					binarySearch(dpLen, i);
				}
			}
		}
		
		System.out.println(n - dpLen + 1);
	}
	
  // �̺�Ž������ DP�迭 
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
