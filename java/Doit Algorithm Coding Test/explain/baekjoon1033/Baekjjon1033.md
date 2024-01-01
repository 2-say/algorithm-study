Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/1033

### 풀이
---
### 📄 1단계 문제 분석하기
---
- 모든 비율값에 대해 최소 공배수를 구해야한다. 
- 얼핏 보면 그래프 노드와 비슷하게 생겼음을 확인할 수 있다.
<br>

### 🤘 2단계 손으로 풀기
--- 
1. 그래프에서 간선을 만드는 것처럼 노드와 간선, 비율을 저장한다. 

<br>

<img width="201" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/e5e88ae4-57e2-4027-95e1-657f4b9cbe7c">

<br>

2. 비율과 관련된 모든 최소 공배수를 계산한다.
계산식은 다음과 같다. 

lcm = lcm * ( p * q / gcd(p,q) );

<br> 이렇게 계산한 값은 모든 비율에 대한 최소 공배수 값이 나오므로 비율과 곱하면 값을 계산할 수 있다. 

<img width="290" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/38f80de1-685a-4d77-8722-7668c9dcb5fd">

그리고 마지막으로 계산된 값들이 또 나눠질 수도 있기 때문에 한번더 gcd(최대 공약수)로 나눈다. 

그러면 답 배열이 나온다.


<br>


### 👀 3단계 code 분석 
---
없음.

<br>




### 피드백 👩‍🏫
---

없음
