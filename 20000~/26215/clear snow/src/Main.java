import java.io.*;
import java.util.*;

//26215 ´« Ä¡¿ì±â
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] house = new int[n];
		int sum = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<n; i++) {
			house[i] = Integer.parseInt(st.nextToken());
			sum += house[i];
		}
		Arrays.sort(house);
		if(sum > 2880 || house[n-1] > 1440)
			System.out.println(-1);
		else {
			int cnt = 0;
			while(house[n-1] != 0 && cnt <=1440) {
				house[n-1]--;
				house[n-2]--;
				cnt++;
				Arrays.sort(house);
			}
			System.out.println(cnt);
		}
	}
}

