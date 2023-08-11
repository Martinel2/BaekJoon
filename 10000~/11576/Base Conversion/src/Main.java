import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int A,B;
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int num10 = 0; 
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = N-1; i>=0; i--) {
			int aNum = Integer.parseInt(st.nextToken());
			num10 += aNum * Math.pow(A, i);
		}
		
		Stack<Integer> convert = new Stack<>();
		while(num10 > 0) {
			int con = num10 % B;
			if(con == 0) {
				con = num10 / B;
				while(con > 0) {
					convert.add(con%10);
					con/=10;
				}
				break;
			}
			convert.add(con);
			num10 -= con; 
			//System.out.println(num10);
		}
		
		while(!convert.isEmpty()) {
			sb.append(convert.pop()).append(" ");
		}
		System.out.println(sb);
	}
}
