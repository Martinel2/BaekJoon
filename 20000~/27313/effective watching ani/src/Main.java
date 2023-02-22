import java.io.*;
import java.util.*;

//27313 효율적인 애니메이션 감상
public class Main {
	
	static long[] ani;
	static int N,K;
	static long M;
	static boolean ser(int anime) {
		int cnt = 0;
		long T = 0;
		//end == 1일때
		if(anime == 0 && ani[0] <= M)
			cnt = 1;
		for(int i = anime-1; i>=0; i-=K) {
			if(T + ani[i] <= M)
			{
				//K개가 아닐때
				if(i+1 < K) {
					T += ani[i];
					cnt += i+1;
				}
				else {
					T += ani[i];
					cnt += K;
				}
			}
		}
		return cnt >= anime;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//애니메이션 갯수
		M = Long.parseLong(st.nextToken());//사용가능한 총 시간
		K = Integer.parseInt(st.nextToken());//동시에 볼수있는 애니메이션 갯수
		
		ani = new long[N];//애니매이션 시간 저장 
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			ani[i] = Long.parseLong(st.nextToken());
		Arrays.sort(ani); // 오름차순 정렬
		
		int start = 0;
		int end = N;
		int ans = 0;
		if(M != 0) {	//매개변수 탐색
			while(start<=end) {
				if(end == 0)
					break;
				int mid = (start+end)/2;
				if(ser(mid)) {
					ans = mid;
					start = mid+1;
				}
				else
					end = mid-1;
			}
		}
		System.out.println(ans);
	}
}
