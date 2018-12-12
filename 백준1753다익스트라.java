/*
 * 핵심적인 부분은 Vector<pair>[] vector = new Vector[10];
 *  for (int i = 0; i <= v; i++) {
 *    list[i] = new Vector<pair>();
 *  } 
 *
*/
package fsad;

import java.util.*;

class pair implements Comparable<pair>{
	int index;
	int distance;
	pair(int a, int b){
		this.index = a;
		this.distance = b;
	}
	@Override
	public int compareTo(pair o) {
		// TODO Auto-generated method stub
		return this.distance - o.distance;
	}
	
	
	
}


public class Solution {
	static int v;
	static int e;
	static int[] d;
	static Vector<pair>[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		d = new int[v+1];
		int start = sc.nextInt();
		
		for(int i=0; i<v+1; i++){
			d[i] =  999999;
		}
		
		
		////////
		list = new Vector[v + 1];
        for (int i = 0; i <= v; i++) {
            list[i] = new Vector<pair>();
        }
		////////
		
		for(int i=0; i<e; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			list[x].add(new pair(y,z));
		}

		dijkstra(start);
		
		for(int i=1; i<=v; i++){
			if(d[i]==999999){
				System.out.println("INF");
			}
			else{
				System.out.println(d[i]);
			}
		}
	}
	
	static void dijkstra(int start){
		d[start] = 0;
		PriorityQueue<pair> pq = new PriorityQueue<>();
		pq.add(new pair(start,0));
		while(!pq.isEmpty()){
			int current = pq.peek().index;
			int distance = pq.peek().distance;
			pq.remove();
			if(d[current] < distance) continue;
			for(int i=0; i<list[current].size(); i++){
				int next = list[current].get(i).index;
				int nextdistance = distance + list[current].get(i).distance;
				if(nextdistance < d[next]){
					d[next] = nextdistance;
					pq.add(new pair(next,nextdistance));
				}
			}
		}
	}


}
