import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static class U implements Comparable<U>{
		int idx;
		int cnt;
		int num;
		
		U(int idx, int cnt, int num){
			this.idx = idx;
			this.cnt = cnt;
			this.num = num;
		}

		@Override
		public int compareTo(U o) {
			if(this.cnt == o.cnt)
				return this.idx - o.idx;
			return o.cnt - this.cnt;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, U> hm = new HashMap<>();
		ArrayList<U> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i  = 0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!hm.containsKey(num)) {
				U usual = new U(i,0,num);
				hm.put(num, usual);
				list.add(usual);
			}
			hm.get(num).cnt++;
		}
		Collections.sort(list);
		
		for(int i = 0; i< list.size(); i++) {
			U usual = list.get(i);
			int num = usual.num;
			int cnt = usual.cnt;
			while(cnt-->0)
				sb.append(num).append(' ');
		}
		System.out.println(sb);
	}
}
