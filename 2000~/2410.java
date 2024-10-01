package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		//1 : 1
		//2 : 11, 2
		//3 : 111, 21
		//4 : 1111, 211, 22, 4
		//5 : 11111, 2111, 221, 41
		//6 : 111111, 21111, 2211, 411, 222, 42
		//8 : 11111111,2111111,221111,41111,22211,4211,2222,422,44,8
				
		long[] arr = new long[1000001];
		arr[1] = 1;
		arr[2] = 2;

		for (int i =3; i <1000001; i++) {
			if(i%2==0) {
				arr[i]=(arr[i-1]+arr[i/2])%1000000000;
			}else {
				arr[i]=arr[i-1];
			}
		}
		
		System.out.println(arr[n]);
	}
}