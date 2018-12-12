/* 위상정렬 
 * 1. 진입차수가 0인 정점을 큐에 삽입
 * 2. 큐에서 원소를 꺼내 연결된 모든 간선을 제거
 * 3. 간선 제거 이후에 진입차수가 0이 된 정점을 큐에 삽입
 * 4. 큐가 빌 때까지 2번 ~ 3번 과정을 반복, 모든 원소를 방문하기 전에 큐가 빈다면 사이클이 존재하는것, 
 * * 모든 원소를 방문했다면 큐에서 꺼낸 순서가 위상 정렬의 결과
 */
import java.util.*;

import org.omg.CORBA.INTERNAL;

public class Solution {
	static int n;
	static int MAX = 10;
	static int[] inDegree = new int[MAX];
	static int[][] a = new int[MAX][MAX];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 7; 
		a[1][2] = 2;
		inDegree[2]++;
		a[1][5] = 5;
		inDegree[5]++;
		a[2][3] = 3;
		inDegree[3]++;
		a[3][4] = 4;
		inDegree[4]++;
		a[4][6] = 6;
		inDegree[6]++;
		a[5][6] = 6;
		inDegree[6]++;
		a[6][7] = 7;
		inDegree[7]++;
		
		toplogySort();
		
	}
	
	static void toplogySort(){
		int[] result = new int[MAX];
		Queue<Integer> q = new LinkedList<Integer>();
		//진입 차수가 0인 노드를 큐에 삽입
		for(int i=1; i<=n; i++){
			if(inDegree[i] == 0) q.add(i);
		}
		//위상 정렬이 완전히 수행되려면 정확히 N개의 노드를 방문 해야한다.
		for(int i=1; i<=n; i++){
			//n개를 방문하기 전에 큐가 비면 사이클 발생
			if(q.isEmpty()){
				System.out.println("사이클 발생");
				return;
			}
			int x = q.remove();
			result[i] = x;
			for(int i2=1; i2<a[x].length; i2++){
				int y = a[x][i2]; //<- 각 노드에서 연결된 간선 확인.
				if(--inDegree[y]==0){
					q.add(y);
				}
			}
		}
		for(int i=1; i<=n; i++){
			System.out.print(result[i]+" ");
		}
	}
	
}
