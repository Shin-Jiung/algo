#dfs

import java.util.*;

class pair{
	int x; 
	int y; 
	pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static int n;
	static int m;
	static int[][] map;
	static int[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n+1][n+1];
		visit = new int[n+1];
		for(int i=0; i<m; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			map[u][v] = 1;
			map[v][u] = 1;
 		}
		int count = 0;
		for(int i=1; i<=n; i++){
			if(visit[i]==0){
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
		
	}

	static void dfs(int v){
		visit[v] = 1;
		for(int i=1; i<=n; i++){
			if(visit[i] ==0 && map[v][i] == 1){
				dfs(i);
			}
		}
	}

}
