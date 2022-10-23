package snakebird;
import java.io.*;
import java.util.*;


//16435 스네이크버드
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int fruit = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[fruit];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<fruit; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		for(int i = 0; i<fruit; i++)
		{
			if(L>=arr[i])
				L++;
			else
				break;
		}
		System.out.print(L);
	}
}