<h1><문제 접근></h1>

<h2>1. 중복조합??</h2>

마침 수업때 중복조합을 해서 적용될 것 같아서 재귀로 풀어봤다.

테케 답은 나오는데 백준 돌리니까 시간초과남

<h2>2. DP</h2>

DP가 너무 안익숙해서 찾아봤다...

문제를 많이 풀면서 익숙해져야겠다.


<h3><DP 풀이></h3>

<h4>1) int 배열 dp를 선언한다. </h4>

용도 : dp[i]는 숫자i를 만드는 방법의 수를 담고있다

크기 : money + 1 만큼의 크기를 할당한다.

우리가 구하고 싶은 값은 주어진 coin으로 money를 만드는 방법의 수이다. 따라서 0~money 까지의 값을 담아야 한다.

고로 크기는 money + 1로 설정.

<h4>2) 입력받은 coin을 하나씩 가져와서 다음을 수행한다.</h4>

2.0) dp[0] = 1. 

dp[0]은 동전을 가지고 0원을 만드는 방법의 수이다. 이는 '아무것도 사용하지 않는다'는 한 가지로 생각한다.

2.1) i = 'coin ~ money' 을 1씩 증가시키며, dp[i]에 dp[i-coin]을 더해준다.

첫 번째 coin을 대한 loop를 돈 후 dp 배열에는 첫 번쨰 coin만 가지고 각각의 i를 만들 수 있는 경우의 수를 담고 있다.

두 번째 coin에 대한 loop를 돈 후 dp 배열에는 앞서 구한 배열에 누적하여 값을 구하기 때문에, 첫 번쨰와 두 번째 coin을 가지고 각각의 i를 만들 수 있는 경우의 수를 담고 있다.

고로 마지막 coin까지 다 돌게 되면, 모든 코인을 가지고 각각의 i를 만드는 경우의 수를 다 담을 수 있게 되고,

여기서 dp[money]를 출력하면 우리가 원하는 답을 얻을 수 있따.


<h2>잊지말 것</h2>

1. 문제를 제대로 읽자..

처음에 문제를 잘못 읽고 동전의 합을 출력하는줄 알고 이상하게 풀어서 삽질했다..ㅠㅠ

2. dp문제는 표를 그리자..(가능한 차원 적게 하면 쉬움)

