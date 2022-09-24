import java.io.*;

//1904 01≈∏¿œ
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int div = 15746;
		
		int N = Integer.parseInt(br.readLine());
		int[] sig = new int[N];
		sig[0] = 1;
		sig[1] = 2;
		for(int i = 2; i<N; i++) {
			sig[i] = (sig[i-1] + sig[i-2])%div;
		}
		for(int val : sig)
			System.out.print(val + " ");
		System.out.println(sig[N-1]);
		
	}
}