#include <stdio.h>
#include <stdlib.h>
#define MAX 1000

bool visit[MAX] = {false};
int A[MAX][MAX];
int res = 0;

void DFS(int A[MAX][MAX], int N, int u)
{
	visit[u] = true;
	for(int i =0; i<N; i++)
	{
		if(A[u][i] == 1 && visit[i] == false)
		{
			DFS(A,N,i);
		}
	}
}

int main()
{
	int N,M,u,v;
	
	scanf("%d %d", &N, &M);
	
	for(int i =0; i<M; i++)
	{
		scanf("%d %d", &u, &v);
		u-=1;
		v-=1;
		A[u][v] = 1;
		A[v][u] = 1;// 무방향그래프 
	}
	
	for(int i = 0; i<N; i++)
	{
		if(visit[i] == false){
			DFS(A, N, i);
			res++;
		}
	}
	printf("%d", res);
	return 0;
}
