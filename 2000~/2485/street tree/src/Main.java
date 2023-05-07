import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int cnt = 0;
		int cha = arr[1]-arr[0];
		int idx = 0;
		int extra = arr[idx] + cha;
		while(idx < N-1) {
			if(extra == arr[idx+1]) {
				idx++;
				extra = extra + cha;
			}
			else if(arr[idx+1] - extra >= cha) {
				cnt++;
				//System.out.println(extra);
				extra = extra + cha;
			}
			else {
				cha = arr[idx+1]-extra;
				idx = 0;
				cnt = 0;
				extra = arr[idx] + cha;
			}
		}
		System.out.println(cnt);
	}
}
