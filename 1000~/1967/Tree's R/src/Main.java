import java.io.*;
import java.util.*;

//1967 트리의 지름 
public class Main {
	
	public static class Node{
		int v,d;
		public Node(int v, int d) {
			this.v=v;
			this.d=d;
		}
	}
	
	public static class Dis{
		int u, dsum;
		public Dis(int u, int dsum) {
			this.u=u;
			this.dsum=dsum;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		List<List<Node>>tree = new ArrayList<>();
		for(int i = 1; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int par = Integer.parseInt(st.nextToken())-1;
			int child = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			tree.get(par).add(new Node(child,weight));
			tree.get(child).add(new Node(par,weight));
		}
		
		int dsum,dmax=0,s=0,u,ver,edg;
		boolean visit[];
		Deque<Dis> d;
		for(int i = 0; i< 2; i++) {
			visit = new boolean[n];
			d = new ArrayDeque<>();
			dsum = 0;
			visit[s] = true;
			d.add(new Dis(s,0));
			while(!d.isEmpty()) {
				Dis dis = d.remove();
				u = dis.u; dsum = dis.dsum;
				if(dmax < dsum) {
					dmax = dsum;
					s = u;
				}
				for(Node nd : tree.get(u)) {
					ver = nd.v; edg = nd.d;
					if(!visit[ver]) {
						visit[ver] = true;
						d.add(new Dis(ver,edg+dsum));
					}
				}
			}
		}
		System.out.println(dmax);
	}
}
