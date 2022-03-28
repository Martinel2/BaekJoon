#include <stdio.h>

int main(){
    long long int N;
    scanf("%lld", &N);
    if(N==1)
        printf("1");
    else{
        
        while(N>0)
        {
            if(N%2==0 || N==1)
                N = N/2;
            else
            {
                printf("0");
                break;
            }
        }
        if(N==0)
        {
            printf("1");
        }
    }
    
	return 0; 
}
