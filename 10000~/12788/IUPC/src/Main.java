import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int team = Integer.parseInt(st.nextToken());
		int member = Integer.parseInt(st.nextToken());
		
		int need = team*member;
		
		int total = 0;
		int[] pen = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			pen[i] = Integer.parseInt(st.nextToken());
			total += pen[i];
		}
		
		if(total < need)
			System.out.println("STRESS");
		else {
			Arrays.sort(pen);
			int ans = 0;
			int cnt = 0;
			for(int i = N-1; i>=0; i--) {
				cnt += pen[i];
				ans++;
				if(cnt >= need)
					break;
			}
			System.out.println(ans);
		}
	}
}
