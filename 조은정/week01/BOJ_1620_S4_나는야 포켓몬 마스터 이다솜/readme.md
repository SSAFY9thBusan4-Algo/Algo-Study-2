<h3> BOJ 1620 S4 나는야 포켓몬 마스터 이다솜 </h3>

👀 **문제 접근**
- N개의 String중에서 숫자를 입력받을 경우 index의 string출력 / string을 입력받을 경우 index 출력
- key-value 쌍으로 이루어진 hashmap사용, hashamap은 value값만 출력 가능하므로 map 2개 생성 -> hashmap<string,int> / hashmap<int,string> 
- M개의 입력받는 값을 key로 넘겨서 대응하는 value 출력