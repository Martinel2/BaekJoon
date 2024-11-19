package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    
	    ArrayList<Integer>[] arr = new ArrayList[n];
	    for(int i = 0; i<n; i++) {
	    	arr[i] = new ArrayList<>();
	    }
	    Queue<Integer> q = new LinkedList<>();
	    
	    
	    for(int i = 0; i<n-2; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int x = Integer.parseInt(st.nextToken())-1;
	    	int y = Integer.parseInt(st.nextToken())-1;
	    	
	    	arr[x].add(y);
	    	arr[y].add(x);

    		//System.out.println(x+" "+y);
	    }
	    
	    //이분 그래프가 주어지고, 이를 찾아내어 두 이분 그래프를 연결하는 문제
	    //하나의 점에서 갈 수 있는 모든 경로에 존재하는 점들은 같은 집합
	    // 도달할 수 없는 점중 하나를 골라서 이으면 무조건 이어짐
	    boolean[] visit = new boolean[n];
    	
	    visit[0] = true;
		q.add(0);
    	while(!q.isEmpty()) {
	    	int now = q.poll();
    		for(int val : arr[now]) {
    			if(!visit[val]) {
    	    		//System.out.println(0+" "+j);
    	    		visit[val] = true;
    				q.add(val);
    			}
    		}
	    }
	    
    	for(int i = 0; i<n; i++) {
    		if(!visit[i]) {
    			System.out.println("1 " + (i+1));
    			break;
    		}
    	}
	}
}