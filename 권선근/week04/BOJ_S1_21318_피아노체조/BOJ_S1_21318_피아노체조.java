import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
  // 실수 구간합 배열
	static int[] mistake_sum;
  // 악보 난이도 배열
	static int[] levels;
	static int N , Q;
  // 질문 배열
	static Question[] questions;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
    // 입력부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mistake_sum  = new int[N];
		levels = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Q = Integer.parseInt(br.readLine());
		questions = new Question[Q];
		sb = new StringBuilder();
		
		for(int i=0;i<Q;i++) {
			int question[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			questions[i] = new Question(question[0] , question[1]);
		}
		
	  // 구간 합 만들기
		makeSums();
		
    // 주어진 각 질문에 대한 실수 구하기
		for(int i=0;i<Q;i++) {
      // 악보는 1번 악보부터로 주어지는데
      // 배열은 0부터 저장해서 여기서 1을 빼줬다.
			countMistake(questions[i].start-1 , questions[i].end-1);
		}
		
		System.out.println(sb.toString());
		
		
	}
  
  // 주어진 구간에 대한 실수합 계산하기
	private static void countMistake(int start, int end) {
		int count = 0;
    // 주어진 마지막 곡이 끝난 시점의 실수 구간합 - 주어진 시작 피아노곡 이전까지의 실수 구간합
    // = 구하고자 하는 구간의 실수합이다.
    // 처음 곡부터의 구간합을 구하려고 한다면 start-1곡이 없으므로 구분해서 처리한다.
		if(start != 0) {
			start--;
			count = mistake_sum[end] - mistake_sum[start];
		}
		else {
			count = mistake_sum[end];
		}
		
    // 마지막 곡은 무조건 성공하므로
    // 실패로 계산했던 부분을 보전해준다.
		if(end+1 < N && levels[end] > levels[end+1]) {
			count--;
		}
		sb.append(count + "\n");
	}
  
  // 실수 구간합 만들기
	private static void makeSums() {
    // 간단하다!
    // 악보난이도 배열을 처음부터 순회하면서
    // 다음 곡 난이도 보다 지금곡의 난이도가 높으면
    // 실수하는것을 반영해주면 끝.
    
    // N번쨰 곡은 다음곡이 없으므로
    // 0번쨰부터 지금곡의 실수 판정 이후에 
    // 그 실수 구간합을 다음 구간합에 넣어줬다.
		for(int i=0;i<N-1;i++) {
			if(levels[i] > levels[i+1]) {
				mistake_sum[i]++;
				
			}
			mistake_sum[i+1] = mistake_sum[i];
		}
	}
}

class Question {
	int start;
	int end;
	Question(int s , int e) {
		start = s;
		end = e;
	}
}
