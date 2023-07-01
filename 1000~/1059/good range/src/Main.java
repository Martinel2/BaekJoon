import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1059
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int L = Integer.parseInt(br.readLine());
		
		int[] set = new int[L];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<L; i++) {
			set[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(set);
		
		int n = Integer.parseInt(br.readLine());
		int left=0,right=0;
		int ans = 0;
		for(int i = 0; i<L; i++) {
			if(n > set[i])
				left = set[i];
			if(n < set[i] && right == 0)
				right = set[i];
			if(n == set[i]) {
				ans = -1;
				break;
			}
		}
		if(ans == -1)
			ans = 0;
		else {
			left += 1;
			right -= 1;
			
			for(int i = left; i<=n; i++) {
				for(int j = right; j>=n; j--)
					ans++;
			}
		}
		
		System.out.println(ans-1);
	}
}
