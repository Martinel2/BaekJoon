import java.io.*;
import java.util.*;

//1138 한줄로 서기
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] ans = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i<N; i++) {
			int index = arr[i];
			for(int count = 0; count<=index; count++) {
				if(ans[count] != 0 && ans[count] < i+1) {
					index++;
				}
			}
			ans[index] = i+1;
		}
		for(int a : ans) {
			System.out.print(a + " ");
		}
	}
}
