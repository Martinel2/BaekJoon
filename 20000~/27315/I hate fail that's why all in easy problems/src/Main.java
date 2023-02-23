import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//27315 틀리는건 싫으니까 쉬운 문제에 올인하려고 합니다
public class Main {
	//문제 클래스
	static class P{
		int IQ,EQ;
		
		P(int IQ, int EQ){
			this.IQ = IQ;
			this.EQ = EQ;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<P> Dq = new PriorityQueue<P>(new Comparator<P>() {
			@Override
			public int compare(P o1, P o2) {
				return o1.IQ-o2.IQ;
			}
		}); // 아이디어 난이도 순
		PriorityQueue<P> Pq = new PriorityQueue<P>(new Comparator<P>() {
			@Override
			public int compare(P o1, P o2) {
				return o1.EQ-o2.EQ;
			}
		}); // 구현 난이도 순
		int N,M;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //전체 문제
		M = Integer.parseInt(st.nextToken()); // 풀어야할 문제 수
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int d,p,t,e;
			d = Integer.parseInt(st.nextToken()); // 아이디어 난이도
			p = Integer.parseInt(st.nextToken()); // 구현 난이도
			t = Integer.parseInt(st.nextToken()); // 데이터 여부
			e = Integer.parseInt(st.nextToken()); // 에디토리얼 여부
			if(t == 1) //데이터가 있으면 무조건 맞춤
				p = 0;
			//에디토리얼을 이해하려면 < 한별IQ >= 문제의 아이디어 난이도/2 >
			if(e == 1) {
				d = (int)Math.ceil((double)d/2); // 문제의 아이디어 난이도/2 <= 가장큰 정수
				p = (int)Math.floor((double)p/2);
			}
			Dq.add(new P(d,p));
		}
		int Hd=1,Hp=1;
		st = new StringTokenizer(br.readLine());
		Hd = Integer.parseInt(st.nextToken()); // 한별의 아이디어능력
		Hp = Integer.parseInt(st.nextToken()); // 한별의 구현능력

		boolean clear = true; //M개의 문제를 풀수있는가
		long fail = 0; // 틀렸습니다 갯수
		
		while(M > 0){
			
			while(!Dq.isEmpty()) { //문제가 남아있을때,
				P cur = Dq.poll();
				if(cur.IQ <= Hd) //문제의 아이디어 난이도 <= 한별의 아이디어 능력
					Pq.add(cur); // 구현순으로 정렬하기 위해 추가
				else {
					Dq.add(cur); // 풀지못하므로 보류
					break;
				}
			}
			/*
			for(P val : Pq)
				System.out.println(val.IQ+"  "+val.EQ);
			System.out.println();
			*/
			if(Pq.isEmpty()){ // 풀수있는 문제가 없으면
				clear = false; // M개의 문제를 풀지 못한것
				break;
			}
			
			P tmp = Pq.poll();
			int Iq = tmp.IQ;
			int Eq = tmp.EQ;
			
			if(Eq > Hp) // 구현난이도 > 한별의 구현 능력
				fail += Eq-Hp; 
			Hd++; Hp++; //1씩 증가
			M--;
		}
		if(clear)
			System.out.print(fail);
		else
			System.out.print(-1);
	}
}
