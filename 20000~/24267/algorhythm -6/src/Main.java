import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				for(int k = 1; k<=N; k++) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(3);
	}
}