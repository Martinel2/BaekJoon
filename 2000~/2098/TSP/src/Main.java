import java.io.*;
import java.util.*;


//2098 ���ǿ� ��ȸ(TSP)
public class Main {
	
	static int N;
	static int[][] town;
	static int[][] dp;
	/*  �ð��ʰ�
		static void backtracking(int cnt, int m, int x)//������ ���� ��,����ġ��,����� ������ ����
	{
		if(cnt == N) {
			if(min>m)
				min = m;
			return;
		}
		
		for(int j = 0; j<N; j++)
		{
			if(cnt==j || (x == cnt && (visit[j] || j==0)) )
				continue;
			if(!visit[j])
			{
				visit[j] = true;
				backtracking(cnt+1, m+town[cnt][j],j);
				visit[j] = false;
			}
		}
		
	}
	*/
	static int bit(int now, int dis)
	{
		if(dp[now][dis] != -1) //�̹� �湮������
			return dp[now][dis];
		else if(dis == (1<<N) -1)
		{
			if(town[now][0] != 0)
				return dp[now][dis] = town[now][0];
			else 
				return dp[now][dis] = 987654321;
		}

		else
		{
			dp[now][dis] = 987654321;
			for(int i = 0; i<N; i++)
			{
				if(town[now][i] == 0)//���� ����
					continue;
				if( (dis & (1<<i)) == (1<<i))//�̹� �湮
					continue;
				
				int m = bit(i, dis | (1<<i) ) + town[now][i] ;
				dp[now][dis] = Math.min(dp[now][dis], m);
			}
			return dp[now][dis];
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());//������ ��
		town = new int[N][N];
		dp = new int[N][1<<N];
		for(int i = 0; i<N; i++)//���� ����ġ �ޱ�
		{
			Arrays.fill(dp[i], -1);
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++)
				town[i][j] = Integer.parseInt(st.nextToken());
		}
	
		//backtracking(0,0,-1);
		System.out.print(bit(0,1));
	}
}
