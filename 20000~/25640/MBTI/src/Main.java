import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//25640
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String me = br.readLine();
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			if(me.equals(s))
				cnt++;
		}
		
		System.out.println(cnt);
	}
}
