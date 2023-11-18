Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/status?user_id=h01037466071&problem_id=1546&from_mine=1


### 풀이
---
### 📄 1단계 문제 분석하기
---
- 점수 결과를 보면 71.43 -> 실수 표현 -> Double 자료형
- 최댓값 M을 구해야한다. 
- 과목 값이 여러개니까 배열을 이용한다. 

<br>

### 🤘 2단계 손으로 풀기
---
생략

<br>

### 👀 3단계 code 분석 
---
1.최댓값 뽑기 

```
for (int i = 0 ; i < num ; i++)
{
    if(max < Integer.parseInt(arnum[i]))
    {
        max = Integer.parseInt(arnum[i]);
    }
}
```
max에 초기값으로 Integer.MIN_VALUE 를 넣어서 해도 되지만, 
큰 값에 인덱스는 몰라도 되니 max = arnum[0]; 으로 초기화 했다. 

<br>

2.타입 변환 후 식 계산
```
for (int i = 0 ; i < num ; i++)
{
    arr_result[i] = (Double.parseDouble(arnum[i])/max) * 100.0 ;
    result += arr_result[i];
}
result /= num;
```


<br>


---

### 피드백 👩‍🏫
처음 코드를 만들었을 때에는 식을 계산하는 반복문 따로 결과를 모두 합하는 반복문을 따로 만들었었다. 
시간 복잡도는 상수를 고려하지 않아서 같겠지만, 불필요한 코드가 생긴다. 

같은 조건의 반복이 2번 반복 됨으로 합쳐서 다시 작성했다. 

## Before 
```
for (int i = 0 ; i < num ; i++)
{
    arr_result[i] = (Double.parseDouble(arnum[i])/max) * 100.0 ;
}



for (int i = 0 ; i < arr_result.length ; i++)
{
    result += arr_result[i];
}
```

## After
```
for (int i = 0 ; i < num ; i++)
{
    arr_result[i] = (Double.parseDouble(arnum[i])/max) * 100.0 ;
    result += arr_result[i];
}

```

이런 실수 하지 말자.. 