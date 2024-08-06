package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());
        
        char[] arr;
        String[] s = new String[n];
        
        for(int i = 0; i<n; i++) {
        	arr = br.readLine().toCharArray();
        	Arrays.sort(arr);
        	s[i] = "";
        	for(int j = 0; j<m; j++) {
        		s[i]+= arr[j];
        	}
        }
        Arrays.sort(s);
        int[] alpa = new int[26];
        for(int i = 0; i<k; i++) {
        	String word = s[i];
        	for(int j = 0; j<m; j++) {
        		alpa[word.charAt(j)-'A']++;
        	}
        }
        
        for(int i = 0; i<26; i++) {
        	for(int j = 0; j<alpa[i]; j++) {
        		System.out.print((char)(i+'A'));
        	}
        }    
    }
}