package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		LinkedList<Integer>[] list = new LinkedList[n];
		
		for(int i = 0; i<n; i++) {
			list[i] = new LinkedList<>();
		}
        
        for(int i = 0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken())-1;
        	int b = Integer.parseInt(st.nextToken())-1;
        	
        	list[a].add(b);//앞사람이 뒤에 서야할 사람을 가리키도록
        }
        
        //핵심포인트! 진입차수를 따로 저장해서 사용하는 것
        int[] degree = new int[n];//진입차수
        
        for(int i = 0; i<n; i++) {
        	List<Integer> adj = list[i];
        	for(int j : adj) degree[j]++;//가리키는 사람의 수 더하기
        }
        
        for(int i = 0; i<n; i++) {
        	if(degree[i] == 0) {//앞에서 가리키는 사람이 없는 경우 - 1순위이면
        		q.add(i);//큐에 넣어서 빼기
        	}
        }
        
        while(!q.isEmpty()) {
        	int idx = q.poll();
        	sb.append(idx+1).append(' ');
        	
        	List<Integer> adj = list[idx];//해당 학생보다 뒤에 서야할 학생체크
        	for(int node : adj) {
        		degree[node]--;
        		if(degree[node] == 0) q.add(node);//앞사람이 사라지면 자기가 1순위인 경우
        	}
        }
        
        System.out.println(sb);
    }
}
