package week01.BOJ_10828_S4_스택;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_10828_S4_스택 {
	
	private static List<Integer> myStack = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("input_10828.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int cmdN = Integer.parseInt(in.readLine());
		
		while(cmdN-- > 0) {
			//inputLine
			String line = in.readLine();
			String[] lineArr = line.split(" ");
			String cmd = lineArr[0];
			int num = 0;
			if (lineArr.length > 1)
				num = Integer.parseInt(lineArr[1]);
			
			//cmd check
			switch(cmd) {
			case "push":
				push(num);
				break;
			case "pop":
				pop();
				break;
			case "size":
				printSize();
				break;
			case "empty":
				printIsEmpty();
				break;
			case "top":
				printTop();
				break;
			}
		}
	}
	
	private static void push(int num) {
		myStack.add(num);
	}
	
	private static void pop() {
		int lastNum = -1; //비어있으면 -1 출력
		if (!myStack.isEmpty()) {
			lastNum = myStack.get(myStack.size() - 1);
			myStack.remove(myStack.size() - 1);	
		}
		System.out.println(lastNum);
	}
	
	private static void printSize() {
		System.out.println(myStack.size());
	}
	
	private static void printIsEmpty() {
		int isEmpty = 0;
		if (myStack.isEmpty()) {
			isEmpty = 1;
		}
		System.out.println(isEmpty);
	}
	
	private static void printTop() {
		int top = -1;
		if (!myStack.isEmpty()) {
			top = myStack.get(myStack.size() - 1);
		}
		System.out.println(top);
	}
}
