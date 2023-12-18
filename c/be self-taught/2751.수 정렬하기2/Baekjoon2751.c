#include <stdio.h>
int sorted[1000000];

void merge(int arr[], int left, int mid, int right)
{
    int divideOne, dividetwo, sortIndx;
    divideOne = left;    // 나눈 부분 왼쪽 부분
    dividetwo = mid + 1; // 중간이후 오른쪽 부분

    sortIndx = left; // 정렬된 리스트의 인덱스

    while (divideOne <= mid && dividetwo <= right)
    {
        if (arr[divideOne] <= arr[dividetwo])
            sorted[sortIndx++] = arr[divideOne++];
        else
            sorted[sortIndx++] = arr[dividetwo++];
    }

    if (divideOne > mid)
    { // 왼쪽 다채워졌다면 오른쪽 다채우기
        for (int i = dividetwo; i <= right; i++)
        {
            sorted[sortIndx++] = arr[i];
        }
    }
    else
    { // 오른쪽이 다채워졌다면
        for (int i = divideOne; i <= mid; i++)
        {
            sorted[sortIndx++] = arr[i];
        }
    }

    for (int i = left; i <= right; i++)
    {
        arr[i] = sorted[i];
    }
}

void mergesort(int arr[], int start, int end)
{
    if (start < end)
    {
        int mid;
        mid = (start + end) / 2;
        mergesort(arr, start, mid);
        mergesort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
}

int main()
{
    int num,round; 
    scanf("%d", &round);
    int arr[round];
    for(int i = 0 ; i < round; i++){
        scanf("%d",&num);
        arr[i] = num;
    }
    mergesort(arr, 0, round-1);
    
    for (int i = 0; i < round; i++)
    {
        printf("%d\n", arr[i]);
    }
    return 0;
}