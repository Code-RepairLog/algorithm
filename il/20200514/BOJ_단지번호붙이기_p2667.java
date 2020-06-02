package com.example09_p2667;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static LinkedList<XY> homes;			//1�� ���� ������ �ִ� ����
	static int[][] map;						//����
	static LinkedList<Integer> danjisus;	//���� ���� �� ����
	static int allCount = 0;				//��ü ����
	static int eachCount = 0;				//���� ���� ��
	static int n;
	
	public static void main(String[] args) {
		
		homes = new LinkedList<XY>();
		danjisus = new LinkedList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		sc.nextLine();
		
		//���� ũ�� ����
		map = new int[n][n];
		
		String[] sarr;
		
//		�ڹ� String �迭�� int �迭�� ��ȯ
//		String[] strings = {"1", "2", "3"};
//		int[] nums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
		
		for(int i=0; i<n; i++) {
			sarr = sc.nextLine().split("");
//			�ڹ� String �迭�� int �迭�� ��ȯ�ؼ� ����
			map[i] = Arrays.stream(sarr).mapToInt(Integer::parseInt).toArray();
			for(int j=0 ; j<map[i].length ; j++) {
				if(map[i][j] == 1) {
					//�������� 1�� �ڸ��� i, j �� ������ ������ ij��ü�� homes�� �߰�
					homes.add(new XY(i, j));					
				}
			}
		}
		
		for(XY xy : homes) {
			if(map[xy.x][xy.y] == 1) {				
				allCount++;
				searchMap(xy);
				danjisus.add(eachCount);
				eachCount = 0;
			}
		}
		
		System.out.println(allCount);
		
		//�������� ���� �� ���
		Collections.sort(danjisus);
		for(int i : danjisus) {
			if(i!=0) {
				System.out.println(i);				
			}
		}	
	}
	
	
	static void searchMap(XY xy) {
		int x = xy.x;
		int y = xy.y;
		if(map[x][y] == 1) {
			map[x][y] = 0;
			eachCount++;
			
			//���� �̵��� ��ǥ �Է�
			//��
			if(x-1 >= 0 && map[x-1][y] == 1) {				
				searchMap(new XY(x-1, y));
			}
			//��
			if(x+1 < n && map[x+1][y] == 1) {
				searchMap(new XY(x+1, y));
			}
			//��
			if(y-1 >= 0 && map[x][y-1] == 1) {
				searchMap(new XY(x, y-1));
			}
			//��
			if(y+1 < n && map[x][y+1] == 1) {
				searchMap(new XY(x, y+1));
			}
			
		}
	}
}

class XY {
	int x;
	int y;
	public XY(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
