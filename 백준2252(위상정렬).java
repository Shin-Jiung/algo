

import java.util.*;


public class Solution {
	static int n;
	static int m;
	static Vector<Integer>[] a;
	static int[] inDegree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new Vector[n+1];
		for(int i=0; i<=n; i++){
			a[i] = new Vector<>();
		}
		inDegree = new int[n+1];
		for(int i=0; i<m; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			inDegree[v]++;
		}
		
		toplogySort();
		
	}
	
	static void toplogySort(){
		int[] result = new int[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=n; i++){
			if(inDegree[i]==0) q.add(i);
		}
		
		for(int i=1; i<=n; i++){
			if(q.isEmpty()){
				System.out.println("사이클 발생");
				return;
			}
			int x = q.remove();
			result[i] = x;
			for(int j=0; j<a[x].size(); j++){
				int y = a[x].get(j);
				if(--inDegree[y] == 0) q.add(y);
			}
			
		}
		
		for(int i=1; i<=n; i++){
			System.out.print(result[i]+" ");
		}
		
	}

	
}
