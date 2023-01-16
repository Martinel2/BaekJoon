import java.io.*;
import java.util.*;

//1269 대칭 차집합
public class Main {
	//(A-B)+(B-A) ==> 공통된 원소의 갯수를 합집합에서 두번 빼기
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Set<Integer> s = new HashSet<>();
		st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int cha = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<A; i++) {
			int el = Integer.parseInt(st.nextToken());
			s.add(el);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<B; i++) {
			int el = Integer.parseInt(st.nextToken());
			if(s.contains(el)) {
				cha++;
			}
		}
		System.out.println( (A+B) - (2*cha) );
	}
}
