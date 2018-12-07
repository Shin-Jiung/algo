#백준 2178 미로 bfs dfs로 구현
#단 dfs는 목적지에 도착을 해도 다른 경우의 수가 있는 지 확인 하기 위해서 더 많은 반복을 하기 때문에 시간 초과가 난다.
#dfs로도 이러한 방식이 있다만 알면 된다.

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
	static int[][] arr;
	static int[][] visit;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0}; 
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		visit = new int[n][m];
		for(int i=0;i<n; i++){
			String a = sc.next();
			for(int j=0; j<m; j++){
				arr[i][j] = a.charAt(j)-'0';
			}
		}  
		//bfs(0,0);
		min = Integer.MAX_VALUE;
		dfs(0,0,1);
		System.out.println(min);
	}
	
	static void dfs(int x, int y, int len){
		if(x==n-1 && y == m-1){
			min = Math.min(min, len);
		}
		visit[x][y] = 1;
		for(int k=0; k<4; k++){
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx>=0 && nx<n && ny>=0 && ny<m){
				if(visit[nx][ny] == 0 && arr[nx][ny] == 1){
					dfs(nx,ny,len+1);
				}
			}
		}
		visit[x][y] = 0;
	}
	
	
	
	static void bfs(int x, int y){
		Queue<pair> q = new LinkedList<pair>();
		q.add(new pair(x,y));
		visit[x][y] = 1;
		while(!q.isEmpty()){
			pair p = q.remove();
			if(p.x == n-1 && p.y == m-1)
			{
				System.out.println(visit[n-1][m-1]);
				return;
			}
			
			for(int k =0; k<4; k++){
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<m){
					if(visit[nx][ny] == 0 && arr[nx][ny] == 1){
						q.add(new pair(nx,ny));
						visit[nx][ny] = visit[p.x][p.y] + 1;
					}
				}
			}
		}
	}
	
	
}
