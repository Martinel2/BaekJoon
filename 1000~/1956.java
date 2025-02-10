package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        int arr[][] = new int[v][v];
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				if (i == j)
					arr[i][j] = 0;
				else
					arr[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			arr[a - 1][b - 1] = c;
		}

		// [시작, 끝] = [시작, 중간]+[중간, 끝]
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				for (int k = 0; k < v; k++) {
					if (arr[j][i] == Integer.MAX_VALUE || arr[i][k] == Integer.MAX_VALUE)
						continue;
					arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
				}
			}
		}

		int result = Integer.MAX_VALUE;

		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				if (i == j 
						|| arr[i][j] == Integer.MAX_VALUE 
						|| arr[j][i] == Integer.MAX_VALUE)
					continue;

				if (arr[i][i] != 0)
					arr[i][i] = Math.min(arr[i][i], arr[i][j] + arr[j][i]);
				else
					arr[i][i] = arr[i][j] + arr[j][i];

				result = Math.min(result, arr[i][i]);
			}
		}

		if(result==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}
}