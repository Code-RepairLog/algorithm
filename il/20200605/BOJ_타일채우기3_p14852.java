package com.example15_p14852;

import java.util.Scanner;

//타일 채우기 3
//https://www.acmicpc.net/problem/14852

public class Main {
	
	static long[][] d;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		d = new long[n+1][2];

		d[1][0] = 2;
		if(n == 1) {
			System.out.println(d[n][0]);
			return;
		}
		
		d[2][0] = 7;
		d[2][1] = 1;
		if(n == 2) {
			System.out.println(d[n][0]);
			return;
		}
		
		System.out.println(dp(n));
	}
	
	static long dp(int n) {
		for(int i=3; i<=n ; i++) {
			d[i][1] = ( d[i-1][1] + d[i-3][0] ) % 1000000007;
			d[i][0] = (2*d[i-1][0] + 3*d[i-2][0] + 2*d[i][1]) % 1000000007;
		}
		return d[n][0];
	}
}