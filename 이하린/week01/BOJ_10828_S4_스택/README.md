`자료구조` 

<h3> 백준 10828번 실버4 스택 문제 </h3>

- `push` 말고 다른 명령어는 그냥 `equals 함수`로 처리해주었음.
- push를 입력받을 때 `split("")` 함수를 사용해서 배열로 입력받을까? 하다가 `substring 함수`를 쓰는게 더 간편할 것 같아서 `substring 함수` 사용
  - 만약 `cmd.substring(0,4).equals("push")` 라면 공백 후 숫자가 나올텐데, 해당 숫자를 list에 add하면 된다!
    - 해당 숫자를 가져오기 위해서는 `cmd.substring(5, cmd.length())` 로 한 번더 문자열을 잘라줘야 한다.
    - 또, `Integer.parseInt`를 통해 Integer 타입으로 변환이 필요
