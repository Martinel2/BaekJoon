#include <stdio.h>
#define min(x,y)(x<y ? x:y)
#define max(x,y)(x<y ? y:x)

int main(){
    
    int a,b,c,x,y;
    scanf("%d %d %d %d %d", &a,&b,&c, &x,&y);// a:�Ķ��̵�, b:���, c:�ݹ�, x�Ķ��̵� ������, y��� ������
    
    int sum=0;
    int sum1=0;
    while(x != 0 || y != 0)//�� ������ ġŲ�� �� ������ Ż��
    {
        if(x != 0 && y != 0)
        {
            if(a+b > c*2)// �Ķ��̵� ��� ���� �Ѹ��� ����> �ݹ� �θ����̸�
            {
                int e = min(x,y);//�� �� �ִ� �ִ� ������
                int e1 = max(x,y);
                sum += (c*2)*e;
                sum1 += (c*2)*e1;
                x -= e;
                y -= e;
            }
            else
            {
                sum += x*a + y*b;
                sum1 += x*a + y*b;
                x=0;
                y=0;
            }
        }
        else if(x != 0 && y == 0) //x�� Ȧ���̸�
        {
            sum += x*a;
            x = 0;
        }
        else if(y !=0 && x == 0)// y�� Ȧ���̸�
        {
            sum += y*b;
            y = 0;
        }
    }
	if(sum<=sum1)    
    	printf("%d", sum);  
	else    
    	printf("%d", sum1);   
    
    return 0;
}
