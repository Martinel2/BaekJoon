package minheap;

import java.io.*;
import java.util.*;

//1927 √÷º“»¸
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++)
		{
			int data = Integer.parseInt(br.readLine());
			
			if(data == 0)
			{
				if(!pq.isEmpty()) {
					sb.append(pq.remove() + "\n");
				}
				else
					sb.append("0\n");
			}
			else
			{
				pq.add(data);
			}
		}
		System.out.print(sb);
		
	}
}
