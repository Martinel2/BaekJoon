#include <stdio.h>

int main()
{
    int T;
    scanf("%d",&T);
    
    while(T--)
    {
        int N,K; //N:������ ���� K:�Ծ���ϴ� �ּҰ���
        scanf("%d %d",&N,&K);
        int child=0; //���� ������ ��
        for(int i = 0; i<N; i++)
        {
            int a;
            scanf("%d", &a);
            child += a/K; //�Ծ���ϴ� �ּҰ����� ������ 
                          //�������� �ʴ밡���� ���̵��� ���� ����
        }
        printf("%d\n",child);
    }
    
    return 0;
}
