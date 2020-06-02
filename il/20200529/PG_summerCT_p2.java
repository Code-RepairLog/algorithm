package com.example12_p_codingTest_02;

public class Main {
	
	public static void main(String[] args){
		Solution a = new Solution();
		a.solution(6);
	}
}

class Solution {
	
	long[] list;
	long mark = 3;
	long count = 1;
			
	public long solution(long n) {
        long answer = 0;
        
        list = new long[(int) (n+1)];
        
        for(int i=1; i<=n ; i++) {
        	
        	dp(i);
        }        
        
        System.out.println(list[(int) n]);
        return answer;
    }
    
    public void dp(long i) {
    	
    	if(i==1) {
    		list[(int) i] = 1;
    		return;
    	}
    	
    	if(i==2) {
    		list[(int) i] = 3;
    		return;
    	}
    	
    	if(list[(int) count] == mark) {
    		count = 1;
    		mark *= 3;
    		list[(int) i] = mark;
    		return;
    	}
    	
    	long num = mark + list[(int) count];
    	list[(int) i] = num;
    	count++;
    	
    	return;
    }
}
