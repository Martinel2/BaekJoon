import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static boolean comp(String A, String B) {
		int Alen = A.length();
		int Blen = B.length();
		if(Alen != Blen)
		{
			if(Alen < Blen)
				return false;
			else
				return true;
		}
		else {
			int a = 0;
			int b = 0;
			for(int i = 0; i<Alen; i++) {
				char Ca = A.charAt(i);
				char Cb = B.charAt(i);
				if('0' <= Ca && Ca <= '9') {
					a += Ca-'0';
				}
				if('0' <= Cb && Cb <= '9') {
					b += Cb-'0';
				}
			}
			if(a == b) {
				for(int i = 0; i<Alen; i++) {
					if(A.charAt(i) < B.charAt(i))
						return false;
					else if(A.charAt(i) > B.charAt(i))
						return true;
				}
				return false;
			}
			else {
				if(a < b)
					return false;
				else return true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for(int i = 0; i<N; i++) {
			arr[i] = br.readLine();
		}
		for(int i = N-1; i>0; i--) {
			for(int j = 0; j<i; j++) {
				if(comp(arr[j], arr[j+1])) {
					String tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		for(String val : arr) {
			System.out.println(val);
		}
	}
}
 