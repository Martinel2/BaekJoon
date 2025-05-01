package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        int[][][] dp = new int[first.length() + 1][second.length() + 1][third.length() + 1];

        for (int i=1;i<=first.length();i++){
            for (int j=1;j<=second.length();j++){
                for (int k=1;k<=third.length();k++){
                    if (first.charAt(i - 1) == second.charAt(j - 1) 
                    		&& second.charAt(j - 1) == third.charAt(k - 1))
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    else
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                }
            }
        }

        System.out.println(dp[first.length()][second.length()][third.length()]);
    	
    }
}
