//문제에서 "어떤 사람은 이 시간에 만나기 위하여 1분도 쉬지 않고 달려야 한다." 이 뜻은 최장거리를 의미한다.
/*
 * 문제 의도
 * 1. 출발지 부터 도착지까지 최장거리를 구하여라
 * 2. 최장거리를 거치는 노드의 갯수를 구하여라
 * 3. 최장거리를 거치는 노드를 구하기 위해서는 역추적을 해야한다.*/

import java.util.*;

class pair {
	int point;
	int time;

	pair(int a, int b) {
		this.point = a;
		this.time = b;
	}
}

public class Solution {
	static int n;
	static int m;
	static Vector<pair>[] a; // 정방향
	static Vector<pair>[] b; // 역방향 추적
	static int[] inDegree;
	static int[] c; // 역추적할때 노드를 방문했는지 안했는지 확인하는 변수
	static int[] result;
	static int start;
	static int end;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new Vector[n + 1];
		b = new Vector[n + 1];
		for (int i = 0; i < n + 1; i++) {
			a[i] = new Vector<>();
			b[i] = new Vector<>();
		}
		inDegree = new int[n + 1];
		c = new int[n + 1];
		result = new int[n + 1];

		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int t = sc.nextInt();
			a[s].add(new pair(e, t));
			b[e].add(new pair(s, t));
			inDegree[e]++;
		}
		start = sc.nextInt();
		end = sc.nextInt();
		toplogySort();

	}

	static void toplogySort() {
		Queue<Integer> q = new LinkedList<Integer>();
		// 시작점 노드를 큐에 삽입
		q.add(start);
		// 더 이상 방문할 노드가 없을 때까지
		while (!q.isEmpty()) {
			int x = q.remove();
			for (int i = 0; i < a[x].size(); i++) {
				pair y = new pair(a[x].get(i).point, a[x].get(i).time);
				if (result[y.point] <= y.time + result[x]) {
					result[y.point] = y.time + result[x];
				}
				// 새롭게 진입차수가 0이 된 정점을 큐에 삽입
				if (--inDegree[y.point] == 0) {
					q.add(y.point);
				}
			}
		}
		// 결과를 역추적
		int count = 0;
		q.add(end);
		while (!q.isEmpty()) {
			int y = q.remove();
			for (int i = 0; i < b[y].size(); i++) {
				pair x = new pair(b[y].get(i).point, b[y].get(i).time);
				// 최장 경로에 포함되는 간선인지 확인한다.
				if (result[y] - result[x.point] == x.time) {
					count++;
					// 큐에는 한번씩 담아 추적
					if (c[x.point] == 0) {
						q.add(x.point);
						c[x.point] = 1;
					}
				}
			}
		}
		System.out.println(result[end] + " " + count);
	}
}
