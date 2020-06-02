package com.example09_p2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int max;				//최대값
	static int[][] map;			//지도
	static boolean[][] marked;	//방문 기록
	static int n, m;			//가로, 세로
	static int[] a = {-1,1,0,0};
	static int[] b = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		//가로 세로
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		//초기화
		marked = new boolean[n][m];
		map = new int[n][m];
		
		//map 만들기 (W == -1 / L == 0)
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
		
		//0,0에서 끝까지 bfs 실행
		//bfs 한번 할때마다 방문기록 초기화
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				bfs(i, j);
				marked = new boolean[n][m];
			}
		}
	}
	
	static void bfs(int x, int y) {		
				
		//만약 해당 인덱스 번호의 지도 위치가 물일 경우, 그냥 리턴
		if(map[x][y] == -1) {
			return;
		}
		
		//bfs를 위한 queue
		Queue<island> q = new LinkedList<island>();
		//시작 인덱스 번호를 가지는 island 객체를 만듦. 시작하는 번호이기 때문에 max 값은 0
		q.add(new island(x, y, 0));
		marked[x][y] = true;		//큐에 넣어줬으므로 방문기록 true
		
		//bfs 본격 시작!!!!!
		while(!q.isEmpty()) {
			
			island l = q.poll();
			
			//만약 큐안에 들어있던 island 객체 안 max 값이 static max값 보다 클 시 switch
			if(l.max > max) {
				max = l.max;
			}
			
			for(int i=0; i<4; i++) {
				//상하좌우로 갈 수 있을때
				if(l.x + a[i] >= 0 && l.y + b[i] >=0 && l.x + a[i] < n && l.y + b[i] < m ) {	
					//방문하지 않았으며, 가려고 하는 곳의 map값이 0일때,
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
	//최대시간 걸리는 좌표
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
