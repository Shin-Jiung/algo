
import java.util.*;


public class Solution {
	static int MAX = 52;
	static int INF = 1000000000;
	static int n;
	static Vector<Integer>[] a;
	static int[] d;
	static int[][] c;
	static int[][] f;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new Vector[MAX];
		for(int i=0; i<MAX; i++){
			a[i] = new Vector<>();
		}
		d = new int[MAX];
		c = new int[MAX][MAX];
		f = new int[MAX][MAX];
		result = 0;
		for(int i=0; i<n; i++){
			int u = CtoI(sc.next().charAt(0));
			int v = CtoI(sc.next().charAt(0));
			int w = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
      //왜 여기가 +w인지 인지해야 하는 문제 (양 방향이고 파이프가 합쳐질수 있다는 점) 
			c[u][v] += w;
			c[v][u] += w;
		}
		
		maxFlow(0,25);
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
					if(d[y] == -1 && c[x][y] - f[x][y] > 0){
						q.add(y);
						d[y] = x;
						if(y==end)break;
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
	
	
	
	
	
	
	static int CtoI(char c){
	    if(c <= 'Z') return c - 'A';
	    return c - 'a' + 26;
	}
	
}
