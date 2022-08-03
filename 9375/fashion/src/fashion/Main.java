package fashion;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hm = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<T; i++)
		{
			int N = Integer.parseInt(br.readLine());//¿ÊÀÇ °¹¼ö
			
			for(int j = 0; j<N; j++)
			{
				String[] clothes = br.readLine().split(" ");
				hm.put(clothes[1], hm.getOrDefault(clothes[1], 0) + 1 );
			}
			int sum = 1;
			for(int val : hm.values())
			{
				sum *= (1+val);
			}
			sb.append(sum-1 + "\n");
			hm.clear();
		}
		System.out.println(sb);
	}
}
