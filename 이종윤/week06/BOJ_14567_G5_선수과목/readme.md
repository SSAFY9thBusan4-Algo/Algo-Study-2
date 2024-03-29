## 문제 접근 ##
1. 선수과목을 모두 이수하지 않으면 해당 과목을 이수할 수 없다.
2. 한 학기에 수강할 수 있는 과목 수에 제한은 없다.
3. 선수과목이 없는 과목부터 시작해서 매 학기마다 이수 조건을 만족하는 과목들의 이수 여부를 갱신해 나간다.

## 코드 해석 ##
1. 매 학기마다 선수 조건을 확인하고 이수 여부를 갱신하기 때문에 DP를 이용해 문제를 해결했다.
2. 각 과목의 선수과목 이수여부를 확인하고 하나라도 이수하지 못했다면 이수하지 못한다.
3. 선수과목을 모두 이수한 경우 해당 학기를 이수 학기로 기록하고 이수 여부도 기록한다.
4. 이미 이수한 과목의 경우 마찬가지로 선수과목을 확인하지 않고 이수로 기록한다.
5. 해당 학기에 이수한 과목의 수가 N개가 될 때까지 반복한다.
