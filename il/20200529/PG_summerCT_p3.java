package com.example13_programmers_CT;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args){
		
		int total_sp = 121;
		int[][] skills = {{1,2},{1,3},{3,6},{3,4},{3,5}};
		
		Solution s = new Solution();
		int[] answer = s.solution(total_sp, skills);
			
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i] +" ");
		}
	}

}

class Solution{
	
	String[] list;
	int[] answer;
	int count = 0;
	
	public int[] solution(int total_sp, int[][] skills) {
				
		answer = new int[skills.length+1];
		
		list = new String[skills.length+1];
		
		Arrays.fill(list, "");
		
		for(int[] i : skills) {
			list[i[0]-1] += (i[1]-1)+"";
		}
		
		res(findPN(skills));
		
		int mok = total_sp / count;
		for(int i=0; i<answer.length; i++) {
			answer[i] *= mok;
		}
		
		return answer;
	}
	
	//부모 노드 찾기
	public int findPN(int[][] skills) {
		
		boolean[] nodes = new boolean[skills.length+1];
		int index = 0;
		
		for(int[] i : skills) {
			nodes[i[1]-1] = true;
		}
		
		for(int i=0; i<nodes.length; i++) {
			if(!nodes[i]) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public int res(int i) {
		
		int sum = 0;
		
		if(list[i].length() == 0) {
			count += 1;
			return answer[i] = 1;
		}

		if(answer[i] != 0) {
			count += answer[i];
			return answer[i];
		}
		
		for(int a=0; a<list[i].length(); a++) {
			int num = Integer.parseInt(list[i].charAt(a)+"");
			sum += res(num);
		}
		
		count += sum;
		return answer[i] = sum;
	}
	
	
	
}