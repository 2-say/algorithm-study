Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/1976

### 풀이
---
### 📄 1단계 문제 분석하기
---
- 문제에서 제시한 내용에 따르면, 연결되어 있으면 갈 수 있다. 연결되어 있지 않으면 갈 수 없다. 
- 제시한 도시가 연속적으로 같은 집합인지만 확인하면 된다.

<br>

- 물론 그래프 탐색으로 풀이법이 될 수 있지만, 탐색을 굳이 하지 않아도 되고, 탐색하면서 경로같은 정보를 얻을 필요도 없기 때문에 Union Find 로 풀어야 한다.

<br>


### 🤘 2단계 손으로 풀기
---
쉬움으로 생략

---

### 👀 3단계 code 분석 

union-find에 필요한 3가지 메서드만 구현하면 된다.

```
static void union(int a, int b){
    int prentA = findPar(a);
    int prentB = findPar(b);
    if(prentA != prentB) arr[prentA] = prentB;
}
static boolean find(int a, int b) {
    if (findPar(a) == findPar(b)) {
        return true;
    } else
        return false;
}

static int findPar(int a) {
    if (arr[a] == a)
        return a;
    else {
        return arr[a] = findPar(arr[a]);
    }
}
```

---

### 피드백 👩‍🏫
easy~