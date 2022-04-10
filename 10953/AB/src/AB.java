import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;

public class AB {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		
		int T = Integer.parseInt(reader.readLine());
		
		for(int i =0; i<T; i++)
		{
			String[] temp = reader.readLine().split(",");
			int A = Integer.parseInt(temp[0]);
			int B = Integer.parseInt(temp[1]);
			st.append(A+B + "\n");
		}
		System.out.println(st);
	}
	
	
}
