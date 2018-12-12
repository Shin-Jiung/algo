/*
 * 강한 결합 요소 (Strongly Connected Component)
 * SCC 알고리즘
*/
import java.util.*;

public class Solution {
	static int id = 0;
	static int MAX = 10001;
	static int[] d = new int[MAX];
	static boolean[] finished = new boolean[MAX];
	static int[][] a = new int[MAX][MAX];
	static Vector<Vector<Integer>> SCC = new Vector<>();
	static Stack<Integer> s = new Stack<>();
	public static void main(String[] args) {
		
		int v = 11;
		a[1][2] = 2;
		a[2][3] = 3;
		a[3][1] = 1;
		a[4][2] = 2;
		a[4][5] = 5;
		a[5][7] = 7;
		a[6][5] = 5;
		a[7][6] = 6;
		a[8][5] = 5;
		a[8][9] = 9;
		a[9][10] = 10;
		a[10][11] =11;
		a[11][3] = 3;
		a[11][8] = 8;
		
		for(int i=1; i<=v; i++){
			if(d[i] == 0) dfs(i);
		}
		
		System.out.println("SCC 갯수: "+ SCC.size());
		for(int i=0; i<SCC.size(); i++){
			System.out.print(i+1+"번째: ");
			for(int j=0; j<SCC.get(i).size(); j++){
				System.out.print(SCC.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
	}

	static int dfs(int x){
		d[x] = ++id;
		s.add(x);
		
		int parent = d[x];
		for(int i=1; i<a[x].length; i++){
			int y = a[x][i];
			if(y!=0){
				if(d[y] == 0) parent = Math.min(parent, dfs(y));
				else if(!finished[y]) parent = Math.min(parent, d[y]);
			}
		}
		if(parent == d[x]){
			Vector<Integer> scc = new Vector<>();
			while(true){
				int t = s.pop();
				scc.add(t);
				finished[t] = true;
				if(t == x) break;
				
			}
			SCC.add(scc);
		}
		
		return parent;
	}
	
	
}
