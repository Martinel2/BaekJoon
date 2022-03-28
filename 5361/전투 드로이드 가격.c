#include <stdio.h>

/*

블래스터 라이플	$350.34
시각 센서	    $230.90
청각 센서	    $190.55
팔	            $125.30
다리	        $180.90
*/


int main()
{
	int T; //테스트 케이스 
	scanf("%d", &T);
	
	while(T--)
	{
		double a,b,c,d,e; //부품변수
		
		scanf("%lf %lf %lf %lf %lf", &a,&b,&c,&d,&e);
		double sum = a*350.34 + b*230.90 + c*190.55 + d*125.30 + e*180.90;
		printf("$%.2lf\n", sum);//소수 둘째자리까지 
		 
	} 
		
	return 0;
}
