import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Long> arr= new ArrayList<>();
		
		for(int i = 0; i<N; i++) {
			arr.add(Long.parseLong(br.readLine()));
		}
		
		Collections.sort(arr);
		
		for(int i = 0; i<M; i++) {
			long num = Long.parseLong(br.readLine());
			
			if(arr.contains(num)) {
				sb.append(arr.indexOf(num)).append('\n');
			}
			else
				sb.append(-1).append('\n');
		}
		
		System.out.println(sb);
	}
}
