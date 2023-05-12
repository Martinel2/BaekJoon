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
	    Node root; // �ֻ�� ���
	    public Trie() {
	        this.root = new Node();
	    }

	    public boolean insert(String str) { // ����
	        Node cur = this.root;
	        boolean complete = true;
	        for (int i = 0; i < str.length(); i++) {
	        	// ���ԵǴ� ���ڿ��� ���� �ϳ��ϳ��� �����´�.
	            char c = str.charAt(i); 
	            // ���� ������ ���ڿ��� ������ ������ ���� �κ�!
	            if(cur.child.putIfAbsent(c, new Node()) != null){
	            	cur = cur.child.get(c);
	            	 // ���� �̹� �ٸ� ��ȭ��ȣ�� �����ٸ�
		            if(cur.isTerminal) {
		            	complete = false;
		            }
		            // �ݺ��� ���� �����ϸ� true�� �ٲ��ش�.
		            if (i == str.length() - 1) { 
		                cur.isTerminal = true;
		                complete = false;
		            }
	            }
	            else {
	            	cur = cur.child.get(c);
	            	// �ݺ��� ���� �����ϸ� true�� �ٲ��ش�.
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