#include <stdio.h>

int main(){
    
    double a1,a2=999;
    scanf("%lf", &a1);
    double dis;
    while(a1 != 999)
    {
        if(a2==999)//ù �µ�
        {
            a2 = a1;
            scanf("%lf", &a1);
        }
        else if(a1 != 999)//�� �� �ݺ� a2�� �����ִ� a1�� �ִ°� ����Ʈ
        {
            dis = a1-a2;
            printf("%.2lf\n",dis);
            a2=a1;
            scanf("%lf", &a1);
        }
    }
    
    
    return 0;
}
