#include <stdio.h>

int main(){

    int Test,havecookie, eatcookie;
    scanf("%d",&Test);
    
    while(Test--){
        int day=0;
        
        scanf("%d %d", &havecookie, &eatcookie);
        while(havecookie >0){
             havecookie -= eatcookie;
             day++;
        }
        printf("%d\n", day);
    }
    

    return 0;
}
