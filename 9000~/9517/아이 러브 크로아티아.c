/* � ������ ������ ������ ���� ��쳪, 
������ ��ŵ�� ��쿡�� �� ��� ���� ������ �ް� �ȴ�. 
������ ������ ���� ��쿡�� ��ź�� �ٷ� ���ʿ� �ִ� �÷��̾�� �Ѱ��ְ�, 
�Ѱܹ��� �÷��̾�� ���� ������ ������ �ȴ�.
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
