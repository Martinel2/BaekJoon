#include <stdio.h>
#include <stdlib.h>
#define MAX 9000000

int front= -1,rear = -1;
int res = 0;
int to[1001][1001];

typedef struct queue{
	int x,y;
}queue;

struct queue Q[MAX];


void push(int x, int y)
{
	rear=(rear+1)%MAX;
	Q[rear].x = x;
	Q[rear].y = y;
}

void pop()
{
	Q[front].x = -1;
	Q[front].y = -1;
}

int size()
{
	return rear - front;	
}

void BFS(int N, int M)
{
	while(rear != front){
		int s = size();
		while(s--)
		{
			front=(front+1)%MAX;
			int x = Q[front].x;
			int y = Q[front].y;
			to[y][x] = 1;
			pop();
			
			if(y+1<N)
				if(to[y+1][x] == 0)
					push(x,y+1);
			if(y-1>=0)	
				if(to[y-1][x] == 0)
					push(x,y-1);
			if(x+1<M)
				if(to[y][x+1] == 0)
					push(x+1,y);
			if(x-1>=0)
				if(to[y][x-1] == 0)
					push(x-1,y);
		}
		res++;
	}
}

int main(){
	
	int M,N;
	scanf("%d %d", &M,&N);
	
	int i,j;
	for(i=0; i<N; i++)
	{
		for(j =0; j<M; j++)
		{
			scanf("%d", &to[i][j]); // 토마토 정보 주어짐 
			if(to[i][j] == 1){
				push(j,i);
			}
		}
	}

	BFS(N,M);
	int a = 0;
	for(i=0; i<N; i++)
	{
		for(j =0; j<M; j++)
		{
			if(to[i][j] == 0)
			{
				a++;
			}
		}
	}
	 
	if(a ==0){
		printf("%d",res-1);
	}
	else
		printf("-1");	
	
	return 0;
}
