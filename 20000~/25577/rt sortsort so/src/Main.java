import java.io.*;
import java.util.*;


//25577 열 정렬정렬 정
 public class Main {
	 static int cnt = 0;
	 
	 public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] ans = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			ans[i] = arr[i];
		}
			
		Arrays.sort(arr);
		for(int i = 0; i<N; i++)
		{
			if(arr[i] != ans[i])
			{
				int j = i;
				while(arr[i] != ans[j]) j++;
				//swap
				int temp = ans[i];
				ans[i] = ans[j];
				ans[j] = temp;
				cnt++;
			}
		}
		System.out.print(cnt);
	}
}
		