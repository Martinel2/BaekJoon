package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	static List<Integer> init(final int g) {
        List<Integer> sq = new ArrayList<>();
        int bf = 0;
        for (int i = 1; i*i-bf*bf <= g; i++) sq.add(bf = i);
        return sq;
    }
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        //G = n^2 - m^2 16-1 = 15, 
        int g = Integer.parseInt(br.readLine());
        
        List<Integer> square = init(g);
        
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int cur : square) {
            set.add(cur*cur);
            if (!set.contains(cur*cur-g)) continue;
            sb.append(cur).append('\n');
            cnt++;
        }
        System.out.print(cnt==0?-1:sb);
    }
}