import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[104];
		int[] prime = new int[100];
		arr[0] = true;
		arr[1] = true;
		int idx = 0;
		
		for(int i = 2; i<104; i++) {
			if(arr[i] == false) {
				prime[idx++] = i;
				for(int j = 2; i*j<104; j++) {
					arr[i*j] = true;
				}
			}
		}
		int num=0;
		for(int i = 0; i<idx; i++) {
			if(prime[i]*prime[i+1] > N) {
				num = prime[i]*prime[i+1];
				break;
			}
		}
		
		System.out.println(num);
	}
}
