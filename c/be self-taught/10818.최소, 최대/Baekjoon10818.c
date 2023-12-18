#include <stdio.h>
#include <stdlib.h>

int compare(const void *a , const void *b); 

int main()
{
    int tc, i, input;

    scanf("%d", &tc);
    int arr[tc];

    for (i = 0; i < tc; i++)
    {
        scanf("%d", &input);
        arr[i] = input;
    }
    qsort(arr,tc, sizeof(arr[0]),compare);
    printf("%d ",arr[0]);    
    printf("%d",arr[tc-1]);    
}

int compare(const void *a, const void *b){
        if (*(int *)a > *(int *)b)
            return 1;
        else if (*(int *)a < *(int *)b)
            return -1;
        else
            return 0;
}