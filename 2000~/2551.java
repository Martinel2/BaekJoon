package solved;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        long[] arr = new long[n + 1];
        long[] presum = new long[n + 1];
        long[] powsum = new long[n + 1];
        
        // Read the input array
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextLong();
        }
        
        // Sort the array
        Arrays.sort(arr, 1, n + 1);
        
        // Compute prefix sums and prefix squared sums
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + arr[i];
            powsum[i] = powsum[i - 1] + arr[i] * arr[i];
        }
        
        long MIN = Long.MAX_VALUE;
        
        // Find the optimal position for the first part (first output)
        long ans = MIN;
        int pos = -1;
        for (int k = 1; k <= n; k++) {
            long sum = (long) (k - 1) * arr[k] - presum[k - 1] + presum[n] - presum[k] - (long) (n - k) * arr[k];
            
            if (ans > sum) {
                ans = sum;
                pos = k;
            }
        }
        
        System.out.print(arr[pos] + " ");
        
        // Find the optimal position for the second part (second output)
        ans = MIN;
        pos = -1;
        
        long start = arr[1];
        long end = arr[n];
        
        for (int k = 1; k <= 10000; k++) {
            long sum = powsum[n] - (long) 2 * k * presum[n] + (long) n * k * k;
            
            if (ans > sum) {
                ans = sum;
                pos = k;
            }
        }
        
        System.out.println(pos);
        
        sc.close();
    }
}
