package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int b,p;
        b= -Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        
        while(b != 0 || p != 0) {
        	int ans = 0;
        	
        	int[] trees = new int[b+1];
        	trees[0] = p;
        	trees[b] = -p;
        	//다리 정보
        	int[][] bridge = new int[b][2];
        	//건너는 그룹정보
        	int[][] group = new int[b][2];
        	
        	
        	for(int i = 0; i<b; i++) {
        		st = new StringTokenizer(br.readLine());
        		bridge[i][0] = Integer.parseInt(st.nextToken());
        		bridge[i][1] = Integer.parseInt(st.nextToken());
        	}
        	
        	while(trees[b] < 0) { //모두 건널 때 까지
        		int time = Integer.MAX_VALUE;
        		for(int i=0; i<b; i++) {
        			//기다리는 사람이 있고, 다리가 비어있다면
        			if(trees[i] > 0 && group[i][0] == 0) {
        				group[i][0] = Math.min(trees[i], bridge[i][0]);
        				group[i][1] = bridge[i][1];
        				trees[i] -= group[i][0]; //건너는 사람 수 만큼 기다리는 사람 수 제거 
        			}
        			if(group[i][1] > 0) {
        				time = Math.min(group[i][1], time);
        			}
        		}
        		
        		ans += time;
        		
        		for(int i=0; i<b; i++) {
        			if(group[i][1] > 0) {
        				group[i][1] -= time;
        				if(group[i][1] == 0) { //다리를 모두 건넌 경우
        					trees[i+1] += group[i][0];
        					group[i][0] = 0;
        				}
        			}
        		}
        	}
        	
        	sb.append(ans).append('\n');
        	
        	st = new StringTokenizer(br.readLine());
            
        	b= -Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());	
        }
        System.out.println(sb);
    }
}
