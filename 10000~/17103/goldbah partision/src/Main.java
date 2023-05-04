import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] che = new boolean[500001];
		int k = 2;
		while(k*2 <= 500000) {
			if(!che[k])
				for(int i = 2; k*i<=500000; i++) {
					che[k*i] = true;
				}
			k++;
		}
		
		int t = Integer.parseInt(br.readLine());
		for(int T = t; T<t; T++) {
			int num = Integer.parseInt(br.readLine());
			int cnt = 0;
			for(int i = 2; i<=num/2; i++) {
				if(!che[i] && !che[num-i])
					cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
