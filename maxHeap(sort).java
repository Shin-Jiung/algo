
import java.util.*;

public class Solution {
	
	static int[] heap = new int[]{7,6,5,8,3,5,9,1,6};
	public static void main(String[] args) {
		//최대 힙
		for(int i=1; i<heap.length-1; i++){
			int c = i;
			do{
				int root = (c-1)/2;
				if(heap[root] < heap[c]){
					int temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				c = root;
			}while(c != 0);
		}
		for(int i= heap.length-1; i>=0; i--){
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			int root = 0;
			int c = 1;
			do{
				c = 2 * root + 1;
				if(c < i - 1 && heap[c] < heap[c + 1]){
					c++;
				}
				if(c<i && heap[root] < heap[c]){
					int temp2 = heap[root];
					heap[root] = heap[c];
					heap[c] = temp2;
				}
				root = c;
			}while(c<i);
		}
		
		
		
		for(int i=0; i<heap.length; i++){
			System.out.println(heap[i]+" ");
		}
		
		
	}
	
}
