package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        int b,s,d;
        b = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        long sum = 0;
        long dic = 0;
        
        Integer[] bur = new Integer[b];
        Integer[] side = new Integer[s];
        Integer[] drink = new Integer[d];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<b; i++) {
        	bur[i] = Integer.parseInt(st.nextToken());
        	sum+= bur[i];
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<s; i++) {
        	side[i] = Integer.parseInt(st.nextToken());
        	sum += side[i];
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<d; i++) {
        	drink[i] = Integer.parseInt(st.nextToken());
        	sum += drink[i];
        }
        
        Arrays.sort(bur, Collections.reverseOrder());
        Arrays.sort(side, Collections.reverseOrder());
        Arrays.sort(drink, Collections.reverseOrder());
        
        int mIdx = Math.min(Math.min(b, s), d);
        
        for(int i = 0; i<mIdx; i++) {
        	dic += (bur[i] + side[i] + drink[i])*0.9;
        }
        
        for(int i = mIdx; i<b; i++) {
        	dic += bur[i];
        }
        
        for(int i = mIdx; i<s; i++) {
        	dic += side[i];
        }

        for(int i = mIdx; i<d; i++) {
        	dic += drink[i];
        }
        
        System.out.println(sum);
        System.out.println(dic);
    }
}
