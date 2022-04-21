import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class CountV {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine());
		String[] a = reader.readLine().split(" ");
		int V = Integer.parseInt(reader.readLine());
		int cnt = 0;
		for(int i = 0; i<N; i++)
		{
			if(V == Integer.parseInt(a[i]))
				cnt++;
		}
		
		System.out.println(cnt);
	}
	
}