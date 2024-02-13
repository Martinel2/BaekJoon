import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean clear = true;
		String ans = "";
		int n,m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<m; i++) {
			int k = Integer.parseInt(br.readLine());
			int num = 200001;
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<k; j++) {
				int c = Integer.parseInt(st.nextToken());
				if(num > c) {
					num = c;
				}
				else {
					clear = false;
					break;
				}
			}
		}
		ans = clear ? "Yes" : "No";
		System.out.println(ans);
			
	}
}
