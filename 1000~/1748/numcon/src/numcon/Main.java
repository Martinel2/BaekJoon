package numcon;
import java.io.*;

//1748 수 이어쓰기1
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int n = N;
		int len = String.valueOf(N).length();
		int sum = 0;
		int i = 0;
		while(i < len)
		{
			if(i == len-1) {
				int a = n%10;
				sum += a *(int)(Math.pow(10, i))*(i+1);
				int b = (a+1)*(int)(Math.pow(10, i)) - N-1;
				sum -= b*(i+1);
			}
			else {
				sum += 9 * (int)(Math.pow(10, i))*(i+1);
			}
			n /= 10;
			i++;
		}
		System.out.println(sum);
	}
}