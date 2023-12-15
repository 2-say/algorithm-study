#include <stdio.h>
#include <stdlib.h>

int main(void)
{   
    int in, i, j, count;
    scanf("%d", &in);
    count = in;
    
    for (i = 0; i < in; i++)
    {
        int a;
        scanf("%d", &a);
        if (a == 1)
        {
            count--;
        }
        else
        {
            for (j = 2; j <= a - 1; j++)
            {
                if (a % j == 0)
                {
                    count--;
                    break;
                }
            }
        }
    }
    printf("%d", count);
    return 0;
}
