#include <stdio.h>

int main() {
    int tc; 
    scanf("%d", &tc);

    for(int i = 0 ; i < tc; i++){
        char *a;
        int b;
        scanf("%d %s",&b, &a);
        for(int j = 0 ; j < b; j++){
            printf("%c",a);
            
        }
    }
}