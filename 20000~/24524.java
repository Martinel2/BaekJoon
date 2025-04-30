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
    	
    	String S = br.readLine();
        String T = br.readLine();
        int n = S.length();
        int m = T.length();

        int[] count = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (S.charAt(i) == T.charAt(j) && (j == 0 || count[j] < count[j - 1])) {
                    count[j] += 1;
                } else if (count[j] == 0) {
                    break;
                }
            }
        }

        System.out.println(count[m - 1]);
    }
    
}
