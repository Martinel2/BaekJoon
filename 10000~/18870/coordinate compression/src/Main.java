import java.io.*;
import java.util.*;


//18870 ÁÂÇ¥¾ÐÃà
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> press = new ArrayList<Integer>();
		int[] arr;
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++)
		{
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a;
			if(!press.contains(a))
				press.add(a);
		}
		press.sort(null);
		for(int i = 0; i<N; i++)
			sb.append(press.indexOf(arr[i]) + " ");

		System.out.print(sb);
	}
	
}