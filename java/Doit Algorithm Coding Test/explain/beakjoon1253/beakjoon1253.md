Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/1253


### 풀이
---
### 📄 1단계 문제 분석하기
---
- 제한 시간 2초, 데이터의 크기 2,000이다. 따라서 O(n^3) 을 사용한다면 연산시간은 대략 80초로 O(nlogn) 방법을 사용해야 한다 

    -> Two Point 알고리즘 사용


- 문제 내용을 보면 자기 자신을 제외 해야함 


<br>

### 🤘 2단계 손으로 풀기
---
- 정렬 필요

<img width="300" alt="image" src="https://github.com/2-say/Algorithm_Study/assets/91319157/4366aa07-311f-453a-95aa-b6c751179e39">

양쪽을 포인터를 지정한다. Start + End 값을 더해서 찾는 값보다 크다면 end를 낮춰 값을 낮추고 작다면 start를 늘려 값을 키운다. 


<br>

### 👀 3단계 code 분석 
---
1. 모든 원소 순회 
해당 하는 값이 좋은 수(Good Num!) 인지 판단하기 위해서 차례로 한번씩 방문해야한다. 따라서 바깥쪽 For문 필요

```
for(int a =0 ;a<n ; a++){
          //
}
```

<br>

2.핵심 로직 구현

3가지 경우로 Two Pointer 알고리즘을 구현한다. 자세한 개념은 아래 링크 첨부

https://www.notion.so/2-say/a6d5eb7900224f66be125bbe58b363c9?pvs=4

```
 while(i < j){
                sum = int_arr[i] +  int_arr[j];
                if(sum == find)
                {
                    if(i != a && j !=a)
                    {
                        count++;
                        break;
                    }
                    else if( i == a)
                    {
                        i++;
                    }
                    else if(j==a){
                        j--;
                    }
                }
                else if(sum > find)
                {
                    j--;
                }
                else{
                    i++;
                }
        }            
```

start 포인터가 end 포인터를 지나치지 않기위해 While(i<j) 조건문으로 작성했고, 이 문제에서는 자신 원소를 제외한 다른 수 2값에 합이라는 문제내용으로 if(i != a && j !=a) 가 필요하다. 

만약, 위 조건이 아닌경우에는 못찾더라도 정상 동작해야하기 때문에   i == a , j == a 일 경우로 정상 작동 하도록 만들었다. 

<img width="285" alt="image" src="https://github.com/2-say/Algorithm_Study/assets/91319157/95356561-10d1-4a52-be8a-b4f044cb5fd0">


<br>


---

### 피드백 👩‍🏫
문제에 내용을 제대로 이해하지 못해서 몇번이나 다시 푼 문제였다. 앞으로는 문제를 정말 한 글자씩 똑바로 읽고 해석해서 완벽하게 이해 후 풀어야 겠다. 
