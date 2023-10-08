import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] che = new boolean[1001];
		ArrayList<Integer> prime = new ArrayList<>();
		for(int i = 2; i<=1000; i++) {
			if(!che[i]) {
				prime.add(i);
				int j = 2;
				while(i*j <= 1000) {
					che[i*j] = true;
					j++;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			int idx=0;
			int x=0,y=0,z=0;
			for(int i = n-4; i>=0; i--) {
				if(!che[i]) {
					x = i;
					idx = prime.indexOf(i);
					break;
				}	
			}
			for(int i = 0; i<=idx; i++) {
				for(int j = i; j<=idx; j++) {
					if(n == x + prime.get(i) + prime.get(j)) {
						y = prime.get(j);
						z = prime.get(i);
						break;
					}	
				}
			}
			sb.append(z).append(' ').append(y).append(' ').append(x).append('\n');
		}
		System.out.println(sb);
		
	}
}
