#include <stdio.h>

int main()
{
    int T;
    scanf("%d",&T);
    
    while(T--)
    {
        int N,K; //N:사탕의 종류 K:먹어야하는 최소갯수
        scanf("%d %d",&N,&K);
        int child=0; //오는 아이의 수
        for(int i = 0; i<N; i++)
        {
            int a;
            scanf("%d", &a);
            child += a/K; //먹어야하는 최소갯수로 나누면 
                          //한종류당 초대가능한 아이들의 수가 나옴
        }
        printf("%d\n",child);
    }
    
    return 0;
}
