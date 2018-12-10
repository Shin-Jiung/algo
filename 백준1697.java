#bfs

import java.util.*;

public class Main {
	static int n;
	static int k;
	static Queue<Integer> q;
	static int[] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		k = scan.nextInt();
		q = new LinkedList<Integer>();
		visit = new int[200000];
		
		
		q.add(n);
		while(!q.isEmpty()){
			int num = q.remove();
			if(num == k){
				System.out.println(visit[num]);
                break;
			}
			
			if(num-1>=0 && visit[num-1] == 0){
				q.add(num-1);
				visit[num-1] = visit[num]+1;
			}
			if(num+1 < 200000 && visit[num+1] == 0){
				q.add(num+1);
				visit[num+1] = visit[num]+1;
			}
			if(num*2>=0 && num*2 < 200000 && visit[num*2] == 0){
				q.add(num*2);
				visit[num*2] = visit[num]+1;
			}
			
		}
		
		
	}

}
