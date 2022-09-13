import java.io.*;
import java.util.*;


//2042 구간 합 구하기
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());//수의 갯수
		int M = Integer.parseInt(st.nextToken());//변경횟수
		int K = Integer.parseInt(st.nextToken());//구간합횟수
		int[] arr = new int[N];
		
		for(int i = 0; i<N; i++)//배열 초기화
			arr[i] = Integer.parseInt(br.readLine());
		
		while(M != 0 || K != 0)// 횟수를 전부 소진할때까지
		{
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			long sum = 0;
			if(a == 1)//변경
			{
				M--;
				arr[b-1] = c;
			}
			else//구간합 구하기
			{
				K--;
				for(int i = b-1; i<c; i++)
					sum += arr[i];
				sb.append(sum + "\n");
			}
		}
		System.out.print(sb);
	}
}