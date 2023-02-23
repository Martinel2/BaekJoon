import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//27315 Ʋ���°� �����ϱ� ���� ������ �����Ϸ��� �մϴ�
public class Main {
	//���� Ŭ����
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
		}); // ���̵�� ���̵� ��
		PriorityQueue<P> Pq = new PriorityQueue<P>(new Comparator<P>() {
			@Override
			public int compare(P o1, P o2) {
				return o1.EQ-o2.EQ;
			}
		}); // ���� ���̵� ��
		int N,M;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //��ü ����
		M = Integer.parseInt(st.nextToken()); // Ǯ����� ���� ��
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int d,p,t,e;
			d = Integer.parseInt(st.nextToken()); // ���̵�� ���̵�
			p = Integer.parseInt(st.nextToken()); // ���� ���̵�
			t = Integer.parseInt(st.nextToken()); // ������ ����
			e = Integer.parseInt(st.nextToken()); // �����丮�� ����
			if(t == 1) //�����Ͱ� ������ ������ ����
				p = 0;
			//�����丮���� �����Ϸ��� < �Ѻ�IQ >= ������ ���̵�� ���̵�/2 >
			if(e == 1) {
				d = (int)Math.ceil((double)d/2); // ������ ���̵�� ���̵�/2 <= ����ū ����
				p = (int)Math.floor((double)p/2);
			}
			Dq.add(new P(d,p));
		}
		int Hd=1,Hp=1;
		st = new StringTokenizer(br.readLine());
		Hd = Integer.parseInt(st.nextToken()); // �Ѻ��� ���̵��ɷ�
		Hp = Integer.parseInt(st.nextToken()); // �Ѻ��� �����ɷ�

		boolean clear = true; //M���� ������ Ǯ���ִ°�
		long fail = 0; // Ʋ�Ƚ��ϴ� ����
		
		while(M > 0){
			
			while(!Dq.isEmpty()) { //������ ����������,
				P cur = Dq.poll();
				if(cur.IQ <= Hd) //������ ���̵�� ���̵� <= �Ѻ��� ���̵�� �ɷ�
					Pq.add(cur); // ���������� �����ϱ� ���� �߰�
				else {
					Dq.add(cur); // Ǯ�����ϹǷ� ����
					break;
				}
			}
			/*
			for(P val : Pq)
				System.out.println(val.IQ+"  "+val.EQ);
			System.out.println();
			*/
			if(Pq.isEmpty()){ // Ǯ���ִ� ������ ������
				clear = false; // M���� ������ Ǯ�� ���Ѱ�
				break;
			}
			
			P tmp = Pq.poll();
			int Iq = tmp.IQ;
			int Eq = tmp.EQ;
			
			if(Eq > Hp) // �������̵� > �Ѻ��� ���� �ɷ�
				fail += Eq-Hp; 
			Hd++; Hp++; //1�� ����
			M--;
		}
		if(clear)
			System.out.print(fail);
		else
			System.out.print(-1);
	}
}
