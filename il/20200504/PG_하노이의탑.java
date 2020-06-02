package com.example07_20200428_2;
import java.util.*;

//�ϳ����� ž -> ������ ���� �ϴ� ����
//�̹� �ݺ� �˰� ���� �Ҹ� ���� ���� �� ������ �׷��� ���� �ʰ� ��Ϳ� ���� �̿��ؼ� Ǯ��.

public class Solution {
	public int solution(int n) {
		
		int mcount = 0; //�� �̵��� 
		
		int onetwe = 1;
		// 1 �϶� 0->1�� �����δ�. 
		// 2 �϶� 1->0�� �����δ�. 
		// 3 �϶� 0->1�� �����δ�.
		// 4 �϶� 1�� �ٲ��ش�.
		
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
		++mcount;	//1ȸ������
		
		// 0->1
		top[1] = ++top[1];
		hanoi[1][top[1]] = hanoi[0][top[0]];
		top[0] = --top[0];
		++mcount;	//1ȸ������
		
		// 2->1
		top[1] = ++top[1];
		hanoi[1][top[1]] = hanoi[2][top[2]];
		top[2] = --top[2];
		++mcount;	//1ȸ������

		// 0->2
		top[2] = ++top[2];
		hanoi[2][top[2]] = hanoi[0][top[0]];
		top[0] = --top[0];
		++mcount;	//1ȸ������

		// 1->0
		top[0] = ++top[0];
		hanoi[0][top[0]] = hanoi[1][top[1]];
		top[1] = --top[1];
		++mcount;	//1ȸ������

		// 1->2
		top[2] = ++top[2];
		hanoi[2][top[2]] = hanoi[1][top[1]];
		top[1] = --top[1];
		++mcount;	//1ȸ������

		// 0->2
		top[2] = ++top[2];
		hanoi[2][top[2]] = hanoi[0][top[0]];
		top[0] = --top[0];
		++mcount;	//1ȸ������

		
		
		
		if(sfCount == 0) {
			return mcount;
		}else {
			// onetwe ��
			// 1 �϶� 0->1�� �����δ�. 
			// 2 �϶� 1->0�� �����δ�. 
			// 3 �϶� 0->1�� �����δ�.
			// 4 �϶� 1�� �ٲ��ش�.
			switch (onetwe) {
				case 1:
				case 3:
					// 0->1
					top[1] = ++top[1];
					hanoi[1][top[1]] = hanoi[0][top[0]];
					top[0] = --top[0];
					++mcount;	//1ȸ������
					++onetwe;
					break;
				case 2:
					// 1->0
					top[0] = ++top[0];
					hanoi[0][top[0]] = hanoi[1][top[1]];
					top[1] = --top[1];
					++mcount;	//1ȸ������
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