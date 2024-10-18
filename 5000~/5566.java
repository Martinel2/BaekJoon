package solved;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n,m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int dis = 1;
        int[] board = new int[n+1];
        for(int i = 1; i<=n; i++) {
        	board[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 1; i<=m; i++) {
        	int num = Integer.parseInt(br.readLine());
        	dis += num;
        	//System.out.println(dis);
        	if(dis >= n) {
        		System.out.println(i);
        		break;
        	}
        	dis += board[dis];
        	if(dis >= n) {
        		System.out.println(i);
        		break;
        	}
        }
        
    }
}