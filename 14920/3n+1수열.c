/*   C(n+1) = C(n)/2     (C(n)�� ¦���� ��)
            = 3*C(n)+1   (C(n)�� Ȧ���� ��)
*/

#include <stdio.h>

int main(){
    
    int n;
    scanf("%d", &n);
    int cnt=1;
    
    while(n != 1)
    {
        if(n%2==0) // ¦��
        {
            n = n/2;
        }
        else // Ȧ��
        {
            n = 3*n+1;
        }
        cnt++;
    }
    printf("%d", cnt);
    
    
    
    return 0;
}
