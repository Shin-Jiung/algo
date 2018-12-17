# 그리디 알고리즘 문제

/*
 * 그리디 알고리즘은 기본적으로 무조건 큰 경우대로, 무조건 작은 경우대로, 무조건 긴 경우대로, 무조건 짧은 경우대로 등으로
 * 극단적으로 문제에 접근한다는 점에서 정렬(Sort) 기법이 함께 사용되는 경우가 많습니다. 
 * 그 대표적인 예시가 우리가 이전에 다루어보았던 크루스칼(Kruskal) 알고리즘으로 모든 간선을 정렬한 이후에
 * 짧은 간선부터 연결하는 최소 비용 신장 트리 알고리즘*/

import java.util.*;

class pair{
	int a;
	int b;
	pair(int a, int b){
		this.a = a;
		this.b = b;
	}
}

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			Vector<pair> v = new Vector<>();
			for(int i=0; i<n; i++){
				v.add(new pair(sc.nextInt(), sc.nextInt()));
			}
			Collections.sort(v, new Comparator<pair>() {

				@Override
				public int compare(pair o1, pair o2) {
					// TODO Auto-generated method stub
					return o1.a - o2.a;
				}
			});
			int result = 0;
			int Min = Integer.MAX_VALUE;
			for(int i=0; i<v.size(); i++){
				int y = v.get(i).b;
				if(y < Min){
					Min = y;
					result++;
				}
			}
			
			System.out.println(result);
			
		}
		
	}//end main

}//end Solution
