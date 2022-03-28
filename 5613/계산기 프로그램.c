/*입력의 각 줄에는 숫자와 +, -, *, /, =중 하나가 교대로 주어진다. 첫 번째 줄은 수이다. 연산자의 우선 순위는 생각하지 않으며, 입력 순서대로 계산을 하고, =가 주어지면, 그때까지의 결과를 출력한다. 주어지는 수는 108 이하의 양의 정수이다. 계산 중 결과는 0 또는 음수가 될 수 있지만, -108 ~ 108 범위를 넘지는 않는다. 또, 나눗셈에서 소수점은 버린다. 따라서, 100/3*3 = 99이다.

피제수가 음수일 때 나눗셈을 하는 경우는 입력으로 주어지지 않는다.
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
    	if(i%2!=0) // 숫자와 부호가 번갈아 나옴. 즉 숫자는 항상 1부터 시작할시 홀수, 부호는 짝수 자리에만 등장.
		{
			scanf(" %lf", &a[ai]);
			ai++;
			if(ai==2)//첫 계산시에는 숫자가 2개
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
			else if(ai>2)//그 뒤부터는 sum을 다음에 온 숫자와 계산
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
			if(o == '='){ // =가 등장시 출력후 탈출
                printf("%.0lf", sum);
                break; 	
            }
		}
		i++;
    }
    
    return 0;
}
