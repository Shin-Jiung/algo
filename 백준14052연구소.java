#bfs
#백트레킹

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
	static ArrayList<pair> al;
	static int Max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		al =new ArrayList<>();
		Max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2){
					al.add(new pair(i,j));
					
				}
			}
		}
		setting(0,0);

		System.out.println(Max);
	}
	
	static void setting(int v, int len){
		if(len==3){
			bfs();
			return;
		}
		
		for(int i=v; i<n; i++){
			for(int j=0; j<m; j++){
				if(map[i][j] == 0){
					map[i][j] = 1;
					setting(i,len+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	
	static void bfs(){
		int[][] copy = new int[n][m];
		for(int i=0; i<n; i++){
			copy[i] = Arrays.copyOf(map[i], m);
		}
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		
		
		for(int i=0; i<al.size(); i++){
			Queue<pair> q = new LinkedList<pair>();
			q.add(new pair(al.get(i).x, al.get(i).y));
			copy[al.get(i).x][al.get(i).y] = 3;
			while(!q.isEmpty()){
				pair p = q.remove();
				int x = p.x;
				int y = p.y;
				for(int k=0; k<4; k++){
					int nx = x + dx[k];
					int ny = y + dy[k];
					if(nx>=0 && nx<n && ny>=0 && ny<m){
						if(copy[nx][ny] == 0 || copy[nx][ny] == 2){
							q.add(new pair(nx,ny));
							copy[nx][ny] = 3;
						}
					}
				}
			}
		}
		int count = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(copy[i][j] == 0 ){
					count++;
				}
			}
		}
		Max = Math.max(Max, count);
		
		
		
	}
	
	
}
