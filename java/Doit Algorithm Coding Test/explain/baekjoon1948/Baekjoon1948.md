Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/1948

### 풀이
---
### 📄 1단계 문제 분석하기
---
- 이 문제를 풀 수 있는 방법은 다양하다. 
- 다익스트라, 위상정렬로 해결할 수 있다.
- 최대로 긴(시간이 오래 걸리는) 경로를 찾으면 된다.

<br>


### 🤘 2단계 손으로 풀기
---
위상 정렬로 방향 그래프를 순차방문하자! 
여기서 핵심은 경로 중에서 오래 걸리는 경로를 구하자!
<br>
<img width="263" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/45f0e608-e0ef-4be5-9761-d1aca58c5938">
<br>
현재 저장되어있는 테이블 값보다, 새롭게 4를 통해서 들어오는 값이 더 크다! 

계속해서 테이블에 있는 값보다 큰 값을 입력하면 된다.
<br>

그렇게하면 해당 경로로 가는 최대 시간이 나온다.
출발점과 도착지점과 차이가 없음. 
따라서, 도착점 -> 출발점으로 거꾸로 가면서 최대값으로 계산된 경로랑 일치한다면 경로 개수를 세어주면 된다.

----
예를 들어보자 

<img width="323" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/555385aa-e4bb-4f5c-9b9e-2fd08d35fe05">

위와 같은 경로가 있다면 비용 배열은 순서대로 {0,1,2,10}으로 저장된다.
<br>
이제 도착지부터 출발지로 역행하면서 지금 가는 길이 최대경로인지 확인해보자!!

- 도착 -> 3으로 가는 경로를 확인해보자

<img width="348" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/4d1f797a-5852-4b18-914a-fdabfbfb225d">

보면, 테이블의 저장된 값과<br>
(출발지 -> 도착지 가는비용)

<br>
8 + 테이블의 저장된 값 2 

(3에서 -> 출발지 가는 비용) 이 10으로 같다.
<br> 즉, 해당 경로는 최대로 가는 경로니까 경로를 세면 된다! 


---

### 👀 3단계 code 분석 

- 최대값 업데이트 하는 부분

```
result[next.node] = Math.max(result[next.node], result[curr] + next.cost);
```

- 현재 경로가 최대 경로인지 확인하는 부분
```
if(result[next.node] + next.cost == result[curr])
```

---

### 피드백 👩‍🏫
없음.