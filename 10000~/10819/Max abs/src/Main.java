import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] change = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int max = 0;
		if(N==3) {
			max = Math.abs(arr[0]-arr[2])+Math.abs(arr[2]-arr[1]);
		}
		else {
			int small = 0;
			int big = arr.length-1;
			change[0] = arr[N/2];
			for(int i = 1; i<N; i++) {
				if(i % 2 == 0){
					change[i] = arr[big];
					big--;
				}
				else {
					change[i] = arr[small];
					small++;
				}
			}
			for(int i=0; i+1<N; i++) {
				max += Math.abs(change[i]-change[i+1]);
			}
		}
		System.out.println(max);
	}
}
