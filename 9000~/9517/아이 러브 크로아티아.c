/* 어떤 문제의 정답을 맞추지 못한 경우나, 
문제를 스킵한 경우에는 그 즉시 다음 문제를 받게 된다. 
문제의 정답을 맞춘 경우에는 폭탄을 바로 왼쪽에 있는 플레이어에게 넘겨주고, 
넘겨받은 플레이어에게 다음 질문이 나가게 된다.
3 30 = 210
*/

#include <stdio.h>

int main()
{
    int N;
    int p;
    scanf("%d",&p);
    scanf("%d", &N);
    int T=0;
    int boom=0;
    for(int i=0; i<N; i++)
    {
        int t;
        char ans;
        scanf("%d %c",&t,&ans);
        T += t;
        if(T>210 && boom == 0)
            boom=p;
        if(ans == 'T')
        {
            p++;
        }
        if(p>8)
            p=1;
    }
    printf("%d",boom);
    return 0;
}
