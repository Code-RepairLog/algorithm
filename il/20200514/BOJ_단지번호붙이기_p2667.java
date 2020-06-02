package com.example09_p2667;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static LinkedList<XY> homes;			//1의 값을 가지고 있는 집들
	static int[][] map;						//지도
	static LinkedList<Integer> danjisus;	//개별 단지 수 저장
	static int allCount = 0;				//전체 단지
	static int eachCount = 0;				//개별 단지 수
	static int n;
	
	public static void main(String[] args) {
		
		homes = new LinkedList<XY>();
		danjisus = new LinkedList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		sc.nextLine();
		
		//지도 크기 지정
		map = new int[n][n];
		
		String[] sarr;
		
//		자바 String 배열을 int 배열로 변환
//		String[] strings = {"1", "2", "3"};
//		int[] nums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
		
		for(int i=0; i<n; i++) {
			sarr = sc.nextLine().split("");
//			자바 String 배열을 int 배열로 변환해서 삽입
			map[i] = Arrays.stream(sarr).mapToInt(Integer::parseInt).toArray();
			for(int j=0 ; j<map[i].length ; j++) {
				if(map[i][j] == 1) {
					//지도에서 1인 자리의 i, j 를 값으로 가지는 ij객체를 homes에 추가
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
		
		//오름차순 정렬 후 출력
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
			
			//다음 이동할 좌표 입력
			//상
			if(x-1 >= 0 && map[x-1][y] == 1) {				
				searchMap(new XY(x-1, y));
			}
			//하
			if(x+1 < n && map[x+1][y] == 1) {
				searchMap(new XY(x+1, y));
			}
			//좌
			if(y-1 >= 0 && map[x][y-1] == 1) {
				searchMap(new XY(x, y-1));
			}
			//우
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
