package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
    
	static void beer(int n) {
		if(n == 0) return;
		else if(n > 1) {
			System.out.println(n + " bottles of beer on the wall, " + n + " bottles of beer.");
			if(n-1 > 1)
				System.out.println("Take one down and pass it around, " + (n-1) + " bottles of beer on the wall.\n");
			else
				System.out.println("Take one down and pass it around, " + (n-1) + " bottle of beer on the wall.\n");
		}
		else {
			System.out.println(n + " bottle of beer on the wall, " + n + " bottle of beer.");
			System.out.println("Take one down and pass it around, no more bottles of beer on the wall.\n");	
		}
		beer(n-1);
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        beer(n);
        if(n > 1) {
        	System.out.println("No more bottles of beer on the wall, no more bottles of beer.\n"
        		+ "Go to the store and buy some more, " + n + " bottles of beer on the wall.");
        }
        else {
        	System.out.println("No more bottles of beer on the wall, no more bottles of beer.\n"
            		+ "Go to the store and buy some more, " + n + " bottle of beer on the wall.");
        }
    }
}