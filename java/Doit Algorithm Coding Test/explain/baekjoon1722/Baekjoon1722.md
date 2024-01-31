Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/1722

### 풀이
---
### 📄 1단계 문제 분석하기
---
- N이 20자리이기 때문에 단순히 Brute force를 사용하면 시간초과가 발생한다.
- 순열이 있는 문제 , 주어진 경우의 수와 k번째를 잘 이용하면 해결할 수 있다.

<br>

### 🤘 2단계 손으로 풀기
---
이 문제를 접근할 때, 순번과 경우의 수의 관계를 잘 비교해보자.  예시를 들어 확인하는 것이 이해하는게 빠르다. 아래 그림을 보자,


<br>
<img width="471" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/d3c8807f-d952-4dbd-8de7-4f941ab69cef">
5일때는 생략

<br>

위 계산 결과로 인해서 61번째 맨 앞은 뭔지는 모르지만, 3XXXX 인것을 예상할 수 있다. 3을 확정하고 다음 경우의 수를 만들어 보자,

<br>

<img width="609" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/854ffcd3-9063-40a9-b25a-ca5b92452758">

위 계산 결과로 34XXX 임을 만들 수 있다.

이어서 계속하자,

<br>

<img width="514" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/1a748576-60a1-4d3d-8be5-887cffbefdac">

이렇게 계산하면 해결할 수 있다. 

반대로 숫자가 주어졌을 때, 몇번째인지 구하는 것은 위 과정을 역순으로 진행하면 된다.


---



### 👀 3단계 code 분석 

```
for(int i = 0; i<N; i++) {
    for(int j = 1; j<=N; j++){
        if(visited[j]) continue;    //이미 사용된 숫자는 패스
        if(k - fac[N-1-i] > 0) {    //0이랑 같으면 1 3 4 2가 오답으로 출력됨 
            k -= fac[N-1-i];        
        }
        else {                         
            ansVec.add(j);
            visited[j] = true;
            break;
        }
    }
}
```
<br>

코드에서는 61번째라면, 경우의 수를 빼가면서 찾고 있다. Top- down 방식 

---

### 피드백 👩‍🏫
앞으로 이런 비슷한 문제가 주어졌을 때, 순번과 경우의 수의 관계르 떠올리는 것이 중요할 것 같다. 
