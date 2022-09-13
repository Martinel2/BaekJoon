import java.io.*;
import java.util.*;


//2693 N(3)번째 큰 수
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[10];
			
			for(int i = 0; i<10; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			sb.append(arr[7] + "\n");
			
		}
		System.out.println(sb);
	}
}

		