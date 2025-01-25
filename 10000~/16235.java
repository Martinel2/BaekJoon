package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class T implements Comparable<T>{
		int x;
		int y;
		int age;
		
		T(int x, int y, int age){
			this.x=x;
			this.y=y;
			this.age=age;
		}

		@Override
		public int compareTo(T o) {
			return this.age-o.age;
		}
	}
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int n,m,k;
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][n];
        for(int i = 0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j<n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        PriorityQueue<T> tree = new PriorityQueue<>();
        Queue<T> q = new LinkedList<>();
        Queue<T> sex = new LinkedList<>();
        
        for(int i = 0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken())-1;
        	int y = Integer.parseInt(st.nextToken())-1;
        	int age = Integer.parseInt(st.nextToken());
        	
        	tree.add(new T(x,y,age));
        }
        
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++) {
        	Arrays.fill(board[i], 5);
        }
        
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        //나무 자라기
        while(k-->0 && tree.size() > 0) {
        	//봄
            PriorityQueue<T> backup = new PriorityQueue<>();
        	while(!tree.isEmpty()) {
        		T t = tree.poll();
        		//System.out.println(t.x+" "+t.y+" "+t.age);
        		if(t.age <= board[t.x][t.y]) {
        			board[t.x][t.y] -= t.age;
        			t.age++;
        			if(t.age % 5 == 0) sex.add(t);
        			backup.add(t);
        		}
        		else {
        			q.add(new T(t.x,t.y,t.age/2));
        		}
        	}
        	tree.addAll(backup);
        	//여름
        	while(!q.isEmpty()) {
        		T dead = q.poll();
        		board[dead.x][dead.y] += dead.age;
        	}
        	//가을
        	while(!sex.isEmpty()) {
        		T s = sex.poll();
        		for(int i=0; i<8; i++) {
        			int nx = s.x+dx[i];
        			int ny = s.y+dy[i];
        			if(0<=nx && nx<n && 0<=ny && ny<n) {
        				tree.add(new T(nx,ny,1));
        			}
        		}
        	}
        	//겨울
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<n; j++) {
        			board[i][j] += arr[i][j];
        		}
        	}
        }
        System.out.print(tree.size());
    }
}
