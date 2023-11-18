Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/11720


### 풀이
---
### 📄 1단계 문제 분석하기
---
- 범위가 1부터 100까지 이므로 int로 담는 것이 적합  
- 문자열의 형태로 받고 한개씩 분류하기 위해 Char -> 계산을 위해 int형으로 변환

<br>

### 🤘 2단계 손으로 풀기
---
생략

<br>

### 👀 3단계 code 분석 
---
1.N 값 입력 받기  , 숫자값 String 입력 받기 : GET snum

```
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int num = Integer.parseInt(br.readLine());
tring snum = br.readLine();
```

buffer로 입력 받는 것이 더 빠르다. 

<br>

2.문자열을 하나씩 저장하기 위해 Type 변환
```
char[] cnum = snum.toCharArray();
```

<br>

3.계산을 위해 char -> int로 변경 후 모두 기록 저장

```
 for(int i = 0 ; i < cnum.length; i++)
        {
            reuslt += cnum[i]- '0';
        }
```
<br>

---

### 피드백 👩‍🏫
char type에서 int로 변환할 때, Inter.parseInt(); 를 사용하려고 했지만, 이는  유니코드 값을 정수로 변환하기 때문에 사용할 수 없다. 따라서 Char -> Int 형으로 변환할 때는 

1. 
```
char c = '1';
int n = c - '0';
```
2. 
```
char c = '1';
int n = Character.getNumericValue(c);
```

이 방법을 사용해보자