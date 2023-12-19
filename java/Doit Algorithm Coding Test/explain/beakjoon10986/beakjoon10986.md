Do it! 알고리즘 코딩 테스트: 자바편 

https://www.acmicpc.net/problem/10986


### 풀이
---
### 📄 1단계 문제 분석하기
---
- 시간 제한은 2초이고 N의 최대 값은 10,000,000으로 매우 크게 잡혀있다. 이런 상황에서 O(NlogN)알고리즘은 사용할 수 없다. 

ex) 하나씩 접근 (0,1),(0,2),(0,3)...
- out of range 주의 

<br>

### 🤘 2단계 손으로 풀기
---

이 전에 구간합을 구하는 공식은 아래와 같았다. 
```
s[j] - s[i-1]  // i ~ j 까지의 합
```
우리는 i,j 까지의 합이 M으로 나눠떨어지는 확인해야함으로 다음 공식이 성립한다. 

```
( s[j] - s[i-1] )  % M  == 0  //0인 개수를 찾아라
```

그렇다면 전개해보자,

```
s[j] % M + s[i-1] % M  == 0  //이항하자 

s[j] % M == s[i-1] % M  //같은 개수를 찾아라
```

같은 개수를 중복없이 J가 큰 조건으로 찾으면 된다. 
그렇다면 여러개 값 중에서 n개를 선택하는 Combination 계산을 사용하면 된다.

또한, 여기서 같은 조건은 포함안되기 때문에 포함해야한다. 


ex) s{1,3,6,7,9} 일때 3,6,9 원소는 더하지 않아도 그 자체로 만족하기 때문에 3개를 포함 


즉, %M으로 나눴을 때, 0인 개수를 더한다. 



<br>

### 👀 3단계 code 분석 
---
1.구간합 구하기

```
//구간합 구하기 
        sarr[0]= Integer.parseInt(arrStrings[0]);
        cnt[sarr[0]%m]++;
        for (int i = 1 ; i< arrStrings.length; i++) {
            sarr[i] = (Integer.parseInt(arrStrings[i]) + sarr[i-1] + sarr[i]) % m ; 
            cnt[sarr[i]]++;
        }
```

M을 나눴을때 나올 수 있는 나머지는 0~M-1 이다. M-1 크기에 결과 배열을 만들어서 해당 값을 Count 해서 개수를 저장한다. 

<img width="172" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/e01c5410-83ed-4241-9557-349bbf8adc38">

<br><br>



2.M으로 나눠지는 원소값 개수 파악

``` 
 ans = cnt[0]; //개별로 나눈 값 개수도 추가 %M == 0 
```



<br><br><br>




3.결과 출력

```
   //콤비네이션 계산하기
        for(int i=0; i < m ; i++)
        {
            ans += (long)cnt[i] * (cnt[i]-1)/2;
        }
        System.out.println(ans);
```

정확한 결과를 위해서 (Long)으로 형변환을 해줬다.

콤비네이션 공식은 다음과 같다 

<img width="309" alt="image" src="https://github.com/2-say/algorithm-study/assets/91319157/76734f12-37ac-40af-897f-cb5b9876cce2">


<br>


---

### 피드백 👩‍🏫
처음엔 그저 모든 경우를 접근해서 문제를 해결하려고 했지만, 제한 시간을 확인하고 다시 풀게 되었다. 어떻게 풀 수 있을지 한참 생각했지만, 정말 어려워서 책을 확인했다. 

이렇게 부분합문제가 복잡하게 얽혀있다면, 손으로 수학 풀듯이 해봐야겠다. 

원소를 하나씩 분석해봐도 풀지 못하는 문제가 생각보다 많은 것 같다. 

더 열심히!
