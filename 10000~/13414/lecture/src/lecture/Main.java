package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayList<String> list = new ArrayList<>();
		
		int K,L;
		
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		
		for(int i = 0; i<L; i++) {
			String num = br.readLine();
			
			if(list.contains(num)) {
				list.remove(num);
			}
			list.add(num);
		}
		
		for(int i = 0; i<K; i++) {
			sb.append(list.get(i)).append('\n');
		}
		
		System.out.println(sb);
	}
}
/*
3 8
20103324
20133221
20133221
20093778
20140101
01234567
20093778
20103325
*/
