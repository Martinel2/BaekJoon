package memorize;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static class M implements Comparable<M>{
		String word = "";
		int cnt = 0;
		
		M(String word, int cnt){
			this.cnt = cnt;
			this.word = word;
		}
		
		@Override
		public int compareTo(M o) {
			if(this.cnt != o.cnt)
				return o.cnt - this.cnt;
			else{
				if(this.word.length() != o.word.length())
					return o.word.length() - this.word.length();
				
				else return this.word.compareTo(o.word);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		HashMap<String, Integer> hm = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			if(s.length() >= M ){
				hm.put(s, hm.getOrDefault(s, 1)+1);
			}
		}
		int idx = 0;
		M[] W = new M[hm.size()];
		for(Map.Entry<String, Integer> val : hm.entrySet()) {
			W[idx] = new M(val.getKey(), val.getValue());
			idx++;
		}
		Arrays.sort(W);
		for(int i = 0; i<idx; i++) {
			bw.write(W[i].word+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
