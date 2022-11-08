import java.io.*;
import java.util.*;


//17219 비밀번호 찾기
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,String> memo = new HashMap<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			memo.put(st.nextToken(), st.nextToken());
		}
		for(int j = 0; j<M; j++) {
			String site = br.readLine();
			sb.append(memo.get(site)).append("\n");
		}
		System.out.println(sb);
	}
}