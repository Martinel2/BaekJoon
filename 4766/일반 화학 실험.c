#include <stdio.h>

int main(){
    
    double a1,a2=999;
    scanf("%lf", &a1);
    double dis;
    while(a1 != 999)
    {
        if(a2==999)//첫 온도
        {
            a2 = a1;
            scanf("%lf", &a1);
        }
        else if(a1 != 999)//그 뒤 반복 a2에 원래있던 a1을 주는게 포인트
        {
            dis = a1-a2;
            printf("%.2lf\n",dis);
            a2=a1;
            scanf("%lf", &a1);
        }
    }
    
    
    return 0;
}
