`자료구조`

<h3> 백준 1620번 실버4 나는야 포켓몬 마스터 이다솜 문제 </h3>

👀 첫 번째 풀 때
- `hashmap`을 하나만 생성함
  ```
  HashMap<Integer, String> pocketMons = new HashMap<Integer, String>();
  ```
  - 이렇게 생성하면 번호를 통해 이름을 찾는 과정에선(`get(key)`) 시간이 별로 안 걸렸다..
  - 하지만, 이름(value)을 통해 번호(key)를 찾는 과정을 구현하기 위해서 for문을 사용하니 시간복잡도 O(N)이 되어서 `시간초과` 오류가 떴다 ... 😢
  - 어떻게 할까 고민하다가 .. 그냥 해시맵을 두개 만들었음.
  
👀 두 번째 풀 때
- `hashmap` 생성, 그리고 `arrayList` 생성
    ```
    HashMap<String, Integer> pocketName = new HashMap<String, Integer>();
	List<String> pocketNum = new ArrayList<String>();
    ```
     - 처음엔 `HashMap<Integer, String>` `HashMap<String, Integer>` 타입으로 두 개의 해시맵을 생성했었다.
     - 하지만, 생각해보니 `HashMap<Integer, String>` 타입은 굳이 맵으로 안 만들고 `arrayList`로 만들어도 괜찮지 않을까 싶어서 arrayList로 만들었다.
        - `arrayList`의 인덱스가 Integer 키의 역할을 대신할 것이라 생각함.
     - 그렇게 구현하니까 시간 초과 오류 안뜨고 성공!! 👍 
