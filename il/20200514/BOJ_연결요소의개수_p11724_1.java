package com.example09_p11724;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static LinkedList<Integer>[] nodes;
	static boolean[] marked;
	static int count = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] str = sc.nextLine().split(" ");
		int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);

		//노드와 마크 배열 크기 지정
		nodes = new LinkedList[n+1];
		marked = new boolean[n+1];
		
		//노드와 마크 배열 값 입력
		for(int i=0; i<nodes.length; i++) {
			nodes[i] = new LinkedList<Integer>();
			marked[i] = false;
		}
		
		//두 정점 간선 연결
		for(int i=0; i<m; i++) {
			str = sc.nextLine().split(" ");
			connect(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}
		
		//전체 정점 반복
		for(int i=1; i<n+1; i++) {
			if(!marked[i]) {	//해당 정점이 마크되어있지않을시에만 실행
				dfs(i);
				++count;		//dfs 한번 실행이 끝나면 count++
			}
		}
		
		System.out.println(count);
	}
	
	static void connect(int u, int v) {
		nodes[u].push(v);
		nodes[v].push(u);
	}
	
	static void dfs(int n) {
		
		if(marked[n]) {
			return;
		}
		
		marked[n] = true;
		
		while(!nodes[n].isEmpty()) {
			int m = nodes[n].poll();
			if(!marked[m]) {
				dfs(m);
			}
		}
	}

}
