/*�Է��� �� �ٿ��� ���ڿ� +, -, *, /, =�� �ϳ��� ����� �־�����. ù ��° ���� ���̴�. �������� �켱 ������ �������� ������, �Է� ������� ����� �ϰ�, =�� �־�����, �׶������� ����� ����Ѵ�. �־����� ���� 108 ������ ���� �����̴�. ��� �� ����� 0 �Ǵ� ������ �� �� ������, -108 ~ 108 ������ ������ �ʴ´�. ��, ���������� �Ҽ����� ������. ����, 100/3*3 = 99�̴�.

�������� ������ �� �������� �ϴ� ���� �Է����� �־����� �ʴ´�.
*/

#include <stdio.h>
#include <math.h>

int main(){
    
    double a[100]={0};
    double sum=0;
    char o;
    int i=1;
	int ai=0;
    while(1)
    {
    	if(i%2!=0) // ���ڿ� ��ȣ�� ������ ����. �� ���ڴ� �׻� 1���� �����ҽ� Ȧ��, ��ȣ�� ¦�� �ڸ����� ����.
		{
			scanf(" %lf", &a[ai]);
			ai++;
			if(ai==2)//ù ���ÿ��� ���ڰ� 2��
			{
				switch(o)
        		{
            	case '+' :
            	    sum += (a[ai-2]+a[ai-1]);
            	    break;
            	case '-' :
           	     	sum += (a[ai-2]-a[ai-1]);
            	    break;
            	case '*' :
              		sum += (a[ai-2]*a[ai-1]);
             	   break;
            	case '/':
                	sum += floor(a[ai-2]/a[ai-1]);
                	break;   
        		}
			}	
			else if(ai>2)//�� �ں��ʹ� sum�� ������ �� ���ڿ� ���
			{
				switch(o)
        		{
            	case '+' :
            	    sum = sum+a[ai-1];
            	    break;
            	case '-' :
           	     	sum = sum-a[ai-1];
            	    break;
            	case '*' :
              		sum = sum*a[ai-1];
             	   break;
            	case '/':
                	sum = floor(sum/a[ai-1]);
                	break;   
        		}
			}	
		}
		else if(i%2==0) 
		{
			scanf(" %c", &o);
			if(o == '='){ // =�� ����� ����� Ż��
                printf("%.0lf", sum);
                break; 	
            }
		}
		i++;
    }
    
    return 0;
}
