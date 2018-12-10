#bfs 단지 번호 붙이기

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
	static int[][] map;
	static ArrayList<Integer> al;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		al = new ArrayList<>();
		for(int i=0; i<n; i++){
			String a = sc.next();
			for(int j=0; j<n; j++){
				map[i][j] = a.charAt(j) - '0';
			}
		}
		
		int count = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(map[i][j] != 0){
					bfs(i,j,map[i][j]);
					count++;
				}
			}
		}
		System.out.println(count);
		Collections.sort(al);
		for(int x : al){
			System.out.println(x);
		}
		
	}
	
	static void bfs(int i, int j,int num){
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		Queue<pair> q = new LinkedList<pair>();
		q.add(new pair(i,j));
		map[i][j] = 0;
		int tt = 1;
		while(!q.isEmpty()){
			pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int k=0; k<4; k++){
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<n){
					if(map[nx][ny] == num){
						q.add(new pair(nx,ny));
						map[nx][ny] = 0;
						tt++;
					}
				}
			}
		}
		al.add(tt);
		
	}
	

}
