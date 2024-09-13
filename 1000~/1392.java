package solved;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main { 
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> al = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i<=n; i++) {
        	int music = Integer.parseInt(br.readLine());
        	for(int j = 0; j<music; j++) {
        		al.add(i);
        	}
        }
        
        for(int i = 0; i<q; i++) {
        	int num = Integer.parseInt(br.readLine());
        	sb.append(al.get(num)).append('\n');
        }
        
        System.out.println(sb);
    }
}