![image](https://user-images.githubusercontent.com/62701446/227222399-727b3d7f-01aa-4eee-8ca7-381517744955.png)

<h3> 문제 풀이 방법 </h3>

- 후위 표기식으로 계산하려면 연산자를 찾고 해당 연산자 앞 두 피연산자를 해당 연산자로 계산해주면 된다.
- 연산자를 찾으면 여태까지 저장해둔 피연산자를 꺼내서 사용해야하기 때문에 `스택` 을 사용한다.
- 또한 A B C ~ 알파벳에 대응하는 숫자를 꺼내와야 하기 때문에 `map` 자료구조를 사용하여 알파벳에 대응하는 숫자를 저장한다.

<h3> 회고 </h3>

구현하는 건 괜찮았는데 후위 표기식을 까먹어서 ... 😂 알고리즘 공부를 더 열심히 해야겠다 ...
