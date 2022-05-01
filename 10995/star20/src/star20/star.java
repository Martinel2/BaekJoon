package star20;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class star {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		
		int N =Integer.parseInt(reader.readLine());
		
		for(int i=1; i<=N; i++)
		{
			if(i%2 !=0)
			{
				for(int j = 0; j<N; j++)
				{
					st.append("* ");
				}
				st.append("\n");
			}
			else
			{
				for(int j = 0; j<N; j++)
				{
					st.append(" *");
				}
				st.append("\n");
			}
		}
		System.out.println(st);
	}
}
