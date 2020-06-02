package com.example09_p11724_v2;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static LinkedList<Integer> tmp;	//tmp ��� �̸� ���� �˼��Դϴ�
	static LinkedList<Integer>[] nodes;
	static boolean[] marked;
	static int count = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] str = sc.nextLine().split(" ");
		int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);

		//���� ��ũ �迭 ũ�� ����
		nodes = new LinkedList[n+1];
		marked = new boolean[n+1];
		tmp = new LinkedList<Integer>();
		
		//���� ��ũ �迭 �� �Է�
		for(int i=0; i<nodes.length; i++) {
			nodes[i] = new LinkedList<Integer>();
			marked[i] = false;
			tmp.add(i);
		}
		
		tmp.remove(0); //0 ����
		
		//�� ���� ���� ����
		for(int i=0; i<m; i++) {
			str = sc.nextLine().split(" ");
			connect(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}
		
		while(!tmp.isEmpty()) {
			int i = tmp.get(0);
			if(!marked[i]) {	//�ش� ������ ��ũ�Ǿ����������ÿ��� ����
				dfs(i);
				++count;		//dfs �ѹ� ������ ������ count++
			}
		}
		
		System.out.println(count);
	}
	
	static void connect(int u, int v) {
		nodes[u].push(v);
		nodes[v].push(u);
	}
	
	static void dfs(int n) {
		tmp.removeFirst();
		marked[n] = true;
		while(!nodes[n].isEmpty()) {
			int m = nodes[n].poll();
			if(!marked[m]) {
				dfs(m);
			}
		}
	}

}
