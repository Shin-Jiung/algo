#피보나치수열
#동적프로그래밍
#메모리제이션

import java.util.*;

public class Solution {
	static int[] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		d = new int[100];
		System.out.println(fibonacci(30));
	}
	
	//메모리제이션을 이용한 동적프로그래밍
	static int fibonacci(int x){
		if(x == 1) return 1;
		if(x == 2) return 1;
		if(d[x] != 0 )return d[x];
		return d[x] = fibonacci(x-1) + fibonacci(x-2);
	}

}
