Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/11003


### 풀이
---
### 📄 1단계 문제 분석하기
---
- 이 문제를 해결하기 위해서는 덱을 사용해야 한다. 
- 우선 순위 Queue를 사용할 수도 있지만, 정렬과정에서 시간 초과가 발생한다. 


<br>

### 🤘 2단계 손으로 풀기
---

진행과정을 순서대로 나열해보자.


<img width="250" alt="image" src="https://github.com/2-say/Algorithm_Study/assets/91319157/43003fb4-6427-4fd5-8493-eb150ba875af">

L크기의 맞게 DeQueue를 만들자. 

[1회전]
<img width="838" alt="image" src="https://github.com/2-say/Algorithm_Study/assets/91319157/d0c8b2a8-a3f2-407f-af47-8677d89d467f">

[2회전]
<img width="857" alt="image" src="https://github.com/2-say/Algorithm_Study/assets/91319157/d14ffb2a-9e49-4801-9f81-1dacd624f330">

[3회전]
<img width="867" alt="image" src="https://github.com/2-say/Algorithm_Study/assets/91319157/d35b4d03-af06-403b-bd4d-6c5874865795">

- 2를 입력했을 때, 5>2 이므로 5는 삭제하고 2를 대입한다. 
- window size(3) 을 벗어나면 맨 앞 원소를 삭제한다. 

이렇게 비교해서 작으면 넣고 크면 삭제한다. 범위를 지정해서 중복 검사하지 않도록 슬라이딩 알고리즘을 사용하면 시간 복잡도가 감소한다. 



<br>

### 👀 3단계 code 분석 
---
1. 마지막 원소와 넣은 원소 비교하기 [3회전]그림과 같은 상황

```
while(!myDeque.isEmpty() && myDeque.peekLast()[0] > now){ 
                myDeque.pollLast(); //뒤에서 제거
            }
```
- 즉, 덱 안에 원소가 있고 비교했을 때, 덱 안 원소가 더 크면  뒤에서 제거한다는 뜻 

<br><br>



2. Window size 벗어난 경우 맨 앞 삭제

``` 
if(myDeque.peekFirst()[1] <= (i-L)){
                myDeque.removeFirst();
            }
```
[3회전] 그림 중 맨 밑에 경우이다.
슬라이딩은 범위를 지정해서 한칸씩 오른쪽으로 이동한다. 이를 반영한 것이다. 



<br><br><br>


---

### 피드백 👩‍🏫
알고리즘 자체는 알고 있었지만, 같은 알고리즘이라도 자료구조가 다르면 시간 복잡도가 다르게 나타나는 것을 알 수 있었다. (시간초과)

<br>

그리고 Deque는 함수 사용이 미숙해 풀이하는 데 어려움을 느꼈고 

```
myDeque.offer(new int[] {now,i});
```
원소를 배열로 넣을 수 있다는 생각이 한번에 떠오르지 않아서 많이 풀이가 오래걸렸던 것 같다. 

저런 사소한 기술과 여러가지 자료구조의 함수의 대략적인 기능을 암기해야겠다. 