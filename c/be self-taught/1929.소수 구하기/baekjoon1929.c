#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int min, max;
    int i,j;
    int num[1000001] = {0};
    num[1] = 1;

    scanf("%d %d", &min, &max);
    
    for (i = 2; i <= max; i++)
    {
        if (num[i] == 0)
        {
            for (j = 2; j*i <= max; j++)
            {
                num[i * j] = 1;
            }
        }
    }

    for (i = min; i <= max; i++)
    {
        if (num[i] == 0)
        {
            printf("%d ", i);
        }
    }
    return 0;
}
