package invitation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] tree = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken())+1; //다 자라는 시간 + 묘목을 구입한 날이 1일
		}
		
		Arrays.sort(tree);
		
		int cnt = tree[0] + 1; //첫번째 나무를 심은날은 2일차이다.
		
		for(int i = N-2; i>=0; i--) {
			if(cnt < tree[i] + (N-i)) //묘목을 구입한 날이 1일 이므로, 두번째 나무를 심는날은 3일차가된다.
				cnt = tree[i] + (N-i);
			//System.out.println(tree[i] + "  "+ cnt);
		}
		
		System.out.println(cnt);
	}
}
