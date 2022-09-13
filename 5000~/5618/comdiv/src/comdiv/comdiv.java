package comdiv;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class comdiv {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		String[] num = reader.readLine().split(" ");
		int[] inum = new int[N];
		int i,j;
		for(i = 0; i<N; i++)
		{
			inum[i] = Integer.parseInt(num[i]);
		}
		Arrays.sort(inum);
		for(i = 1; i<=inum[0]; i++)
		{
			for(j = 0; j<N; j++)
			{
				if(inum[j]%i != 0)
					break;
			}
			if(j==N)
				System.out.println(i);
		}
	}
}
