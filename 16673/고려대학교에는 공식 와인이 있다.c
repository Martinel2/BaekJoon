#include <stdio.h>

int main()
{
    int N,K,P,i;
    scanf("%d %d %d",&N,&K,&P);
    int sum =0;
    for(i=1; i<=N; i++)//1©øa¨¬IAI N©øa¡¾iAo
    {
       sum += (K*i)+(P*i*i); //KN + PN¨Ï¡À
       
    }
    printf("%d",sum);
    
    return 0;
}
