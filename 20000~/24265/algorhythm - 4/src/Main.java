import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i = 1; i<=N-1; i++) {
			for(int j = i+1; j<=N; j++) {
				cnt++;
			}
		}
		System.out.println(cnt);
		if(N > 1)
			System.out.println(2);
		else
			System.out.println(4);
	}
}