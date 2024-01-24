Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/1219

### 풀이
---
### 📄 1단계 문제 분석하기
---
- 벨만 포드 응용문제 
- 기존 벨만 포드는 최단 거리를 구하는 문제이지만, 업데이트 방식을 반대로 하면 된다!
- 또한, 반대로 찾기 때문에, 양수 사이클을 찾아야한다.
<br>

### 🤘 2단계 손으로 풀기
---
원래 벨만 포드에서 바뀐 것은 크게 보면 두가지라고 할 수 있는데,

- 시작을 작은 값으로 
- 총 번돈을 최대로 저장 IF문 큰 것을 업데이트 

이렇게 만들어보자 <br>

<img width="395" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/24f9abad-59a5-4f70-8a54-288b576c4849">

<br><br>

만약 이렇게 하다 사이클이 생긴다는 것은 양수의 값이 계속 증가한다 -> 양수 사이클이 생긴다. 
-> "GEE" 처리 

<br><br>

만약, MIN_VALUE 에서 한번도 업데이트 되지 않았다? -> 갈 수 없는 도시 -> "gg" 처리 

n번 횟수를 반복했을때는 사이클의 존재 여부만 파악할 수 있다. 어떤 노드가 싸이클의 포함되어있는 노드인지 확인하기 위해서 문제에서 제시된 노드개수 최대 50개 이기때문에 반복횟수를 넉넉하게 50~ 이상 더 반복한다.

<br> 

그렇게 되면 싸이클에 해당하는 노드들은 모두 MAX_VALUE로 표시된다.

### 👀 3단계 code 분석 
---

코드의 자세한 주석을 작성했다. 

코드를 참고하자!


<br>
---

### 피드백 👩‍🏫

플래티넘 문제이지만, 알고보니 어렵지 않은 문제였다. 쫄지 말고 해보자! 