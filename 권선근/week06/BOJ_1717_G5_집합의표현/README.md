BOJ 1717 G5 집합의 표현

유니온파인드를 구현하면 간단하게 해결 가능

N+1개 노드의 Boss 정보를 저장하는 배열 생성
초기에는 자기자신이 Boss 이다.

a 와 b의 합집합이 주어지면
a's final boss (root) = b's final boss(root)
대입하면 합집합 완성

a 와 b가 같은 집합인지 찾으라고 하면
if( a's final boss (root) == b's final boss(root))

최종보스 찾는법은 boss 배열을 사용해 트리를 거슬러 올라가는 것이다
