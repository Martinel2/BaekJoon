package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    
	static boolean notable(int x, int y) {
		if((x==0 && y == 5) || (x==1 && y==4) || (x==2 && y==3)) return true;
		else return false;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        //합이 최소이더라도 사용이 불가능한 조합
        //A-F, B-E, C-D
        //위 조합이 포함되지 않으면서 최소인 값만 사용하면 됨
        //하나의 면을 기준으로 본다면 각 면의 모서리 부분만 세 수의 합, 두 수의 합의 최소를 사용
        //중앙에 세우는 주사위는 그냥 최소값을 앞면으로 두면 됨
        //3면이 만나는 4개의 주사위 - 3변의 합의 최소값
        //2면을 사용하는 (N-2)*8개의 주사위 - 2변의 합의 최소값
        //1면만 보이는 나머지 주사위 - 가장 최소값
        long n = Long.parseLong(br.readLine());
        
        int[] dice = new int[6];

        if(n == 1) {
        	int sum = 0;
        	int max = 0;
        	st = new StringTokenizer(br.readLine());
	        for(int i = 0; i<6; i++) {
	        	dice[i] = Integer.parseInt(st.nextToken());
	        	sum += dice[i];
	        	max = Math.max(max, dice[i]);
	        }
	        System.out.println(sum-max);
        }
        else {
	        int min = Integer.MAX_VALUE;
	        int min2 = Integer.MAX_VALUE;
	        int min3 = Integer.MAX_VALUE;
	        
	        long n2 = 4*(n+n-3);
	        
	        //n=2,0 n=3,2 n=4,6  ... n=k, (k-1)*(k-2)
	        long n3 = (n-1)*(n-2)*4 + (n-2)*(n-2);
	
	        st = new StringTokenizer(br.readLine());
	        for(int i = 0; i<6; i++) {
	        	dice[i] = Integer.parseInt(st.nextToken());
	        	min = Math.min(min, dice[i]);
	        }
	        
	        for(int i =0; i<5; i++) {
	        	for(int j = i+1; j<6; j++) {
	        		if(notable(i,j)) continue;
	        		min2 = Math.min(min2, dice[i]+dice[j]);
	        		for(int k = j+1; k<6; k++) {
	        			if(notable(i,k) || notable(j,k)) continue;
	            		min3 = Math.min(min3, dice[i]+dice[j]+dice[k]);
	        		}
	        	}
	        }
	        //System.out.println((min3) + " "+ (min2) + " " + (min) );
	        BigInteger ans = new BigInteger("0");
	        ans = ans.add(new BigInteger(Integer.toString(min3)).multiply(new BigInteger("4")));
	        
	        ans = ans.add(new BigInteger(Integer.toString(min2)).multiply(new BigInteger(Long.toString(n2))));
	        
	
	        ans = ans.add(new BigInteger(Integer.toString(min)).multiply(new BigInteger(Long.toString(n3))));
	        //long ans = (min3 * 4) + (min2 * n2) + (min * n3);
	        System.out.println(ans);
        }
    }
}

/*
4
10 8 4 6 7 4

332 -correct
*/

//    6
// 7 10 8 4 
//    4