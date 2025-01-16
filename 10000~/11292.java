package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        while(n != 0) {
        	ArrayList<String> al = new ArrayList<>();
        	double max = 0;
        	
        	for(int i = 0; i<n; i++) {
        		st = new StringTokenizer(br.readLine());
        		String name = st.nextToken();
        		double h = Double.parseDouble(st.nextToken());
        		if(h > max) {
        			al.clear();
        			al.add(name);
        			max = h;
        		}
        		else if(h == max)
        			al.add(name);
        	}
        	
        	for(String name : al) sb.append(name).append(" ");
        	sb.append('\n');
        	
        	n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}
