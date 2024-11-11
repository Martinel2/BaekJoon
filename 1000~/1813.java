package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static String s;
    static int len;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[51];
        
        st=new StringTokenizer(br.readLine());
        
        for(int i = 0; i<n; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	arr[num]++;
        }
        
        int ans = -1;
        for(int i = 50; i>=0; i--) {
        	if(arr[i] == i) {
        		ans = i;
        		break;
        	}
        }
        System.out.println(ans);
    }
}
