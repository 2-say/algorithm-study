#include <stdio.h>
#include <math.h>

int main() {
    double a,b,c;
    scanf("%lf", &a);
    scanf("%lf", &b);
    scanf("%lf", &c);
    
    if(exp2(a) + exp2(b) == exp2(c)) printf("right");
    else{
        printf("wrong");
    }
}