package com.example13_p1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static LinkedList<Integer> crain;
	static LinkedList<Integer> box;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		
		
		n = Integer.parseInt(reader.readLine());
		crain = new LinkedList<Integer>();
		st = new StringTokenizer(reader.readLine(), " ");
		while(st.hasMoreTokens()) {
			crain.add(Integer.parseInt(st.nextToken()));
		}
		
		m = Integer.parseInt(reader.readLine());
		box = new LinkedList<Integer>();
		st = new StringTokenizer(reader.readLine(), " ");
		while(st.hasMoreTokens()) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		//내림차순 정렬
		Collections.sort(crain, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());		
		
		//첫번째 크레인이 정렬된 첫번째 박스를 옮기지 못하면 -1
		if(crain.get(0) < box.get(0)) {
			System.out.println("-1");
			return;
		}
		
		int ci = 0;	//크레인 인덱스
		int bi = 0;	//박스 인덱스
		int min = 0;	//시간
		
		while(!box.isEmpty()) {
			//크레인을 다 돌았을때
			if(ci >= crain.size()) {
				ci = 0;
				bi = 0;
				min++;
			}

			//박스를 다 돌면서 크레인에서 옮기지 못했을때(i가 박스들을 모두 넘어간 경우)
			//해당 크레인은 더이상 할게 없으므로 크레인에서 제외한다.
			if(bi == box.size()) {	
				crain.remove(ci);
				continue;
			}

			//크레인 무게가 박스보다 크거나 작다면 박스 옮기고 크레인 a는 바꾸고 i는 그대로
			if( crain.get(ci) >= box.get(bi)) {
				box.remove(bi);
				ci++;
				continue;
			}
			
			//박스 무게가 크레인 무게보다 큰 경우는 다음 박스로
			bi++;
			
		}
		//반복분에서 크레인이 다 돌았을때 시간 +1을 해주지만
		//박스가 다 옮겨지는 시점에서 바로 종료되기때문에 시간 +1이 되지 않는다. 
		//따라서 시간 +1 하여 출력
		System.out.println(++min);
	}
}
