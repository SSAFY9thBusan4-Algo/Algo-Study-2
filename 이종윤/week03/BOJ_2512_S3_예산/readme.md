# 문제 접근 #
1. 입력 받은 예산요청 중 일부는 상한치를 적용하여 국가예산을 넘지 않도록 해야 한다.
2. 상한이 적용되는 예산은 예산요청이 큰 것부터 적용되므로 오름차순 정렬하여 정리한다.
3. 예산 상한이 적용되어야 할 기준을 찾고 상한을 줄여나가며 국가예산 이내에 맞춘다.

예) 예산요청이 1, 2, 3, 4 일 때, 국가 예산이 85라면
|예산상한|10|20|30|40|총합|
|:---:|---|---|---|---|---|
|10|10|10|10|10|40|
|20|10|20|20|20|70|
|30|10|20|30|30|90|
|29|10|20|29|29|88|
|28|10|20|28|28|86|
|27|10|20|27|27|**84**|

예산 상한이 30일 때부터 국가 예산을 초과하므로 예산요청이 30을 넘어가는 예산에 대해서 상한을 적용해 상한치를 1씩 줄여가며 국가 예산에 맞춤

# 코드 해석 #
1. 우선 예산들을 입력받고 오름차순으로 정렬한다.
2. 예산상한을 요청받은 예산이 작은 순으로 설정하며 총 예산이 국가 예산을 초과할 때까지 상한을 늘린다.
3. 만약 상한을 적용하지 않아도 국가예산을 초과하지 않으면 가장 큰 예산요청을 출력한다.
4. 상한을 적용해야 할 국가 예산을 초과하지 않을 때까지 상한을 1씩 줄여가며 최대 상한을 찾는다.
