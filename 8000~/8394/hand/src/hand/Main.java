package hand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Main {
	  public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        Function<String,Integer> stoi = Integer::parseInt;
	        int n = stoi.apply(br.readLine());
	        int[] dp = new int[n+1];
	        int result = cal(n,dp);
	        System.out.println(result);
	    }

	    private static int cal(int n,int[] dp) {
	        if(n == 0){
	            return 1;
	        }
	        if(dp[n] != 0){
	            return dp[n];
	        }
	        int result = 0;
	        if(n > 1){
	            result += cal(n-2,dp);
	        }
	        result += cal(n-1,dp);
	        result %= 10;
	        dp[n] = result;
	        return result;
	    }
}
