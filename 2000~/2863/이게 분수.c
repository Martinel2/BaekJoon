/*표의 값은 A/C + B/D 이다.*/
#include <stdio.h>

void SWAP(double *a, double *b)
{
    double temp = *a;
    *a = *b;
    *b = temp;
}

int main()
{
    double A,B,C,D;
    
    scanf("%lf %lf %lf %lf",&A,&B,&C,&D);
    
    double s = A/C + B/D;
    int r=0;
    for(int i=1; i<=3; i++)
    {
        SWAP(&A,&B);  // B A C D
        SWAP(&A,&D);  // D A C B
        SWAP(&A,&C);  // C A D B
        double s1 = A/C + B/D;
        
        if(s<s1)
        {
            r = i;
            s = s1;
        }
    }
    printf("%d",r);
    return 0;
}
