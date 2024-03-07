Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/9252
s
### 풀이
---
### 📄 1단계 문제 분석하기
---
- DP 풀기 위해서 전수조사를 진행한다. 시간초과가 난다면 그 상태에서 이전값을 저장할 memo 값을 저장.
- Tabulation으로도 풀 수 있지만, 점화식을 떠올리는 것은 어려웠다.  

<br>

### 🤘 2단계 손으로 풀기
---
- 먼저 크게 두 가지 경우로 나눌 수 있다.

1. 두 문자열이 같을 경우

이 경우에는 문자열이 같으므로 두 index를 증가 시켜 다음 문자열부터 확인한다. 

2. 두 문자열이 다를 경우

두 문자열이 다를 경우 2가지 행동을 할 수 있다. <br>
(1). 첫번째 문자열의 index를 1 증가해서 다시 해보기 <br>
(2). 두번째 문자열의 index를 1 증가해서 다시 해보기 <br>

이렇게 둘 중 하나의 index가 범위를 벗어날 경우 종료를 해주면 끝.

<br>

이 로직을 재귀로 만들어주면 된다.

### 👀 3단계 code 분석 
---
```
if (i == s1.length || j == s2.length)
    return "";
if (s1[i] == s2[j])
    return s1[i] + solve(i + 1, j + 1);
else {
    String tmp1 = solve(i + 1, j);
    String tmp2 = solve(i, j + 1);
    return tmp1.length() > tmp2.length() ? tmp1 : tmp2;
}

```
<br>

이게 전부다.

<br>

1. 종료 조건 
```
if (i == s1.length || j == s2.length)
    return "";
```
이미 다른 코드에서  return 부분 결과값 + 을 해줬기 때문에 ""을 리턴해준다. 

2. 같을 경우
```
else {
    String tmp1 = solve(i + 1, j);
    String tmp2 = solve(i, j + 1);
    return tmp1.length() > tmp2.length() ? tmp1 : tmp2;
}
```
index를 각각 늘려서 재귀를 들어간다. 그러면 끝까지 들어간다면 결과값이 return 될 것이고, return값에서 
return tmp1.length() > tmp2.length() ? tmp1 : tmp2; 가장 긴 것만 다시 return 해주면 된다.

<br>

---

### 피드백 👩‍🏫
없음.

