package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main { 
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
       
        int n = Integer.parseInt(br.readLine());
        
        // Initialize result as 40320 (which is 8!)
        BigInteger ans = new BigInteger("40320");

        for (int i = 9; i <= n; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));

            // Remove trailing zeros
            while (ans.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
                ans = ans.divide(BigInteger.TEN);
            }

            // Keep only the last 13 digits
            if (ans.toString().length() > 13) {
                String strAns = ans.toString();
                ans = new BigInteger(strAns.substring(strAns.length() - 13));
            }
        }

        // Print the last 5 digits
        String result = ans.toString();
        System.out.println(result.length() > 5 ? result.substring(result.length() - 5) : result);
    }
}