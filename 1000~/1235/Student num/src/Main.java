import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		int len = arr[0].length();
		
		int ans = 0;
		for(int i = len-1; i>=0; i--) {
			HashSet<String> set = new HashSet<>();
			
			boolean noDup = true;
			for(int j = 0; j<N; j++) {
				if(set.contains(arr[j].substring(i))) {
					noDup = false;
					break;
				}
				else
					set.add(arr[j].substring(i));
			}
			if(noDup) {
				ans = len-i;
				break;
			}
		}
		System.out.println(ans);
	}
}
/*
3
1212345
1212356
0033445
*/
