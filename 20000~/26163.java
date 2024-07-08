package solved;

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int mx = 0;
		int[] v = new int[5];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++)
			v[i] = Integer.parseInt(st.nextToken());

		for (int n = 1; n <= 15; n++)
		{
			for (int a = 0; a <= n; a++)
			{
				for (int b = 0; a + b <= n; b++)
				{
					for (int c = 0; a + b + c <= n; c++)
					{
						for (int d = 0; a + b + c + d <= n; d++)
						{
							int e = n - (a + b + c + d);
							int t = a * 1 + b * 2 + c * 3 + d * 4 + e * 5;
							if ((n <= 3 && t > 10) || t > 15)
								continue;
							mx = Math.max(mx, a * v[0] + b * v[1] + c * v[2] + d * v[3] + e * v[4]);
						}
					}
				}
			}
		}
		
		System.out.println(mx);
	}
}