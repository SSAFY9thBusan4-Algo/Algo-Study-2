import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  //starts 라고 했지만... 시작 부분과 끝부분 두 부분을 판정할떄 사용한다.
	static char starts[] = {'A','B','C','D','E','F'};
  // 중간 부분 판정용 배열
	static char middles[] = {'A' , 'F' , 'C'};
	static String line;
	static int size;
	//start A F C end
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= N; test_case++) {
			line = br.readLine();
			size = line.length();
			
      // 시작 부분을 체크한다!
			int s = checkStart(0);
			// s가 -1이면 시작부터 조건에 안맞다!
			if(s == -1) {
				sb.append("Good\n");
				continue;
			}
			// 중간부분 'A' 체크
			s = checkMiddle(s,0);
			if(s == -1) {
				sb.append("Good\n");
				continue;
			}
			// 중간부분 'F' 체크
			s = checkMiddle(s,1);
			if(s == -1) {
				sb.append("Good\n");
				continue;
			}
			// 중간부분 'C' 체크
			s = checkMiddle(s,2);
			if(s == -1) {
				sb.append("Good\n");
				continue;
			}
			// 마지막  {A, B, C, D, E, F}  체크
			if(checkEnd(s)) {
				sb.append("Infected!\n");
			} else {
				sb.append("Good\n");
			}
			
		}
		
		
		System.out.println(sb.toString());
	}

	
  // 문자열 중앙을 검사하는 함수
  // s : 비교를 시작한 인덱스
  // idx : A,F,C중 무엇인지 가르킨다.
	private static int checkMiddle(int s , int idx) {
		// 들어와야할 문자가 하나이상 있어야만 한다.
		if(line.charAt(s) != middles[idx]) {
			return -1;
		}
    // A,F,C가 연속되는 부분이 끝날떄까지 for문으로 스킵 처리해준다.
		for(int i=s+1;i<size;i++) {
      // 연속이 끝나는 부분을 리턴한다.
			if(line.charAt(i) != middles[idx]) {
				return i;
			}
		}
    // 위에서 리턴이 안됐다면 마지막 까지 진행되었다는 의미로 마지막 인덱스 리턴.
		return size-1;
	}



  // 시작부분 체크용 함수
	private static int checkStart(int s) {
    
    // 리턴값으로 checkMiddle이 처리한 시작부분을 넘겨줘야 해서
    // 다음으로 와야할 'A'문자는 0번부터 시작하도록 처리했다.
		if(line.charAt(0) == 'A') {
			return 0;
		}
    // BCDEF 중 하나가 나오면 조건에 맞으므로 1 리턴
    // 아니면 -1 리턴한다.
    // 조건에 따르면 BCDEF가 안나와도 되긴 하지만
    // 다음으로 A가 나와야만 하는데 이경우를 위에서 이미 처리했다.
		for(int i=1;i<6;i++) {
			if(line.charAt(0) == starts[i]) {
				return 1;
			}
		}
		return -1;
	}
	
  // 마지막 체크용 함수.
	private static boolean checkEnd(int s) {
    // 마지막이 {A, B, C, D, E, F} 중 하나로 끝나면 true 리턴한다.
    // 조건에 따르면 위 문자들이 하나도 없어도 되지만
    // 그경우에도 최소한 C가 마지막 문자라서 걸러진다.
		for(int i=0;i<6;i++) {
			if(line.charAt(s) == starts[i]) {
				return true;
			}
		}
		return false;
	}
}
