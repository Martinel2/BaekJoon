import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/*
		 1부터 N까지 페이지번호 존재
		 하나라도 빠지면 인쇄해야함
		 연속된 K장의 페이지를 인쇄 5+2K만큼의 잉크사용
		 잉크를 최대한 절약
		 */
		
		int N,M;
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 총 페이지 번호
		M = Integer.parseInt(st.nextToken()); // 떨어진 논문수
		int[] non = new int[N+1];
		int min = N+1;
		int max = 0;
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken()); // 페이지 번호
			non[num] = 1;
		}
		int mnn = N+1;
		int mxn = 0;
		for(int i = 1; i<=N; i++) {
			non[i] += non[i-1];
			if(non[i] == non[i-1]) { // 빠진 페이지 발견
				if(mnn < mxn) { //이미 구간이 존재
					
					if(i-mxn-1 > 2) // 3장 이상 차이나면 손해
					{
						ans += 5 + 2*(mxn-mnn+1);
						mnn = i;
					}
					else { // 2장 이내 차이면 구간 합치기
						mxn = i;
					}
				}
				else {
					if(mnn > i)
						mnn = i;
					if(mxn < i)
						mxn = i;
				}
			}
		}
		if(mnn < mxn) {
			ans += 5 + 2*(mxn-mnn+1);
		}
		System.out.println(ans);
	}
}
