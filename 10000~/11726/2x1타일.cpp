#include <stdio.h>

int main(){
	
	int n; 
	scanf("%d", &n);
	
	int d[n+1];
	d[0] = 1;
	d[1] = 1;
	
	for(int i = 2; i<=n; i++)
	{
		d[i] = (d[i-1] + d[i-2])%10007;
	}
	
	printf("%d", d[n]);
	
	return 0;
}
