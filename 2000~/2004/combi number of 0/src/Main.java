import java.io.*;
import java.util.*;
import java.math.BigInteger;

//2004 조합 0의 개수
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		BigInteger res = new BigInteger("0");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int tmp = N - M;
		M = M > tmp ? tmp : M;
		BigInteger upper = new BigInteger("1");
		BigInteger down = new BigInteger("1");
		tmp = M;
		for (int i = 0; i < tmp; i++) {
			upper = upper.multiply(new BigInteger(String.valueOf(N - i)));
			down = down.multiply(new BigInteger(String.valueOf(M - i)));
		}
		res = upper.divide(down);
		String s = res.toString();
		int cnt = 0;
		for(int i = s.length()-1; i>=0; i--) {
			if(s.charAt(i) == '0')
				cnt++;
			else
				break;
		}
		System.out.println(cnt);
	}
}
