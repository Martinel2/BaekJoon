import java.io.*;
import java.util.*;


//1977 완전제곱수
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] ps = new boolean[10001]; // 완전제곱수 판별 배열
		for(int i = 1; i*i<=10000; i++)
		{
			ps[i*i] = true;
		}
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = -1;
		for(int i = M; i<=N; i++)
		{
			if(ps[i])
			{	
				if(sum == 0)//가장 먼저 나오는 수가 최솟값
					min = i;
				sum += i;
			}
		}
		if(min == -1)
			System.out.print("-1");
		else
			System.out.print(sum + "\n" + min);
	}
}