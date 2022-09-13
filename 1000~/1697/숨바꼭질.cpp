#include <stdio.h>
#include <math.h>

int front = -1;
int rear = -1;
bool visit[100001];

typedef struct Q{
	int dis;
	int count;
};

Q queue[100001];


void push(int dis, int count)
{
	rear = (rear+1)%100001;
	queue[rear].count = count;
	queue[rear].dis = dis;
	visit[dis] = true;
}

int bfs(int k)
{
	while(rear != front)
	{
		front = (front+1)%100001;
		int dist = queue[front].dis;
		int cnt =  queue[front].count;
		
		if(dist == k)
			return cnt;
		
		if(dist == 0)
			push(1,cnt+1);
		else
		{
			if(dist * 2 <= 100000) //범위내에서 
				if(!visit[2 * dist]){//방문하지 않았으면 
					push( 2 * dist , cnt + 1);//푸시 
				}
			if(dist -1 >= 0)
				if(!visit[dist -1]){
					push(dist -1 , cnt + 1);
				}
			if(dist +1 <= 100000)
				if(!visit[dist+1]){
					push( dist +1 , cnt + 1);
					}
		}
	}
}

int main(){
	
	int n,k;
	scanf("%d %d", &n, &k);
	push(n,0);
	
	
	
	printf("%d", bfs(k));
	
	return 0;
}
