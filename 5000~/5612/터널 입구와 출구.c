#include <stdio.h>

int main(){
    
    int n,m;
    scanf("%d", &n);//������ �ð�
    scanf("%d", &m); //ó�� ����ÿ� �����ϰ��ִ� ������
    int max = m;
    int sum = m;
    int i;
    for(i = 0; i<n; i++){
        int a,b;
        scanf("%d %d" , &a,&b); // a:���� ������ b: ���� ������
        sum = sum + a - b ;
        if(sum>max)
            max = sum;
        else if(sum < 0)
        {
            printf("0");
            break;
        }
    }
    
    if(i == n)
        printf("%d", max);
    
    return 0;
}
