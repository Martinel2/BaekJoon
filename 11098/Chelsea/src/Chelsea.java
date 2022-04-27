import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class Chelsea {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		int n = Integer.parseInt(reader.readLine());
		int pi = 0;
		for(int i =0; i<n; i++)
		{
			int p = Integer.parseInt(reader.readLine());
			String[][] S = new String[p][2];
			int max = 0;
			for(int j = 0; j<p; j++)
			{
				S[j] = reader.readLine().split(" ");
				if(max < Integer.valueOf(S[j][0]))
				{
					max = Integer.valueOf(S[j][0]);
					pi = j;
				}
			}
			ans.append(S[pi][1] + "\n");
			
		}
		System.out.println(ans);
	}
}