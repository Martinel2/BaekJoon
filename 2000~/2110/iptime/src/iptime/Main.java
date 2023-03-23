package iptime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//2110 ������ ��ġ
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N,C;
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[] H = new int[5];
		for(int i = 0; i<N; i++) {
			H[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(H);
		int ans = 0;
		int left = 1, right = H[N-1] - H[0] + 1;
		while(left<=right) {
			int mid = (left+right)/2;
			
			int ip = 1;
			int idx = 0;
			for(int i = 1; i<N; i++) {
				if(H[i]-H[idx] >= mid) {
					ip++;
					idx = i;
				}
			}
			if(ip == C) {
				ans = mid;
				break;
			}
			else{
				if(ip < C)//�������� ������ ������ == �Ÿ��� �� ���ƾ���
					right = mid;
				else
					left = mid+1;
			}
		}
		
		System.out.println(ans);
	}
}
