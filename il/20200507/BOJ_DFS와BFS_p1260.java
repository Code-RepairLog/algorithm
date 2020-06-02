package com.example08_20200513;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	static node[] nodes;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String sstr = sc.nextLine();
		String[] sarr = sstr.split(" ");
		
		int size = Integer.parseInt(sarr[0]);
		int count = Integer.parseInt(sarr[1]);
		int start = Integer.parseInt(sarr[2]);
		
		nodes = new node[size];
		
		for(int i=0; i<nodes.length ; i++) {
			nodes[i] = new node(i+1);
		}
		
		for(int i=0; i<count; i++) {
			String str = sc.nextLine();
			String[] narr = str.split(" ");
			nodemnode(Integer.parseInt(narr[0]), Integer.parseInt(narr[1]));
		}
		
		
		//mnode 내 오름차순 정렬
		for(int i=0; i<size; i++) {
			if(nodes[i].mnode.size()>1) {				
				Collections.sort(nodes[i].mnode);
			}
		}
		
		dfs(start);
		System.out.println();
		
		//marked 초기화
		for(int i=0; i<nodes.length; i++) {
			nodes[i].marked = false;
		}
		bfs(start);
	}
	
	public static void nodemnode(int n1, int n2) {
		
		node mn1 = nodes[n1-1];
		node mn2 = nodes[n2-1];
		
		if(!mn1.mnode.contains(mn2)) {
			mn1.mnode.add(mn2);
		}
		if(!mn2.mnode.contains(mn1)) {
			mn2.mnode.add(mn1);
		}
		
	}
	
	public static void dfs(int start) {
		int index = start-1;
		//재귀 사용
		nodes[index].marked = true;
		System.out.print(nodes[index].data);
		if(!nodes[index].mnode.isEmpty()) {
			for(int i=0; i<nodes[index].mnode.size(); i++) {
				
				node n = nodes[index].mnode.get(i);
				
				if(!n.marked) {
					System.out.print(" ");
					dfs(n.data);
				}
			}
		}
	}
	
	public static void bfs(int start) {
		String str = "";
		int index = start-1;
		Vector<node> vq = new Vector<node>();
		node startnode = nodes[index];
		vq.add(startnode);
		startnode.marked = true;
		while(!vq.isEmpty()) {
			node n = vq.get(0);
			vq.remove(n);
			str += n.data+" ";
			for(int i=0; i<n.mnode.size(); i++) {
				if(!n.mnode.get(i).marked) {					
					vq.add(n.mnode.get(i));
					n.mnode.get(i).marked = true;
				}
			}
		}
		System.out.print(str.substring(0, str.length()-1));
	}
}

class node implements Comparable<node>{
	int data;
	Vector<node> mnode;
	boolean marked;
	
	public node() {
	}
	public node(int data) {
		super();
		this.data = data;
		this.mnode = new Vector<node>();
		this.marked = false;
	}
	
	//compareTo
	@Override
	public int compareTo(node n) {
		if(this.data > n.data) {
			return 1;
		}else if(this.data < n.data) {
			return -1;
		}else {			
			return 0;
		}
	}
}
