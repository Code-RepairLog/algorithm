package com.example11_p2875;

//대회  or 인턴

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, k;
	static int team;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		makeTeam();
		
		k -= (n+m);
		
		if(k <= 0) {
			System.out.println(team);
			return;
		}
		
		k = k%3 > 0 ?  (k/3) + 1 : (k/3);
		
		System.out.println(team-k > 0 ? team-k : 0);
	}
	
	static void makeTeam() {
		if(n >= 2 && m >= 1) {
			n -= 2;
			m -= 1;
			team++;
			makeTeam();
		}
	}
}
