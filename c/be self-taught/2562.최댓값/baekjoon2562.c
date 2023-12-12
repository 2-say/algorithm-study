#include <stdio.h>
#include <limits.h>

int main() {
    int max  = INT_MIN;
    int idx =-1;
    for(int i = 0 ; i < 9; i++){
        int a; 
        scanf("%d",&a);
        if(max < a) {
            idx = i;
            max = a;
        }
    }
    printf("%d\n%d",max,idx+1);
}