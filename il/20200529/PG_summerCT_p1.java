package com.example12_p_codingTest_01;

public class Main {
	public static void main(String[] args) {
		Solutions a = new Solutions();
		a.solution(1987);
	}
}

class Solutions {
    public int solution(int p) {
        int answer = 0;        
        answer = years(p);        
        System.out.println(answer);
        return answer;
    }
    
    public int years(int p) {
    	
    	int[] tmp;
    	String res = "";    	
    	p++;
    	String str = p+"";
    	
    	while(res.length() != str.length()) {
    		
    		tmp = new int[10];
    		str = p+"";
    		res = "";
    		
    		for(int i=0; i<str.length(); i++) {
    			int num = Integer.parseInt(str.charAt(i)+"");
    			tmp[num]++;
    		}
    		
    		for(int i=0; i<tmp.length; i++) {
    			if(tmp[i] == 1) {
    				res += i+"";
    			}
    		}
    		
    		if(res.length() == str.length()) {
    			break;
    		}
    		
    		p++;
    	}
    	
    	return p;
    }
}
