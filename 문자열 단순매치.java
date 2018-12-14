import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		
		System.out.println(findString("Hello World","llo W"));
	}
	static int findString(String parent, String pattern){
		boolean flag = true;
		for(int i=0; i<parent.length()-pattern.length(); i++){
			flag = true;
			for(int j=0; j<pattern.length(); j++){
				if(parent.charAt(i+j) != pattern.charAt(j)){ 
					flag = false;
					break;
				}
			}
			if(flag){
				return i;
			}
		}
		return -1;
	}
}
