#include <stdio.h>

//�� ū ����� ����
int main()
{
    int N; //���� ��
    scanf("%d", &N);
    
    int wina =0, winb =0;
    while(N--)
    {
        int a,b;
        scanf("%d %d",&a,&b);
        
        if(a>b) //���ºδ� �Ѵ� 
            wina++;
        else if(a<b)
            winb++;
    }
    printf("%d %d",wina,winb);
}
