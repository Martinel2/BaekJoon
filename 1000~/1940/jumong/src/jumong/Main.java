package jumong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1940
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int need = Integer.parseInt(br.readLine());
		int[] material = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			material[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(material);
		
		int left = 0, right = N-1;
		int cnt = 0;
		
		while(left < right) {
			int c = material[left] + material[right];
			if(c < need)
				left++;
			else if(c > need)
				right--;
			else {
				cnt++;
				
				left++;
				right--;
			}
		}
		
		System.out.println(cnt);
	}
}
