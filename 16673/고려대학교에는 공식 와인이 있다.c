#include <stdio.h>

int main()
{
    int N,K,P,i;
    scanf("%d %d %d",&N,&K,&P);
    int sum =0;
    for(i=1; i<=N; i++)//1��a��IAI N��a��iAo
    {
       sum += (K*i)+(P*i*i); //KN + PN�ϡ�
       
    }
    printf("%d",sum);
    
    return 0;
}
