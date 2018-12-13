/*
 * 
 * 
*/
import java.util.*;


public class Solution {
	static int MAX = 100;
	static int INF = 1000000000;
	static int n = 6; 
	static int result = 0;
	static int[][] c = new int[MAX][MAX];
	static int[][] f = new int[MAX][MAX];
	static int[] d = new int[MAX];
	static Vector<Integer>[] a = new Vector[MAX];
	public static void main(String[] args) {
		for(int i=0; i<MAX; i++){
			a[i] = new Vector<>();
		}
		a[1].add(2);
		a[2].add(1);
		c[1][2] = 12;

		a[1].add(4);
		a[4].add(1);
		c[1][4] = 11;
		
		a[2].add(3);
		a[3].add(2);
		c[2][3] = 6;
		
		a[2].add(4);
		a[4].add(2);
		c[2][4] = 3;
		
		a[2].add(5);
		a[5].add(2);
		c[2][5] = 5;
		
		a[2].add(6);
		a[6].add(2);
		c[2][6] = 9;
		
		a[3].add(6);
		a[6].add(3);
		c[3][6] = 8;
		
		a[4].add(5);
		a[5].add(4);
		c[4][5] = 9;
		
		a[5].add(3);
		a[3].add(5);
		c[5][3] = 3;
		
		a[5].add(6);
		a[6].add(5);
		c[5][6] = 4;
		
		maxFlow(1,6);
		
		System.out.println(result);
		
	}
	
	
	static void maxFlow(int start, int end){
		while(true){
			Arrays.fill(d, -1);
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(start);
			while(!q.isEmpty()){
				int x = q.remove();
				for(int i=0; i<a[x].size(); i++){
					int y = a[x].get(i);
					if(d[y]==-1 && c[x][y] - f[x][y] > 0){
						q.add(y);
						d[y] = x;
						if(y == end) break;
					}
				}
			}
			if(d[end]==-1)break;
			int flow = INF;
			for(int i=end; i!=start; i=d[i]){
				flow = Math.min(flow, c[d[i]][i] - f[d[i]][i]);
			}
			
			for(int i=end; i!=start; i=d[i]){
				f[d[i]][i] += flow;
				f[i][d[i]] -= flow;
			}
			result += flow;
		}
		
	}
	


}
