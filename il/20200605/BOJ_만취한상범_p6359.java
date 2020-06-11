package com.example15_p6359;

import java.util.Scanner;

//������ ���
//https://www.acmicpc.net/problem/6359

public class Main {

	static int[] cases;
	static boolean[] room;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		cases = new int[t];
		
		int i = 0;
		while(i<t) {
			int n = sc.nextInt();
			room = new boolean[n+1];	//false�� �����ִ� ���, true�� �����ִ� ��츦 ����Ų��.
			for(int a=2; a<=n; a++) {	//2���� ����
				for(int b=a; b<=n; b++) {
					if(b%a == 0) {
						room[b] = !room[b];
					}
				}
			}
			for(int a=1; a<room.length; a++) {
				if(!room[a]) {
					cases[i]++;
				}
			}
			i++;
		}
		for(int a : cases) {
			System.out.println(a);
		}
	}
}