package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int cnt = 0;
	static boolean[] visit;
	static int[] tree;
	
	public static void deleteNode(int d) {
		tree[d] = -2; //삭제된 노드 -2로 표시
        for(int i = 0; i < N; i++) {
            if(tree[i] == d) {
                deleteNode(i);
            }
        }
    }
	
	static void dfs(int idx) {
		if(tree[idx] == -2)
			return;
		visit[idx] = true;
		boolean child = false;
		for(int i = 0; i<N; i++) {
			if(tree[i] == idx && !visit[i]) {
				child = true;
				dfs(i);
			}
		}
		if(!child)
			cnt++;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		tree = new int[N];
		visit = new boolean[N];
		int root = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(tree[i] == -1)
				root = i;
		}
		int del = Integer.parseInt(br.readLine());
		
		deleteNode(del);
	
		dfs(root);
		
		System.out.println(cnt);
	}
}
