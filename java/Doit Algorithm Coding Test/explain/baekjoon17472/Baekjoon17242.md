Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/17242


### 풀이
---
### 📄 1단계 문제 분석하기
---
- 데이터 크기가 매우 작은편이라 제약이 크지 않음.
- 섬을 구분해서 연결하는 과정이 필요하다. 
- 최소 신장 트리를 이용해서 연결하면 해결할 수 있다.

<br>

### 🤘 2단계 손으로 풀기
---

먼저, 각 섬을 구분하는 과정이 필요하다. 따라서, DFS로 섬을 둘러보고 각 섬을 다른 색으로 만들어주자, 

<img width="266" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/75243b2b-8be1-4e27-ac14-b5ad54db5c89">

나머지칸은 0이다.

DFS를 거치면 다음처럼 만들 수 있다.

<img width="228" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/a035d8e9-d5cc-44f3-9cc3-82a19a465f21">

이 상태에서 섬의 모든 부분에서 수평선, 수직선을 만들어서 연결되는 섬이 있는 지 확인한다. 

<img width="250" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/f4bd03a9-66c3-4812-a626-cd780db5191e">

연결된 모든 다리들의 비용순으로 Queue에 넣고 MST을 만든다. 
Union 연결하여, 같은 섬이 아니라면 합친다! 

Union 연결 n-1 하면, 모든 섬이 연결되었음으로, 
모든 비용의 합을 계산한다! 


### 👀 3단계 code 분석 
---
1. 구현 문제이기 때문에, 구현하는 자체가 어려움.

```
while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M) {
    if (map[r + tempR][c + tempC] == now_S) // 같은 섬이면 간선을 만들수 없음
        break;
    else if (map[r + tempR][c + tempC] != 0) { // 같은 섬이 아니고 바다가 아니면
        if (blenght > 1) // 다른 섬 -> 길이가 1이상일때 간선으로 더해줍니다.
            queue.add(new bEdge(now_S, map[r + tempR][c + tempC], blenght));
        break;
    } else // 바다이면 다리의 길이를 연장하여 줍니다.
        blenght++;
    if (tempR < 0)
        tempR--;
    else if (tempR > 0)
        tempR++;
    else if (tempC < 0)
        tempC--;
    else if (tempC > 0)
        tempC++;
}
```
이렇게 하면, 현재 방향이 왼쪽이면 왼쪽끝까지 이동하고, 오른쪽이면 오른쪽으로 위면 위 아래면 아래로 끝까지 이동하는 코드가 된다. 


<br>

---

### 피드백 👩‍🏫
구현문제는 최대한 알아보기 쉽게 작성해야하고 기능을 메서드로 나눠서 설계를 탄탄하게 해야 나중에 실수를 안하는 것 같다. 
천천히 마음먹고 오래걸리더라도 깨끗하게 작성해보기! 