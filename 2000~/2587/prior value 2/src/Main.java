import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//2587
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] a = new int[5];
		double sum = 0;
		for(int i = 0; i<5; i++) {
			a[i] = Integer.parseInt(br.readLine());
			sum += a[i];
		}
		
		Arrays.sort(a);
		System.out.println((int)(sum/5));
		System.out.println(a[2]);
	}
}
