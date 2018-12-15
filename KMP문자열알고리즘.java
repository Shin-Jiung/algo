#문자열A에서 문자열B가 같은 부분 찾는 알고리즘.

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		String parent = "ababacabacaabacaaba";
		String patten = "abacaaba";
		KMP(parent, patten);
	}
	
	static void KMP(String parent, String patten){
		int parentSize = parent.length();
		int pattenSize = patten.length();
		Vector<Integer> table = new Vector<>();
		table.addAll(makeTable(patten));
		int j = 0;
		for(int i=0; i<parentSize; i++){
			while(j>0 && parent.charAt(i) != patten.charAt(j)){
				j = table.get(j-1);
			}
			if(parent.charAt(i) == patten.charAt(j)){
				if(j == pattenSize - 1){
					System.out.println(i - pattenSize + 2);
					j = table.get(j);
				}
				else{
					j++;
				}
			}
			
		}
		
		
	} 
	
	
	
	static Vector<Integer> makeTable(String patten){
		int pattenSize = patten.length();
		Vector<Integer> table = new Vector<>();
		for(int i=0; i<pattenSize; i++){
			table.add(0);
		}
		int j = 0;
		for(int i=1; i<pattenSize; i++){
			while(j>0 && patten.charAt(j) != patten.charAt(i)){
				j = table.get(j-1);
			}
			if(patten.charAt(i) == patten.charAt(j)){
				j++;
				table.set(i, j);
			}
		}
		return table;
	}
	
}
