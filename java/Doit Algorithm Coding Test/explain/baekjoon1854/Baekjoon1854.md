Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/1854

### 풀이
---
### 📄 1단계 문제 분석하기
---
- 다익스트라를 사용하고 응용하는 방식으로 해결
- 도시의 수 1,000개 간선 수 2,000,000 이라서, 다익스트라 O(ev)로 해결 가능하다.
- K번째의 수를 구하기 위해서 모든 경우를 확인해야한다. 
- 모든 경우의 비용을 추가하다가 K번째를 만족하는 비용만 업데이트한다.
<br>

### 🤘 2단계 손으로 풀기
---
다익스트라에서 K번째를 도입하는 방법을 적용하면된다! <br>
<img width="433" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/67bb36b5-1125-4dbf-8e88-e37b83479ed3">
<br>
- 각 도시의 K번째를 구해야한다. 
- K번째는 큰 수부터 정렬되어야 한다. (내림차순)
그렇다면!! Priority<Integer>로 구성되어있는 배열을 만들면 되겠다!
<br>

<img width="192" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/91de61e6-bab7-4f82-b2d3-1d3484fb5c2b">

<br>

이제 코드로 다익스트라 알고리즘을 바꿔보자! 

### 👀 3단계 code 분석 
---
- 원래 다익스트라 알고리즘을 적용할 때는 1차원 Dist[] 배열을 사용했다. 이렇게 되면, 모든 경우를 따질 수 없고, 업데이트 될 때 마다 <b>덮어 쓰게 되어서 <b> 이 문제에서는 적용할 수 없다. 

<br> 따라서, 비용 값을 Node에 저장하고, K번째 비용은 위에서 만든 Priority<Integer> 배열을 사용하자! 

마지막에 K번째를 비교해서 작은 값을 넣기 위해서는 PriortyQueue를 내림차순으로 정렬해야 제일 큰 값이 맨위로 올라가기 때문에 빼낼 수 있다.

<img width="155" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/fce79b53-90b9-48de-aaf3-c173286e57fe">

<br><br><br>




- 시작 지점 0으로 초기화

```
result[start].add(0);
```

- 위에서 말했던 K번째 해결 방안 적용
```
//K개 까지 안찼으면 채워!!
if (result[next.n].size() < k) {
    result[next.n].add(cur.cost + next.cost);
    que.add(new Node(next.n, cur.cost + next.cost));

    //K개까지 가득 찼으면 맨 앞에것만 비교해서 작으면 빼고 넣어 ~ 
} else {
    if (cur.cost + next.cost< result[next.n].peek()) {
        result[next.n].poll();
        result[next.n].add(cur.cost + next.cost);
        que.add(new Node(next.n, cur.cost + next.cost));
    }
}
```



---

### 피드백 👩‍🏫
처음엔 소수 판별 시간 복잡도를 줄이기 위해서 에라토스테네스 체를 사용했지만, 메모리 초과로 실패했고 

알고보니 그저 반복문을 통해서 소수를 판별해보니 해결되었다. 시간복잡도 만큼 공간 복잡도도 잘 파악해서 문제를 해결하도록 노력해야겠다.

