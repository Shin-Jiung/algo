# 퀵소트 자바
# pivot (left + right) / 2

public class Solution {
	static int i = 0;
	public static void main(String[] args) {
		int [] arr = {69, 10, 30, 2, 16, 8, 31, 22};
		quickSort(arr,0,arr.length-1);
	}
	
	public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int p = partition(arr, begin, end);
            quickSort(arr, begin, p - 1);
            quickSort(arr, p + 1, end);
        }
    }
 
    public static int partition(int arr[], int begin, int end) {
        int left = begin;
        int right = end;
 
        int pivot = (left + right) / 2;
 
        System.out.println("[퀵 정렬 " + ++i + "단계: pivot: " + arr[pivot]);
 
        while (left < right) {
            while ((arr[left] < arr[pivot]) && (left < right))
                // L 움직이는 부분
                left++;
            while ((arr[right] >= arr[pivot]) && (left < right))
                // R 움직이는 부분
                right--;
 
            if (left < right) {
            	int temp = arr[left];
            	arr[left] = arr[right];
            	arr[right] = temp;

            }
        }
 
        int temp = arr[pivot];
    	arr[pivot] = arr[left];
    	arr[left] = temp;
 
        for(int t = 0; t<arr.length; t++){
        	System.out.print(arr[t]+" ");
        }
 
        return left;
    }


}
