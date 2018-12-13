#위상정렬의 심화 버젼
#위상정렬을 하면서 선행되어야 하는 조건을 완수한 이후의 정렬
#건물을 짓기 위해서 다른 건물을 먼저 지어야 할 수도 있기 때문

import java.util.*;


public class Solution {
	static int n;
	static Vector<Integer>[] a;
	static int[] inDegree;
	static int[] time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new Vector[n+1];
		for(int i=0; i<=n; i++){
			a[i] = new Vector<>();
		}
		inDegree = new int[n+1];
		time = new int[n+1];
		
		for(int i=1; i<=n; i++){
			int t = sc.nextInt();
			time[i] = t;
			while(true){
				int num = sc.nextInt();
				if(num == -1) break;
				a[num].add(i);
				inDegree[i]++;
			}
		}

		toplogySort();
		
	}
	
	static void toplogySort(){
		int[] result = new int[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=n; i++){
			if(inDegree[i]==0){ 
				result[i] = time[i]; // 시간을 모두 초기화 시켜준다.
				q.add(i);
			}
		}
		
		for(int i=1; i<=n; i++){
			if(q.isEmpty()){
				System.out.println("사이클 발생");
				return;
			}
			int x = q.remove();
			for(int j=0; j<a[x].size(); j++){
				int y = a[x].get(j);
        // 노드로 들어오는 간선중에 가장 큰 값을 선택해야 하는 부분. -->핵심<--
				result[y] = Math.max(result[y], result[x] + time[y]); 
				if(--inDegree[y] == 0) q.add(y);
			}
			
		}
		
		for(int i=1; i<=n; i++){
			System.out.print(result[i]+" ");
		}
		
	}

	
}
