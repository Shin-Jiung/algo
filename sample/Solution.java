package zzzz;
import java.util.Scanner;

class pair{
	int x;
	int y;
	int d;
	pair(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

class Solution {
	static int n;
	static int m;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static pair ro;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		ro = new pair(sc.nextInt(), sc.nextInt(), sc.nextInt());
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		map[ro.x][ro.y] = 2;
		count++;
		while(true){
			int num = togo();
			
			if(num == -1){
				int d = (ro.d+2)%4;
				int nx = ro.x + dx[d];
				int ny = ro.y + dy[d];
				if(nx>=0 && nx<n && ny>=0 && ny<m){
					if(map[nx][ny] == 1){
						break;
					}
					else{
						ro.x = nx;
						ro.y = ny;
					}
				}
				
			}

		}
		
		System.out.println(count);
		
	}

	static int togo(){
		int d = ro.d;
		for(int k=0; k<4; k++){
			d = (d+3)%4;
			int nx = ro.x + dx[d];
			int ny = ro.y + dy[d];
			if(nx>=0 && nx<n && ny>=0 && ny<m){
				if(map[nx][ny] == 0){
					ro.x = nx;
					ro.y = ny;
					ro.d = d;
					map[nx][ny] = 2;
					count++;
					return d;
				}
			}
		}
		
		return -1;
	}
}