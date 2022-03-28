#include <stdio.h>

int main()
{
    int n,T;
    scanf("%d",&T);//테스트 케이스
    while(T--){
        int i,j;
        int a[200],b[200];
        int c=0;
        scanf("%d", &n);// n입력받기
        for(i=1; i<12; i++)
        {
            for(j=2; j<=12; j++)
            {
                 if(i>=j) // 같거나 사전순이 아니면 건너뛰기
                     continue;
                else
                {
                     if(i+j == n) // 쌍 발견시
                     {
                         a[c]=i;
                         b[c]=j;
                         c++;
                     }
                }
            }
        }
        if(c!=0){ //쌍이 존재
            printf("Pairs for %d:",n);
            for(i=0; i<c; i++)
            {
                if(i==c-1) // 마지막 쌍이면
                    printf(" %d %d\n", a[i],b[i]);
                else
                    printf(" %d %d,", a[i],b[i]);
            }
        }
        else //쌍이 존재하지 않음
            printf("Pairs for %d:\n",n);
    }
}
