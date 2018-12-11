#크루스칼 알고리즘
#합집합을 사용

import java.util.*;

class Edge{
	int[] node = new int[2];
	int distance;
	Edge(int a, int b, int distance){
		this.node[0] = a;
		this.node[1] = b;
		this.distance = distance;
	}
}


public class Solution {
	static int[] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 7;
		Vector<Edge> v = new Vector<>();
		v.add(new Edge(1,7,12));
		v.add(new Edge(1,4,28));
		v.add(new Edge(4,7,13));
		v.add(new Edge(4,2,24));
		v.add(new Edge(1,2,67));
		v.add(new Edge(7,5,73));
		v.add(new Edge(1,5,17));
		v.add(new Edge(2,5,62));
		v.add(new Edge(5,6,45));
		v.add(new Edge(5,3,20));
		v.add(new Edge(6,3,37));
		
		Collections.sort(v, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stu
				return o1.distance - o2.distance;
			}

		});;
		
	
		map = new int[n+1];
		for(int i=1; i<=n; i++){
			map[i] = i;
		}
		
		int sum = 0;
		for(int i=0; i<v.size(); i++){
			if(!findParent(v.get(i).node[0], v.get(i).node[1])){
				sum+=v.get(i).distance;
				union(v.get(i).node[0],v.get(i).node[1]);
			}
		}
		
		System.out.println(sum);
	}
	
	static int getParent(int x){
		if(map[x] == x) return x;
		return map[x] = getParent(map[x]);
	}
	
	static void union(int a, int b){
		a = getParent(a);
		b = getParent(b);
		if(a < b) map[b] = a;
		else map[a] = b;
	}
	
	static boolean findParent(int a, int b){
		a = getParent(a);
		b = getParent(b);
		//합집합에서는 같으면 노드끼리 연결되어 있다는 뜻
		//크루스칼에서는 같으면 사이클이 생긴다는 뜻이다.
		if(a == b) return true;
		else return false;
	}
	

}
