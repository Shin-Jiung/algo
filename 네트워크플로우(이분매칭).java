//시간 복잡도 N^2
import java.util.*;


public class Solution {
	static int MAX = 101;
	static Vector<Integer>[] a;
	static int[] d;
	static boolean[] c;//<--visit
	static int n = 3;
	static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = new Vector[MAX];
		for(int i=0; i<MAX; i++){
			a[i] = new Vector<>();
		}
		d = new int[MAX];
		c = new boolean[MAX];
		a[1].add(1);
		a[1].add(2);
		a[1].add(3);
		a[2].add(1);
		a[3].add(2);
		int count =0;
		for(int i=1; i<MAX; i++){
			Arrays.fill(c, false);
			if(dfs(i)) {
				count++;
			}
		}
		System.out.println(count);
		for(int i=1; i<MAX; i++){
			if(d[i] != 0){
				System.out.println(d[i]+" -> "+i);
			}
		}
	}
	
	static boolean dfs(int x){
		for(int i=0; i<a[x].size(); i++){
			int y = a[x].get(i);
			
			if(c[y]) continue;
			c[y] = true;
			
			if(d[y] == 0 || dfs(d[y])){
				d[y] = x;
				return true;
			}
		}
		return false;
	}	
		
	
	


}
