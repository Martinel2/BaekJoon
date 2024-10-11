package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        for (int i = n - 1; i >= 1; i--) {
            switch (str[i]) {
                case 'A':
                    switch (str[i - 1]) {
                        case 'A':
                            str[i - 1] = 'A'; break;
                        case 'G':
                            str[i - 1] = 'C'; break;
                        case 'C':
                            str[i - 1] = 'A'; break;
                        case 'T':
                            str[i - 1] = 'G'; break;
                    }
                    break;

                case 'G':
                    switch (str[i - 1]) {
                        case 'A':
                            str[i - 1] = 'C'; break;
                        case 'G':
                            str[i - 1] = 'G'; break;
                        case 'C':
                            str[i - 1] = 'T'; break;
                        case 'T':
                            str[i - 1] = 'A'; break;
                    }
                    break;

                case 'C':
                    switch (str[i - 1]) {
                        case 'A':
                            str[i - 1] = 'A'; break;
                        case 'G':
                            str[i - 1] = 'T'; break;
                        case 'C':
                            str[i - 1] = 'C'; break;
                        case 'T':
                            str[i - 1] = 'G'; break;
                    }
                    break;

                case 'T':
                    switch (str[i - 1]) {
                        case 'A':
                            str[i - 1] = 'G'; break;
                        case 'G':
                            str[i - 1] = 'A'; break;
                        case 'C':
                            str[i - 1] = 'G'; break;
                        case 'T':
                            str[i - 1] = 'T'; break;
                    }
                    break;
            }
        }

        System.out.println(str[0]);
    }
}
