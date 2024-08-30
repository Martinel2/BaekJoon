package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        boolean[] che = new boolean[318138];
        che[1] = true;
        for(int i = 2; i<318138; i++) {
        	if(!che[i]) {
        		for(int j = 2; i*j<318138; j++) {
        			che[i*j] = true;
        		}
        	}
        }
        
        int[] prime = new int[3001];
        int k = 1;
        int idx = 1;
        
        for(int i = 2; i<318138; i++) {
        	if(!che[i]) { //소수중에서
        		if(!che[k]) //k번째로 작은 소수이면(k가 소수)
        			prime[idx++] = i; //슈퍼소수배열에 저장
        		if(idx > 3000) break;
        		k++;
        	}
        }
        
        int t = Integer.parseInt(br.readLine());
        
        //k도 소수, 2,3,5,7,9...
        //n번째로 작은 슈퍼소수를 구하라
        while(t-->0) {
        	int n = Integer.parseInt(br.readLine());
        	sb.append(prime[n]).append('\n');
        }
        System.out.println(sb);
    }
}