#include <stdio.h>
// 3,4 = 2°³ 5,6 = 3°³ 7,8 = 4°³ 

int main(){
    
    int N,M;
    scanf("%d %d", &N,&M);
    
    int a;
    int sum=0;
    for(int i=0; i<M; i++){
        
        scanf("%d", &a);
        
        if(a==3 || a==4){
           sum +=2; 
        }
        else if(a==5 || a==6){
           sum +=3; 
        }
        else if(a==7 || a==8){
           sum +=4; 
        }
        
        
    }
    if(sum>=N)
        printf("YES");
    else
        printf("NO");
    
    
    
    return 0;
}
