Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/1377

### 풀이


---
### 📄 1단계 문제 분석하기
---
- 제한시간 2초 , 데이터 크기 1,000,000 따라서 O(n^2) 알고리즘을 사용할 수 없음.
- 버블 정렬에서 해당 배열을 몇번째에서 완성되는가를 묻는 문제
<br>

### 🤘 2단계 손으로 풀기
---
버블 정렬 하는 과정을 살펴보자, 

<img width="400" alt="image" src="https://github.com/gihwanJang/ProblemSolversHub/assets/91319157/044d6076-3695-4155-b44e-23ad3f552049">
<br>
한 번 순회할 때 마다 선택 요소 외 왼쪽으로 1칸 씩 이동!

<br>

<img width="400" alt="image" src="https://github.com/gihwanJang/ProblemSolversHub/assets/91319157/3e4a101f-e0d4-4d2f-8966-8e96465a188c">
<br>
그렇다면 이 예시에서 2번 순회할 때 까지 변한다는 이야기이다. 
결과에서는 안 변하는 인덱스를 물어보았기 때문에 +1를 해주면 된다. 



### 👀 3단계 code 분석 
---
1. compareTo 정의  
index를 기억하게 만들기 위해서 클래스를 만들고 오름차순으로 정렬하게 만들기 위해서 Comparable을 구현했다. 

```
@Override
    public int compareTo(IndexedValue other) {
        return Integer.compare(this.value, other.value);
    }
```

<br>
---

### 피드백 👩‍🏫

없음.