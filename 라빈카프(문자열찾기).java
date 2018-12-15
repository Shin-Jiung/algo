# 문자열에서 한개씩 빼고 더할때 왼쪽 쉬프트 연산하는 것처럼 계산을 해줘야 된다.

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		String parent = "ababacabacaabacaaba";
		String pattern = "abacaaba";
		findString(parent, pattern);
	}
	
	static void findString(String parent, String pattern){
		int parentSize = parent.length();
		int patternSize = pattern.length();
		int power = 1;
		int parentHash = 0;
		int patternHash = 0;
		for(int i=0; i<= parentSize - patternSize; i++){
			if(i==0){
				for(int j=0; j<patternSize; j++){
					parentHash = parentHash + parent.charAt(patternSize - 1 - j) * power;
					patternHash = patternHash + pattern.charAt(patternSize - 1 - j) * power;
					if(j < patternSize - 1) power = power * 2;
				}
			}else{
				//parentHash = 2 * (parentHash - parent.charAt(i-1) * power) + parent.charAt(patternSize-1+i);
				parentHash -= parent.charAt(i-1) * power;
				parentHash *= 2; // 왼쪽으로 한칸씩 밀린 것이기 때문에  shift << 연산을 해준결과
				parentHash += (parent.charAt(i+patternSize-1));
			}
			
			if(parentHash == patternHash){
				boolean finded = true;
				for(int j = 0; j < patternSize; j++) {
					if(parent.charAt(i + j) != pattern.charAt(j)) {
						finded = false;
						break;
					}
				}
				if(finded) {
					System.out.println(i+1+" 번째");
				}
			}
		}	
	}
}
