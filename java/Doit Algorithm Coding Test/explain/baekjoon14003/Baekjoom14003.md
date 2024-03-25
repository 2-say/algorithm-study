Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/14003


### 풀이
---
### 📄 1단계 문제 분석하기
---
- 부분 문제를 이용해 전체 문제를 풀이하려면 i의 값이 부분 문제에 핵심이 되도록 정의해야하므로 D[i]를 단순히 0~i까지의 최장 증가 수열의 길이가 아닌 0~i까지의 최장 증가 수열의 길이가 아닌 0~i까지 i를 포함하는 최장 증가 수열의 길이로 정의하는 것이 중요하다.
- 단, 이 문제에 N의 최댓값이 1,000,000으로 크기 때문에 시간 복잡도를 고려하여 풀어야 한다.

<br>

### 🤘 2단계 손으로 풀기
---

다음처럼 접근해보자,

2가지를 넣을 것이다.  정답들을 담을 리스트, 담을 배열의 값에 index를 기억할 index Arr


<img width="565" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/d4f11510-b586-4810-8ee4-356868e16cd5">

이 상태로 시작해보자, 

순서대로 arr 배열을 담을 것이다.
일단 비교할 개쳬가 필요하니 list에 Integer.MIN_VALUE 를 넣는다.

1. 확인할 숫자(순서대로 오는 arr 값)가 list에 있는 마지막 값보다 크다면 뒤에 추가한다. 
2. 아니라면, 해당 수를 넣을 적절한 위치를 찾는다.  (적절한 위치를 찾을 때 이중 이분 탐색을 사용해야 시간복잡도가 준다.)

다음 수를 예제로 진행보겠다. 
[1, 5, 6, 7 , 2 , 3]



<img width="661" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/51fb39e2-7c46-4b46-a682-143f1653d913">


<img width="651" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/a1ff8674-0a55-4f24-83ad-1befada75d0c">

<br>
6,7 생략
<br>


<img width="635" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/c7d242bd-aba7-473b-bd5f-35c95c41682b">


<br>
결과는

<img width="608" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/9e90cb9e-f95f-40d8-b134-cca345106e33">

<br>

아직 정답은 [1,2,3,7] 이 아니다!
indexArr 에 값이 해당 i이 같지 않다는 뜻은 수열이 아니다. (순서가 맞지 않다는 뜻) 2 , 3 은  7보다 뒤에 있기 때문

<img width="616" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/3b5d0bbc-ca74-4b8d-a4a0-0857d34d0464">


위처럼 결과가 1 , 5 , 6 , 7 로 도출됨을 확인 할 수 있다.


### 👀 3단계 code 분석 
---
1. 확인할 숫자(순서대로 오는 arr 값)가 list에 있는 마지막 값보다 크다면 뒤에 추가한다. 

```
if (num > list.get(list.size() - 1)) {
    list.add(num);
    indexArr[i] = list.size() - 1;
}

```


2. 적절한 위치 탐색

```
else {
    while (left < right) {
        int mid = (left + right) >> 1;
        if (list.get(mid) >= num)
            right = mid;
        else
            left = mid + 1;
    }
    list.set(right, num);
    indexArr[i] = right;
}
```


<br>

---

### 피드백 👩‍🏫
없음.