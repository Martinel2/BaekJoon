#include <stdio.h>

int main() {

    int T,casenum;
    
    scanf("%d", &T);
    
    while(T--){
        double D,A,B,F;
        
        scanf("%d %lf %lf %lf %lf", &casenum,&D,&A,&B,&F);
        printf("%d %lf\n", casenum,(D/(A+B)*F));
    }
    
    return 0;
}
