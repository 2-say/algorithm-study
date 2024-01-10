Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/2051

### 풀이
---
### 📄 1단계 문제 분석하기
---
- 물통을 이해해보면, A-B-C 로 연결되어 있는 그래프와 같다. 어디로든 움직일 수 있다. 따라서, 그래프 탐색을 사용할 수 있다. 

- 또한, 그래프 visited 체킹을 하지않으면 전수조사를 할 수 있다. 

<br>

### 🤘 2단계 손으로 풀기
---

<img width="150" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/3ecc1419-958c-4719-9b9b-988a3026475f">

<br>

전수조사를 위해서 경우의 수를 계산하면
나올 수 있는 경는 경우에 수는 6가지로 볼 수 있다. 

- A --> B
- A --> C
- B --> A
- B --> C
- C --> A
- C --> B

여기서 또 고려해야할 점은 해당 물통으로 담았을 때, 넘치는지, 넘치지 않는지 판별해야한다. 

그렇다면 나올수 있는 경우는 총 12가지가 된다.

### 👀 3단계 code 분석 
---

그래프로 나타낼 수 있으니까, 그래프 탐색을 사용한다. 

대부분 visited를 구현할 때, 노드번호를 기준으로 visited를 사용하는데, 여기에서는 모든 경우를 봐야하기 때문에 노드 visited 체킹하지 않는다. 

<br>

그 대신 값 visited를 사용해서 똑같은 값이 나오지 않도록 체킹해주는식이다. 

따라서, 노드는 무한 반복하면서 체킹한다. 하지만 해당 노드의 물의 양이 중복되므로 제거되면서 가지를 친다.

```
if (visited[i.a][i.b][i.c]) continue;
visited[i.a][i.b][i.c] = true;

```

- 모든 경우를 체킹

```
// A->B
if (i.a + i.b >= arr[1])
    que.add(new Water((i.a + i.b) - arr[1], arr[1], i.c));
else
    que.add(new Water(0, i.a + i.b, i.c));
// A->C
if (i.a + i.c >= arr[2])
    que.add(new Water((i.a + i.c) - arr[2], i.b, arr[2]));
else
    que.add(new Water(0, i.b, i.a + i.c));
//나머지 생략..
```

문제 조건에서 A 물통은 무조건 비워야 하므로 if (i.a == 0) 일 때, 답을 저장한다.

---

### 피드백 👩‍🏫
없음.

