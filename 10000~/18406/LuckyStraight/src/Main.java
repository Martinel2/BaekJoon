import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] n = br.readLine().toCharArray();
		int l = n.length/2;
		
		int left = 0, right = 0;
		
		for(int i = 0; i<l; i++) {
			left += n[i] -'0';
			right += n[i+l] - '0';
		}
		
		if(left == right)
			System.out.println("LUCKY");
		else
			System.out.println("READY");
	}
}
