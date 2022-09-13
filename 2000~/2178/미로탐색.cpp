#include <stdio.h>
#define MAX 101

char Maze[MAX][MAX];
int ch[MAX][MAX] = {0,};
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int ans=0;
bool visit[MAX][MAX] = {false};

void DFS(int N, int M, int x, int y)
{
	int nx,ny;
	visit[x][y] = true;
	if(x == N-1 && y == M-1)
	{	
		if(ans > (ch[x][y])|| ans == 0)
			ans = (ch[x][y]);
		return;
	}
	for(int i =0; i<4; i++)
	{
		nx = x+dx[i];
		ny = y+dy[i];
		if(0<=nx && nx<N && 0<=ny && ny<M){
			if( (Maze[nx][ny] == '1' && visit[nx][ny] == false) 
			|| (Maze[nx][ny] == '1' && (ch[x][y]+1 < ch[nx][ny])))
			{
				ch[nx][ny] = ch[x][y] + 1;
				DFS(N,M,nx,ny);
			}
		}
			
	}
}

int main()
{
	
	int N,M;
	scanf("%d %d", &N, &M);
	
	for(int i  = 0; i<N; i++)
	{
		scanf("%s", &Maze[i]);
	}
	ch[0][0] = 1;
	DFS(N, M, 0, 0);

	printf("%d", ans);
	
	return 0;
}
