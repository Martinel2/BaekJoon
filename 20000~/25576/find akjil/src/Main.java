import java.io.*;
import java.util.*;


//25576 Ã£¾Ò´Ù ¾ÇÁú
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] ralo = new int[M];
		int ak = 0;
		
		for(int i = 0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			for(int j = 0; j<M; j++)
			{
				if(i == 0)
					ralo[j] = Integer.parseInt(st.nextToken());
				else
				{
					sum += Math.abs(ralo[j]-Integer.parseInt(st.nextToken()));
				}
				if(sum > 2000){
					ak++;
					break;
				}
			}
		}
		if(ak*2 >= (N-1))
			System.out.println("YES");
		else
			System.out.println("NO");

	}
}