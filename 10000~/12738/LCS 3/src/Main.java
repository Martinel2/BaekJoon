import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nums[] = new int[N];
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이분탐색을 이용한 LIS
		// 필요한 것 
		// 1. LIS 배열
		// 2. LIS size
		
		int[] LIS = new int[N];
		int size = 0;
		
		for(int i=0;i<N;i++) {
			int temp = Arrays.binarySearch(LIS, 0, size, nums[i]);
			if(temp < 0) temp = Math.abs(temp) - 1; // 들어가야 할 위치를 뜻함
			
			LIS[temp] = nums[i];
			
			if(temp == size) {
				size++;
			}
		}
		
		System.out.println(size);
	}
}