import java.io.*;
import java.util.*;


//5676 음주코딩
public class Main {
	static int N,K; // N: 수열 크기  K: 라운드 수
	static int nn;
	static char[] arr;
	static StringBuilder sb = new StringBuilder();;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s = br.readLine();
		while(s != null)
		{
			st = new StringTokenizer(s, " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			for (nn=1; nn<N; nn*=2);	// 인덱스드트리 크기 특정 및 선언   (N보다 큰 최소 2^N)
			arr = new char[nn*2+2];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i<=N; i++) {
				long num =  Long.parseLong(st.nextToken());
				if(num == 0)
					arr[nn+i-1] = '0';
				else if(num > 0)
					arr[nn+i-1] = '+';
				else
					arr[nn+i-1] = '-';
			}
			// 구간합 데이터 만들어줌			- 밑에서부터 데이터를 쌓아올림
			for(int i=nn-1; i>=1; i--) {
				if(arr[i*2] == '0' || arr[i*2+1] == '0')
					arr[i] = '0';
				else if(arr[i*2] == '-' && arr[i*2+1] == '+' ||
						arr[i*2] == '+' && arr[i*2+1] == '-')
					arr[i] = '-';
				else
					arr[i] = '+';
			}
			for (int i=1; i<=K; i++) {
				String type;
				int x;
				long y;		
				st = new StringTokenizer(br.readLine());
				type = st.nextToken();		// 1이면 edit, 2이면 쿼리
				x = Integer.parseInt(st.nextToken());			// type=1 바꿀 수 / type=2 startId
				y = Long.parseLong(st.nextToken());			// type=1 변경값 / type=2 endId
			
				if (type.equals("C")) {
					edit(x,y);
				}
				else {
					int endId;
					endId = (int)y;
					sb.append(multi(x,endId));				
				}
			}
			sb.append("\n");
			s = br.readLine(); 
		}
		System.out.println(sb);
	}
	//인덱스드트리 합 구하기 위로 올라가면서 합 구하기
	static char multi(int start, int end) {
		int l = start + nn - 1;
		int r = end + nn - 1;
		char ret = '+';
		while(l<=r) {
			if ((l & 1) == 1) {
				if(ret == '0' || arr[l] == '0')
					return '0';
				else if(ret == '-' && arr[l] == '+' ||
						ret == '+' && arr[l] == '-')
					ret = '-';
				else
					ret = '+';
				l++;
			}	// 왼쪽 id가 홀수이면 값이 튀므로 더해주고 l++ 해줌 (짝수부터 시작해야하니까)
			if ((r & 1) == 0)// 오른쪽 id가 짝수이면 값이 튀므로 더해주고 r-- 해줌 (홀수로 끝나야하니까)
			{
				if(ret == '0' || arr[r] == '0')
					return '0';
				else if(ret == '-' && arr[r] == '+' ||
						ret == '+' && arr[r] == '-')
					ret = '-';
				else
					ret = '+';
				r--;
			}
			l/=2;	// 위로 올라가기
			r/=2;	// 위로 올라가기
		}
		return ret;
	}
	// 인덱스드트리 수정 1) 해당 id 값 수정 2) 위로 올라가면서 값 갱신 -> logN의 시간복잡도
		static void edit(int id, long value) {
			int x = id + nn - 1;
			// 인덱스드트리 위치에 value의 부호 삽입
			if(value == 0)
				arr[x] = '0';
			else if(value > 0)	
				arr[x] = '+';
			else
				arr[x] = '-';
			x /= 2;
			while(x>0) {
				if(arr[x*2] == '0' || arr[x*2+1] == '0')
					arr[x] = '0';
				else if(arr[x*2] == '-' && arr[x*2+1] == '+' ||
						arr[x*2] == '+' && arr[x*2+1] == '-')
					arr[x] = '-';
				else
					arr[x] = '+';
				x /=2;
			}
			return;
		}
}