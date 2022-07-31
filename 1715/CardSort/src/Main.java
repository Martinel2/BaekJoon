import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pq = new PriorityQueue();
		int sum  = 0;
		int total = 0;
		int cnt = 0;
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++)
		{
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		while(!pq.isEmpty())
		{
			sum += pq.poll();
			cnt++;
			if(cnt == 2)
			{
				cnt = 0;
				pq.add(sum);
				total += sum;
				sum = 0;
			}
		}
		System.out.println(total);
	}

}
