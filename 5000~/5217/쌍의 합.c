#include <stdio.h>

int main()
{
    int n,T;
    scanf("%d",&T);//�׽�Ʈ ���̽�
    while(T--){
        int i,j;
        int a[200],b[200];
        int c=0;
        scanf("%d", &n);// n�Է¹ޱ�
        for(i=1; i<12; i++)
        {
            for(j=2; j<=12; j++)
            {
                 if(i>=j) // ���ų� �������� �ƴϸ� �ǳʶٱ�
                     continue;
                else
                {
                     if(i+j == n) // �� �߽߰�
                     {
                         a[c]=i;
                         b[c]=j;
                         c++;
                     }
                }
            }
        }
        if(c!=0){ //���� ����
            printf("Pairs for %d:",n);
            for(i=0; i<c; i++)
            {
                if(i==c-1) // ������ ���̸�
                    printf(" %d %d\n", a[i],b[i]);
                else
                    printf(" %d %d,", a[i],b[i]);
            }
        }
        else //���� �������� ����
            printf("Pairs for %d:\n",n);
    }
}
