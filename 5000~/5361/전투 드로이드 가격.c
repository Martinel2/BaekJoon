#include <stdio.h>

/*

������ ������	$350.34
�ð� ����	    $230.90
û�� ����	    $190.55
��	            $125.30
�ٸ�	        $180.90
*/


int main()
{
	int T; //�׽�Ʈ ���̽� 
	scanf("%d", &T);
	
	while(T--)
	{
		double a,b,c,d,e; //��ǰ����
		
		scanf("%lf %lf %lf %lf %lf", &a,&b,&c,&d,&e);
		double sum = a*350.34 + b*230.90 + c*190.55 + d*125.30 + e*180.90;
		printf("$%.2lf\n", sum);//�Ҽ� ��°�ڸ����� 
		 
	} 
		
	return 0;
}
