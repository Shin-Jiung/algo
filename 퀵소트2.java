#퀵소트2

public class Solution {

	static int[] arr = new int[]{1,10,5,8,7,6,4,3,2,9};
	static int i = 0;
	public static void main(String[] args) {
		quicSort(0,arr.length-1);
		
	}
	
	static void quicSort(int start, int end){
		if(start>=end){//원소가 한개 있을때
			return;
		}
		
		int i = start+1;
		int j = end;
		int pivot = start;
		
		while(i <= j){
			
			while(i<=end && arr[i] <= arr[pivot]){
				i++;
			}
			while(j > start && arr[j] >= arr[pivot]){
				j--;
			}
		}
		//엇갈릿때
		if(i>j){
			int temp = arr[pivot];
			arr[pivot] = arr[i];
			arr[i] = temp;
		}
		else{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		quicSort(start, j-1);
		quicSort(j+1, end);
		
	}
	
}
