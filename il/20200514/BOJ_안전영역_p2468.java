package com.example09_p2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int max;				//�ִ밪
	static int[][] map;			//����
	static boolean[][] marked;	//�湮 ���
	static int n, m;			//����, ����
	static int[] a = {-1,1,0,0};
	static int[] b = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		//���� ����
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		//�ʱ�ȭ
		marked = new boolean[n][m];
		map = new int[n][m];
		
		//map ����� (W == -1 / L == 0)
		for(int i=0; i<n; i++) {
			String[] str = reader.readLine().split("");
			for(int j=0; j<m; j++) {
				if(str[j].equals("W")) {
					map[i][j] = -1;
				}
			}
		}
		
		searchMap();

		System.out.println(max);
	}
	
	static void searchMap() {
		
		//0,0���� ������ bfs ����
		//bfs �ѹ� �Ҷ����� �湮��� �ʱ�ȭ
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				bfs(i, j);
				marked = new boolean[n][m];
			}
		}
	}
	
	static void bfs(int x, int y) {		
				
		//���� �ش� �ε��� ��ȣ�� ���� ��ġ�� ���� ���, �׳� ����
		if(map[x][y] == -1) {
			return;
		}
		
		//bfs�� ���� queue
		Queue<island> q = new LinkedList<island>();
		//���� �ε��� ��ȣ�� ������ island ��ü�� ����. �����ϴ� ��ȣ�̱� ������ max ���� 0
		q.add(new island(x, y, 0));
		marked[x][y] = true;		//ť�� �־������Ƿ� �湮��� true
		
		//bfs ���� ����!!!!!
		while(!q.isEmpty()) {
			
			island l = q.poll();
			
			//���� ť�ȿ� ����ִ� island ��ü �� max ���� static max�� ���� Ŭ �� switch
			if(l.max > max) {
				max = l.max;
			}
			
			for(int i=0; i<4; i++) {
				//�����¿�� �� �� ������
				if(l.x + a[i] >= 0 && l.y + b[i] >=0 && l.x + a[i] < n && l.y + b[i] < m ) {	
					//�湮���� �ʾ�����, ������ �ϴ� ���� map���� 0�϶�,
					if(!marked[l.x+a[i]][l.y+b[i]] && map[l.x+a[i]][l.y+b[i]] == 0) {			
						island lll = new island(l.x+a[i], l.y+b[i], l.max+1);
						q.add(lll);		
						marked[l.x+a[i]][l.y+b[i]] = true;
					}	
				}
			}
		}
	}
}

class island{
	//�ִ�ð� �ɸ��� ��ǥ
	int x;
	int y;
	int max;
	
	public island(int x, int y, int max) {
		super();
		this.x = x;
		this.y = y;
		this.max = max;
	}
}
