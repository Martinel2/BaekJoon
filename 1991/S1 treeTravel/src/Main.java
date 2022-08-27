import java.io.*;
import java.util.*;

// 1991 트리순회
public class Main {
	public static class node{
		String data = "null";
		node llink;
		node rlink;
		
		node(String data)
		{
			this.data = data;
			this.llink = null;
			this.rlink = null;
		}
		
		
	}
	static void search(node e)
	{
		
			if(e.data.equals(data)) {
				if(!lchild.equals("."))
					e.llink = new node(lchild);
				if(!rchild.equals("."))
					e.rlink = new node(rchild);
				return;
			}
			
			if(e.llink != null)
				search(e.llink);
			if(e.rlink != null)
				search(e.rlink);
			
			/*
			if(e.llink != null) {
				if(e.llink.data.equals(data)) {
					e.llink = mark;
					mark.data = data;
					return;
				}
				search(e.llink,mark,data);
			}
			if(e.rlink !=null) {
				if(e.rlink.data.equals(data)) {
					e.rlink = mark;
					mark.data = data;
					return;
				}
				search(e.rlink,mark,data);
			}
			*/
	}
	static void preorder(node e) {

		System.out.print(e.data);
		if(e.llink != null)
			preorder(e.llink);
		if(e.rlink != null)
			preorder(e.rlink);
		
	}
	static void inorder(node e) {
	
		if(e.llink != null)
			inorder(e.llink);
		System.out.print(e.data);
		if(e.rlink != null)
			inorder(e.rlink);
		
	}
	static void postorder(node e) {
	
		if(e.llink != null)
			postorder(e.llink);
		if(e.rlink != null)
			postorder(e.rlink);
		System.out.print(e.data);
		
	}
	
	static String data = "";
	static String lchild = "";
	static String rchild = "";
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		node root = new node("A");
		for(int i = 0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			
			data = st.nextToken();
			lchild = st.nextToken();
			rchild = st.nextToken();
			search(root);
		}
		
		preorder(root);
		System.out.print("\n");
		inorder(root);
		System.out.print("\n");
		postorder(root);
	}
}
