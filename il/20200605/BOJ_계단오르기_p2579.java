package com.example15_p2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//계단오르기
//https://www.acmicpc.net/problem/2579

public class Main {
	
	static int n;
	static int[][] stairs;
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		stairs = new int[n+1][2];
		
		for(int i=1; i<=n; i++) {
			stairs[i][0] = Integer.parseInt(reader.readLine());
		}
		
		stairs[1][1] = stairs[1][0];
		if(n==1) {
			System.out.println(stairs[1][1]);
			return;
		}
		
		stairs[2][1] = stairs[2][0] + stairs[1][0];
		if(n==2) {
			System.out.println(stairs[2][1]);
			return;
		}
		
		stairs[3][1] = Math.max(stairs[1][0], stairs[2][0]) + stairs[3][0];
		if(n==3) {
			System.out.println(stairs[3][1]);
			return;
		}
		
		for(int i=4; i<=n; i++) {
			stairs[i][1] = Math.max((stairs[i-3][1] + stairs[i-1][0]), stairs[i-2][1])+stairs[i][0];
		}
		
		System.out.println(stairs[n][1]);
	}
}