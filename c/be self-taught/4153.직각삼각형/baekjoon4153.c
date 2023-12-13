#include <stdio.h>
#include <math.h>
#include <limits.h>
#include <stdlib.h>

int compare(const void *a, const void *b)
{
    int num1 = *(int *)a;    
    int num2 = *(int *)b;   
    if (num1 < num2)    
        return -1;     
    if (num1 > num2)   
        return 1;     
    return 0;   
}

int main()
{
    while (1)
    {   
        long arr[3];
        scanf("%ld %ld %ld", &arr[0], &arr[1], &arr[2]);
        qsort(arr,sizeof(arr)/ sizeof(long), sizeof(long),compare);
        if(arr[0] == 0 && arr[1] ==0 && arr[2]==0) break;
        if (pow(arr[0],2) + pow(arr[1],2) == pow(arr[2],2))
            printf("right\n");
        else{
            printf("wrong\n");
        }
    }
    return 0;
}


