package com.example07_20200428_2;
import java.util.*;

//하노이의 탑 -> 일일히 스택 하는 버젼
//이미 반복 알고 층만 할면 답을 구할 수 있지만 그렇게 하지 않고 재귀와 스택 이용해서 풀기.

public class Solution {
	public int solution(int n) {
		
		int mcount = 0; //총 이동수 
		
		int onetwe = 1;
		// 1 일땐 0->1로 움직인다. 
		// 2 일땐 1->0로 움직인다. 
		// 3 일땐 0->1로 움직인다.
		// 4 일땐 1로 바꿔준다.
		
		int sfCount = 1;
		
		for(int i=0; i<n-3; i++) {
			sfCount = sfCount*2;
		}
		
		int[][] hanoi = new int[3][n];
		
		for(int i=0; i<n ; i++) {
			hanoi[0][i] = i+1;
		}
		
		int[] top = {n-1, -1, -1};
		
		
		return mcount;
		
	}
	
	public int move(int[][] hanoi, int[] top, int onetwe, int sfCount) {
		
		int mcount = 0;
		
		// 0->2
		top[2] = ++top[2];
		hanoi[2][top[2]] = hanoi[0][top[0]];
		top[0] = --top[0];
		++mcount;	//1회움직임
		
		// 0->1
		top[1] = ++top[1];
		hanoi[1][top[1]] = hanoi[0][top[0]];
		top[0] = --top[0];
		++mcount;	//1회움직임
		
		// 2->1
		top[1] = ++top[1];
		hanoi[1][top[1]] = hanoi[2][top[2]];
		top[2] = --top[2];
		++mcount;	//1회움직임

		// 0->2
		top[2] = ++top[2];
		hanoi[2][top[2]] = hanoi[0][top[0]];
		top[0] = --top[0];
		++mcount;	//1회움직임

		// 1->0
		top[0] = ++top[0];
		hanoi[0][top[0]] = hanoi[1][top[1]];
		top[1] = --top[1];
		++mcount;	//1회움직임

		// 1->2
		top[2] = ++top[2];
		hanoi[2][top[2]] = hanoi[1][top[1]];
		top[1] = --top[1];
		++mcount;	//1회움직임

		// 0->2
		top[2] = ++top[2];
		hanoi[2][top[2]] = hanoi[0][top[0]];
		top[0] = --top[0];
		++mcount;	//1회움직임

		
		
		
		if(sfCount == 0) {
			return mcount;
		}else {
			// onetwe 가
			// 1 일땐 0->1로 움직인다. 
			// 2 일땐 1->0로 움직인다. 
			// 3 일땐 0->1로 움직인다.
			// 4 일땐 1로 바꿔준다.
			switch (onetwe) {
				case 1:
				case 3:
					// 0->1
					top[1] = ++top[1];
					hanoi[1][top[1]] = hanoi[0][top[0]];
					top[0] = --top[0];
					++mcount;	//1회움직임
					++onetwe;
					break;
				case 2:
					// 1->0
					top[0] = ++top[0];
					hanoi[0][top[0]] = hanoi[1][top[1]];
					top[1] = --top[1];
					++mcount;	//1회움직임
					++onetwe;
					break;
				case 4:
					onetwe = 1;
					break;
			}
			
		}
			
			
		hanoi = shuffleHanoi(hanoi);
		top = shuffleTop(top);
			
		
		
		return move(hanoi, top, onetwe, sfCount) +mcount;
	}
	
	public int[][] shuffleHanoi(int[][] hanoi){
		
		int[] tmp = new int[hanoi[0].length];
		
		tmp = hanoi[2];
		hanoi[2] = hanoi[1];
		hanoi[1] = hanoi[0];
		hanoi[0] = tmp;
		
		return hanoi;
	}
	
	public int[] shuffleTop(int[] top) {
		
		int tmp = top[2];
		top[2] = top[1];
		top[1] = top[0];
		top[0] = tmp;
		
		return top;
		
		
	}
   
}