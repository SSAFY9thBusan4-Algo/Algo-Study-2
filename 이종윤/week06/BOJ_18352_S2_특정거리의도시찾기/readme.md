## 문제 접근 ##
1. 도시 X로부터 연결된 도시를 거치며 최단거리가 K인 도시들을 찾는다

## 코드 해석 ##
1. 도시 X로부터 연결된 도시들을 순회하며 각 도시까지의 최단거리를 구한다.
2. 도시끼리의 연결 여부를 인접 리스트로 관리하고 최단거리는 BFS 탐색을 통해 구한다.
3. X로부터 최단거리가 K인 도시들을 출력하며 최단거리가 K인 도시가 없을 경우 -1을 출력한다.
