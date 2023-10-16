import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            hs.add(arr[i]);
        }

        int min = 4;
        for (int i = 0; i < N-1; i++) {
            int cnt = 1;
            for (int j = arr[i]+1; j < arr[i]+5; j++) {
                if (hs.contains(j))
                    cnt++;
            }
            min = Math.min(min, 5-cnt);
        }
        
        System.out.println(min);
    }
}
