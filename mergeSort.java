# mergeSort

public class Solution {
	
	static int[] sorted = new int[10];
	static int[] a;
	public static void main(String[] args) {
		
		a = new int[]{9,8,7,6,5,4,3,2,1,0};
		
		mergeSort(0, a.length-1);
		
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
	}
	
	static void merge(int m, int middle, int n){
		int i = m;
		int j = middle + 1;
		int k = m;
		
		while(i<=middle && j<=n){
			if(a[i] <= a[j]){
				sorted[k] = a[i];
				i++;
			}
			else{
				sorted[k] = a[j];
				j++;
			}
			k++;
		}
		//남은 데이터 삽입
		if(i>middle){
			for(int t= j; t<=n; t++){
				sorted[k] = a[t];
				k++;
			}
		}
		else{
			for(int t = i; t<=middle; t++){
				sorted[k] = a[t];
				k++;
			}
		}
		for(int t = m; t<=n; t++){
			a[t] = sorted[t];
		}
	}

	static void mergeSort(int m, int n){
		if(m<n){
			int middle = (m + n) / 2;
			mergeSort(m,middle);
			mergeSort(middle+1, n);
			merge(m,middle,n);
		}
	}
}
