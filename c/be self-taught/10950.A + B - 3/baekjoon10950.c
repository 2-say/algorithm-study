#include <stdio.h>

int main() {
    int tc;
    scanf("%d", &tc);

    for(int i = 0 ; i < tc; i++) {
        int a,b;
        scanf("%d", &a);
        scanf("%d", &b);
        printf("%d\n", a+b);
    }
}