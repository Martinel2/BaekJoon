package combination;
import java.math.BigInteger;
import java.util.Scanner;

//2407 а╤гу
public class Main {
	public static void main(String[] args) {
		BigInteger res = new BigInteger("0");
		int N, M;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
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
		System.out.println(res);
	}
}
