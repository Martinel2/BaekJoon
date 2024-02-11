import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[50001];
		int ans = 0;
		
		for(int i = 0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[num]++;
			if(ans < arr[num])
				ans = arr[num];
		}
		
		System.out.println(ans);
	}
}
