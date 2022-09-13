#include <stdio.h>


int main()
{
	double d[101];
	int T,i;
	scanf("%d", &T);
	d[0]=0;
	d[1]=1;
	d[2]=1;
	for(i = 3; i<=100; i++)
	{
		d[i] = d[i-2] + d[i-3];
	}
	while(T--)
	{
		int n;
		scanf("%d", &n);
		
		printf("%0.lf\n", d[n]);
	}
	
	
	
	return 0;
}
