#include <stdio.h>

int Max(int a, int b)
{
	if(a>b)
		return a;
	else
		return b;	
}


int main()
{
	int N;
	scanf("%d", &N);
	
	int s[N],d[N];
	for(int i =0; i<N; i++)
		scanf("%d", &s[i]);
	d[0] = s[0];
	d[1] = s[0] + s[1];
	d[2] = Max(s[1]+s[2], s[0]+s[2]);
	
	for(int i = 3; i<N; i++)
	{
		d[i] = Max(d[i-2]+s[i], s[i]+s[i-1]+d[i-3]);
	}
	
	printf("%d", d[N-1]);
	
	return 0;
}
