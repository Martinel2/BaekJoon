package mlnigame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		HashSet<String> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		
		int g; // 자기자신을 빼고 각각 1,2,3명이 필요
		if(game.equals("Y"))
			g = 1;
		else if(game.equals("F"))
			g = 2;
		else
			g = 3;
		
		
		for(int i = 0; i<N; i++) {
			String person = br.readLine();
			set.add(person);
		}
		
		int ans = set.size()/g;
		System.out.println(ans);
	}
}
