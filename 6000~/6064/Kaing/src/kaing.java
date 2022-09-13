import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class kaing {
 	public static void main(String arg[]) throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		int T = Integer.parseInt(br.readLine());
 		while(T --> 0) {
 			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 			int N = Integer.parseInt(st.nextToken());
 			int M = Integer.parseInt(st.nextToken());
 			int x = Integer.parseInt(st.nextToken());
 			int y = Integer.parseInt(st.nextToken());
 			int lcm = N*M;
 			if(N > M) {
 				lcm /= gcd(N,M);
 			}
 			else {
 				lcm /= gcd(M,N);
 			}
 			int cnt = x % (N+1);
 			int tempy = x;
 			
 			for(int i = 0; i < M; i++) {
 				int ty = tempy % M == 0 ? M : tempy % M;
 				if(ty == y) {
 					break;
 				}
 				tempy = ty + N;
 				cnt += N;
 			}
 			if(cnt > lcm) {
 				System.out.println(-1);
 			}
 			else {
 				System.out.println(cnt);
 			}
 		}
 	}
 	static int gcd(int a, int b) {
 		while(b != 0) {
 			int r = a % b;
 			a = b;
 			b = r;
 		}
 		return a;
 	}
}
