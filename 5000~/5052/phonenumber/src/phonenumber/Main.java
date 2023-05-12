package phonenumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	static class Node {
	    HashMap<Character, Node> child;
	    boolean isTerminal;

	    public Node(){
	        this.child = new HashMap<>();
	        this.isTerminal = false;
	    }
	}

	static class Trie {
	    Node root; // 최상단 노드
	    public Trie() {
	        this.root = new Node();
	    }

	    public boolean insert(String str) { // 삽입
	        Node cur = this.root;
	        boolean complete = true;
	        for (int i = 0; i < str.length(); i++) {
	        	// 삽입되는 문자열의 문자 하나하나씩 가져온다.
	            char c = str.charAt(i); 
	            // 노드로 구성된 문자열이 꼬리에 꼬리를 무는 부분!
	            if(cur.child.putIfAbsent(c, new Node()) != null){
	            	cur = cur.child.get(c);
	            	 // 만일 이미 다른 전화번호가 눌린다면
		            if(cur.isTerminal) {
		            	complete = false;
		            }
		            // 반복문 끝에 도달하면 true로 바꿔준다.
		            if (i == str.length() - 1) { 
		                cur.isTerminal = true;
		                complete = false;
		            }
	            }
	            else {
	            	cur = cur.child.get(c);
	            	// 반복문 끝에 도달하면 true로 바꿔준다.
		            if (i == str.length() - 1) { 
		                cur.isTerminal = true;
		            }
	            }
	        }
	        return complete;
	    }
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			Trie num = new Trie();
			boolean flag = true;
			for(int i = 0; i<N; i++) {
				String s = br.readLine();
				if(!num.insert(s)) {
					flag = false;
				}
			}
			if(flag)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.println(sb);
	}
}
//tree