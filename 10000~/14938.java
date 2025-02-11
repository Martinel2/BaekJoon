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
        int range = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        int[] item = new int[v];
        int[] get = new int[v];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<v; i++) {
        	item[i] = Integer.parseInt(st.nextToken());
        	get[i] += item[i];
        }
        
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

			if(arr[b-1][a-1] > range && c <= range) get[b-1] += item[a-1];
			if(arr[a-1][b-1] > range && c <= range) get[a-1] += item[b-1];
			arr[a-1][b-1] = Math.min(arr[a-1][b-1], c);
			arr[b-1][a-1] = Math.min(arr[b-1][a-1], c);
			}
		int ans = 0;
		
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				for(int k=0; k<v; k++) {
                    if (arr[j][i] == Integer.MAX_VALUE || arr[i][k] == Integer.MAX_VALUE)
						continue;
					int weight = arr[j][i] + arr[i][k];
					if(arr[j][k] > range && weight <= range) get[j] += item[k];
					arr[j][k] = Math.min(arr[j][k], weight);
				}
				ans = Math.max(get[j], ans);
				//System.out.println(ans+ " "+j);
			}
		}
		System.out.println(ans);
	}
}