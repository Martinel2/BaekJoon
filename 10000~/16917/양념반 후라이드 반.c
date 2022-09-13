#include <stdio.h>
#define min(x,y)(x<y ? x:y)
#define max(x,y)(x<y ? y:x)

int main(){
    
    int a,b,c,x,y;
    scanf("%d %d %d %d %d", &a,&b,&c, &x,&y);// a:후라이드, b:양념, c:반반, x후라이드 마릿수, y양념 마릿수
    
    int sum=0;
    int sum1=0;
    while(x != 0 || y != 0)//두 종류의 치킨을 다 샀을때 탈출
    {
        if(x != 0 && y != 0)
        {
            if(a+b > c*2)// 후라이드 양념 각각 한마리 가격> 반반 두마리이면
            {
                int e = min(x,y);//살 수 있는 최대 마릿수
                int e1 = max(x,y);
                sum += (c*2)*e;
                sum1 += (c*2)*e1;
                x -= e;
                y -= e;
            }
            else
            {
                sum += x*a + y*b;
                sum1 += x*a + y*b;
                x=0;
                y=0;
            }
        }
        else if(x != 0 && y == 0) //x가 홀수이면
        {
            sum += x*a;
            x = 0;
        }
        else if(y !=0 && x == 0)// y가 홀수이면
        {
            sum += y*b;
            y = 0;
        }
    }
	if(sum<=sum1)    
    	printf("%d", sum);  
	else    
    	printf("%d", sum1);   
    
    return 0;
}
