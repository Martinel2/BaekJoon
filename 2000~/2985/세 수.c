#include <stdio.h>

int main()
{
    int a,b,c;
    scanf("%d %d %d",&a, &b, &c);
    
    if(a+b == c || a == b+c)//더하기
    {
        if(a+b == c)
            printf("%d+%d=%d",a,b,c);
        else
            printf("%d=%d+%d",a,b,c);
    }
    else if(a-b == c || a == b-c)//빼기
    {
        if(a-b == c)
            printf("%d-%d=%d",a,b,c);
        else
            printf("%d=%d-%d",a,b,c);
    }
    else if(a*b == c || a == b*c)//곱하기
    {
        if(a*b == c)
            printf("%d*%d=%d",a,b,c);
        else
            printf("%d=%d*%d",a,b,c);
    }
    else if(a/b == c || a == b/c)//나누기
    {
        if(a/b == c)
            printf("%d/%d=%d",a,b,c);
        else
            printf("%d=%d/%d",a,b,c);
    }
    
    return 0;
}
