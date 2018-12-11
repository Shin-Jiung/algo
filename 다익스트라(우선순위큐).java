#다익스트라 알고리즘
#우선순위 큐 사용
#java의 우선순위 큐는 최소힙 구조를 가진다.

import java.util.*;

class pair implements Comparable<pair>{
	int a;
	int b;
	pair(int a, int b){
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(pair o) {
		// TODO Auto-generated method stub
		return this.b - o.b;
	}
}


public class Solution {
	static int[][] a;
	static int[] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = new int[7][7];
		d = new int[7];
		
		for(int i=1; i<=6; i++){
			d[i] = 9999999;
		}
		a[1][2] = 2;
		a[1][3] = 5;
		a[1][4] = 1;
		
		a[2][1] = 2;
		a[2][3] = 3;
		a[2][4] = 2;

		a[3][1] = 5;
		a[3][2] = 3;
		a[3][4] = 3;
		a[3][5] = 1;
		a[3][6] = 5;

		a[4][1] = 1;
		a[4][2] = 2;
		a[4][3] = 3;
		a[4][5] = 1;

		a[5][3] = 1;
		a[5][4] = 1;
		a[5][6] = 2;

		a[6][3] = 5;
		a[6][5] = 2;

		dijkstra(1);
		
		
		
		for(int i=1; i<=6; i++){
			System.out.print(d[i]+" ");
		}
		System.out.println();
		
		
	}

	static void dijkstra(int start){
		d[start] = 0;
		PriorityQueue<pair> pq = new PriorityQueue<>();//힙구조
		pq.add(new pair(start,0));
		while(!pq.isEmpty()){
			int current = pq.peek().a;
			int distance = pq.peek().b;
			pq.remove();
			if(d[current] < distance) continue;
			for(int i=0; i< a[current].length; i++){
				if(a[current][i]!=0){
					int next = i;
					int nextDistance = distance + a[current][i];	
					if(nextDistance < d[next]){
						d[next] = nextDistance;
						pq.add(new pair(next,nextDistance));
					}
				}
			}
			
			
			
			
		}
	}
	
}
