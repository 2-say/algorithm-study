Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/11659


### 풀이
---
### 📄 1단계 문제 분석하기
---
- 구간합 여러번 출력해야 하므로 한번에 구해놓는 것이 효율적이다. -> 구간합 결과 배열
- 입력받는 값이 많고 인덱스를 잘파악하여 계산하는 것이 관건
- out of range 주의 

<br>

### 🤘 2단계 손으로 풀기
---
나 같은 경우에는 마지막 코드에 
```
System.out.println(arr[e]-arr[s-1]);
```
파악하기 용이하도록 책에서 제시해준 공식 S[j]-S[i-1] 처럼 식을 만들었다.
그렇게 만들기 위해서 구간합 0자리에 0을 넣어 아래와 같은 방식으로 더해가면서 값을 넣었다. 

<img width="300" alt="image" src="https://github.com/2-say/Algorithm_Study/assets/91319157/49d119cf-c030-421b-a4d5-f88a226ce672">

<br>

### 👀 3단계 code 분석 
---
1.구간합 구하기

```
for(int i = 0; i < Integer.parseInt(inum[0]); i++)
{
    arr[i+1] = Integer.parseInt(arrnum[i]) + arr[i];
}
```
입력받은 (5,4,3,2,1) arrnum 배열은 모두 순회해야하므로 0~4까지 반복문 범위를 설정했고 구간합은 1~5까지 입력해야하므로 +1 했다. 


<br>

2.결과 출력
```
for(int i = 0 ; i < Integer.parseInt(inum[1]); i++)
{
    String[] sigmanum1 =  br.readLine().split(" ");
    int s = Integer.parseInt(sigmanum1[0]);
    int e = Integer.parseInt(sigmanum1[1]);
    System.out.println(arr[e]-arr[s-1]);
}
```

구간합을 계산하는 공식은 

https://www.notion.so/2-say/80d3aa04ec4e43f7bba783adb14f0981?pvs=4

를 확인 


<br>


---

### 피드백 👩‍🏫
처음 문제를 풀 때는 그저 결과를 출력하면서 결과만을 분석하면서 문제를 풀었는데, 
해결하고 난 후에도 다른 부분에서 또 오류가 발생했다. 이렇게 하니 시간도 오래 걸리고 계속 또 다른 문제가 발생하는 일이 생겼다...

그래서 직접 노트에 배열을 그리고 인덱스를 파악하면서 다시보니 설계가 잘못되었다는 것을 바로 확인할 수 있었다. 

이렇게 인덱스 분석이 필요한 문제는 눈으로 풀기보다는 직접 작성해보면서 푸는게 더욱 효과적이라고 생각한다.