import java.io.*;
import java.util.*;


//3273 두수의 합
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i  = 0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int i = 0;
		int j = arr.length-1;
		int cnt = 0;
		while(i < N && j >= 0 && i<j)
		{
			int sum = arr[i] + arr[j];
			if(sum == x) {
				cnt+=1;
				i++; j--;
			}
			else if(sum < x) {i++;}
			else {j--;}
		}
		System.out.println(cnt);
	}
}