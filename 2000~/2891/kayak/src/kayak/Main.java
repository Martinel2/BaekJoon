package kayak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 2];

		st = new StringTokenizer(br.readLine());
		while ( st.hasMoreTokens() )
			arr[Integer.parseInt(st.nextToken())] = -1;

		st = new StringTokenizer(br.readLine());
		while ( st.hasMoreTokens() )
			arr[Integer.parseInt(st.nextToken())]++;

		for ( int i = 1; i < arr.length; i++ )
		{
			if ( arr[i] < 0 )
			{
				if ( arr[i - 1] > 0 )
				{
					arr[i]++;
					arr[i - 1]--;
				}
				else if ( i <= N && arr[i + 1] > 0 )
				{
					arr[i]++;
					arr[i + 1]--;
				}
			}
		}

		int cnt = 0;
		for ( int i = 0; i < arr.length; i++ )
		{
			if ( arr[i] < 0 )
				cnt++;
		}
		System.out.println(cnt);

	}
}
