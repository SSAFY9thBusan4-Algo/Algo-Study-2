수업시간에 배웠던 중복순열 만들기와 완전히 같은문제이다.
복습한다는 생각으로 풀었다.

N개의 자연수로 이루어진 후보배열 numbers

배열에 후보수를 하나씩 넣어서 순열을 만들기 위해 사용하는 now 배열을 사용한다.

now 배열을 M개 채울떄까지 cnt를 증가시키면서
now[cnt] 에 가능한 후보를 하나씩 모두 넣고 재귀를 반복한다.

