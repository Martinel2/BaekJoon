package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t= Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<String> al = new ArrayList<>();
			int[] mbti = new int[16];
			boolean three = false;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				String s = st.nextToken();
				int cnt = 0;
				for(int j = 0; j<4; j++) {
					if(s.charAt(j) == 'E' || s.charAt(j) == 'S' ||
							s.charAt(j) == 'T' || s.charAt(j) == 'P') {
						cnt += Math.pow(2, j);
					}
				}
				mbti[cnt]++;
				if(mbti[cnt] < 3) 
					al.add(s);
				else three = true;
			}
			
			int len = al.size();
			int ans = 20;
			if(three) {
				ans = 0;
				sb.append(ans).append('\n');
			}
			else {
				int[][] arr = new int[len][4];
				
				for(int i = 0; i<len; i++) {
					String s = al.get(i);
					for(int j = 0; j<4; j++) {
						if(s.charAt(j) == 'E' || s.charAt(j) == 'S' ||
								s.charAt(j) == 'T' || s.charAt(j) == 'P')
							arr[i][j]++;
					}
				}
				
				// ESTP ISTJ INFP
				// 1 2 2 2 = 8
				// (2) + (3) + (3) = 8
				for(int i = 0; i<len-2; i++) {
					for(int j = i+1; j<len-1; j++) {
						for(int k = j+1; k<len; k++) {
							int cnt = 0;
							for(int m = 0; m<4; m++) {
								//더했을때 1또는2이면 무조건 한명이 다른것
								// 한 명이 다르다면 해당 성향에서의 상대적 거리차이는 항상 2
								int sum = arr[i][m] + arr[j][m] + arr[k][m];
								if(sum == 1 || sum == 2)
									cnt+=2;
							}
							if(ans > cnt)
								ans = cnt;
						}
					}
				}
				sb.append(ans).append('\n');
			}
		}
		System.out.println(sb);
	}
}
