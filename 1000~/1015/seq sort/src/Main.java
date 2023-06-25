import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1015
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//B[수열[i]] = 배열[i] B[1] = A[0]= 2   B[2] = A[1]= 3 B[0] = A[2]= 1
		// 1 2 3
		int[] arr = new int[N];
		int[] sortarr = new int[N];
		boolean[] comp = new boolean[N];
		int[] idx = new int[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sortarr[i] = arr[i];
		}
		
		Arrays.sort(sortarr);
		//arr[idx[i]] = arr[i]
		int sortidx = 0;
		while(sortidx < N) {
			for(int i = 0; i<N; i++) {
				if(!comp[i] && sortarr[sortidx] == arr[i]) {
					idx[i] = sortidx;
					comp[i] = true;
					sortidx++;
					break;
				}
			}
		}
		
		for(int i : idx) {
			System.out.print(i + " ");
		}
	}
}
