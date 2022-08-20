import java.io.*;
import java.util.*;


//1037 ÃÖ¼Ú°ª°ú ÃÖ´ñ°ª
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		System.out.print(arr[0] * arr[arr.length-1]);
		
	}
}