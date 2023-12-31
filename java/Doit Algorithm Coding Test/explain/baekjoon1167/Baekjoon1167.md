Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/1167

### 풀이
---
### 📄 1단계 문제 분석하기
---
- 노드가 주어진 문제이고, 거리의 합을 구하는 문제 (특성이 있는 그래프 탐색)
- 따라서, DFS로 문제를 해결할 수 있다.
<br>

### 🤘 2단계 손으로 풀기
---
어떻게 보면 당연한 말이지만, 밑 예제를 보면 가장 거리가 먼 정점은 1 , 5 이다. 

다른 정점에서도 갈 수 있는 최대 거리는 모두 5 또는 1을 포함한다는 것을 볼 수 있다.

<img width="257" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/e3b05aea-32ae-4457-9b72-ac89965ef2f5">

이러한 트리의 특성으로 나올 수 있는 결론은, 최대로 만들 수 있는 경로는 모두 1,5를 포함한다. (거리가 가장 긴 노드를 반드시 포함한다.)


<br>
이 문제에서 만약 위 특성을 고려하지 않고 풀게 된다면, 시간초과가 발생하게 된다.

### 👀 3단계 code 분석 
---
1. dfs 구현
dfs는 재귀로 구현하였고, 거리를 체크하기 위해서 다음에 갈 Node에 cost를 더해서 다음 재귀를 실행하도록 만들었다. 


```
dfs(next.index, cost + next.cost);
```

2. 위에서 제시한 트리의 특성 적용

```
for(int i=1; i<= n ; i++){
    dfs(i);
}
```
만약 이렇게 적용한다면 시간초과가 발생한다. 
따라서, 처음 아무거나 하나의 노드를 넣어보고 최대의 거리일 때, 노드가 무엇인지 찾는다.

```
//dfs 함수 안
if (cost > max) {
            max = cost;
            node = start;
}
```
```
//메인 함수
dfs(1, 0);  //아무 노드나 방문해서 최장거리 노드 찾기
visited = new boolean[n + 1];
dfs(node, 0);
```
최장 거리 노드부터 다시 최대 지름을 구한다.

<br>
---

### 피드백 👩‍🏫

꼼꼼하게 분석하면서 공부할 필요가 있어 보인다.