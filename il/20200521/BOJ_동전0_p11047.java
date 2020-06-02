package com.example11_p11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, k;
	static int[] list;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
				
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		list = new int[n];
		for(int i=0; i<n; i++) {
			list[i] = Integer.parseInt(reader.readLine());
		}
		minToken();
	}
	
	static void minToken() {
		
		int min = 0;
		
		for(int i = list.length-1 ; i >= 0; i--) {
			if(list[i] > k) {
				continue;
			}
			if(k == 0) {
				break;
			}
			min = min + (k / list[i]);
			k = k % list[i];
		}
		System.out.println(min);
	}
}
