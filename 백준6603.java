#백트레킹

import java.util.*;

public class Solution {
	static int n;
	static int[] map;
	static int[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			if(n == 0){
				break;
			}
			map = new int[n];
			visit = new int[n];
			for(int i=0; i<n; i++){
				map[i] = sc.nextInt();
			}
			go(0,0);
			System.out.println();
		}
	}

	static void go(int v,int len){
		if(len == 6){
			for(int i=0; i<n; i++){
				if(visit[i] == 1){
					System.out.print(map[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		
		
		for(int i=v; i<n; i++){
			visit[i] = 1;
			go(i+1,len+1);
			visit[i] = 0;
		}
		
	}
}
