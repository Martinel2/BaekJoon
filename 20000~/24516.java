package solved;

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        
        int n = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= 2 * n - 1; i += 2) {
            System.out.print(i + " ");
        }
    }
}