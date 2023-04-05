import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		
		for(int k = 1; k<=K; k++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] grade = new int[N];
			for(int i = 0; i<N; i++) {
				grade[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(grade);
			int max = 0;
			for(int i = N-1; i>0; i--) {
				int cha = grade[i] - grade[i-1];
				if(max < cha)
					max = cha;
			}
			sb.append("Class ").append(k).append("\n");
			sb.append("Max ").append(grade[N-1]).append(", ");
			sb.append("Min ").append(grade[0]).append(", ");
			sb.append("Larget gap ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
