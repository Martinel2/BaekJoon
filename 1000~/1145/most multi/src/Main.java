import java.io.*;
import java.util.*;


//1145 적어도 대부분의 배수
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[5];
		for(int i = 0; i<5; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int max = arr[0]*arr[1]*arr[2];
		
		for(int i = arr[2]; i<=max; i++)
		{
			int cnt = 0;
			for(int j = 0; j<5; j++)
				if( i % arr[j] == 0 )
					cnt++;
			if(cnt >= 3)
			{
				System.out.print(i);
				break;
			}
			
		}
		
	}
}