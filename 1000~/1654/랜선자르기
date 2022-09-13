#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
	long long N,M;
	
	scanf("%lld %lld", &N, &M);
	
	long long a[N];
	long long max = 0;
	for(long long i = 0; i<N; i++)
	{
		scanf("%lld", &a[i]);
		if(a[i]>max)
			max = a[i];
	}
	
	long long ans = 0;
	long long start = 1;
	long long end = max;
	
	while(start<=end)
	{
		long long sum = 0;
		long long mid = (start + end)/2;
		if(mid == 0)
			break;
		for(long long i = 0; i<N; i++)
		{
			if(a[i]>=mid)
			{
					sum = sum + (a[i]/mid);	
			}
		}
		if(sum>=M)
		{
			if(ans < mid)
				ans = mid;
			start = mid +1;
		}
		else
			end = mid -1;
	}
	
	printf("%lld", ans);
	
	return 0;
}
