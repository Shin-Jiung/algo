#플로이드 와샬
#모든 정점에서 모든 정점으로의 최단경로 구하는 것 -> 플로이드 와샬 알고리즘
import java.util.*;

public class Solution {
	static int number = 4;
	static int INF = 10000000;
	static int[][] a = new int[][]{
		{0,5,INF,8},
		{7,0,9,INF},
		{2,INF,0,4},
		{INF,INF,3,0}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		floydWarshall();
	}
	static void floydWarshall(){
		//결과 그래프를 초기화
		int[][] d = new int[number][number];
		for(int i=0; i<number; i++){
			d[i] = Arrays.copyOf(a[i], number);
		}
		
		//k = 거쳐가는 노드
		for(int k=0; k<number; k++){
			// i = 출발노드
			for(int i=0; i<number; i++){
				//j = 도착노드
				for(int j=0; j<number; j++){
					if(d[i][k] + d[k][j] < d[i][j]){
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
		
		for(int i=0; i<number; i++){
			for(int j=0; j<number; j++){
				System.out.print(d[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
