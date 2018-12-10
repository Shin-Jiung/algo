#합집합을 만들고 확인

import java.util.*;

public class Solution {
	static int[] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[9];
		for(int i=1; i<=8; i++){
			map[i] = i;
		}
		union(1,2);
		union(2,3);
		union(3,4);
		union(5,6);
		union(6,7);
		union(7,8);
		
		for(int i=1; i<=8; i++){
			System.out.print(map[i]+" ");
		}
		System.out.println();
		
		System.out.println(findParent(1, 4));
		
	}
	
	static int getParent(int x){
		if(map[x] == x) return x;
		return map[x] = getParent(map[x]);
	}
	
	static void union(int a, int b){
		a = getParent(a);
		b = getParent(b);
		if(a < b) map[b] = a;
		else map[a] = b;
	}
	
	static boolean findParent(int a, int b){
		a = getParent(a);
		b = getParent(b);
		if(a == b) return true;
		else return false;
	}
	

}
