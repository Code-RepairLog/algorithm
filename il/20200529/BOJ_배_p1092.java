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
		
		//�������� ����
		Collections.sort(crain, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());		
		
		//ù��° ũ������ ���ĵ� ù��° �ڽ��� �ű��� ���ϸ� -1
		if(crain.get(0) < box.get(0)) {
			System.out.println("-1");
			return;
		}
		
		int ci = 0;	//ũ���� �ε���
		int bi = 0;	//�ڽ� �ε���
		int min = 0;	//�ð�
		
		while(!box.isEmpty()) {
			//ũ������ �� ��������
			if(ci >= crain.size()) {
				ci = 0;
				bi = 0;
				min++;
			}

			//�ڽ��� �� ���鼭 ũ���ο��� �ű��� ��������(i�� �ڽ����� ��� �Ѿ ���)
			//�ش� ũ������ ���̻� �Ұ� �����Ƿ� ũ���ο��� �����Ѵ�.
			if(bi == box.size()) {	
				crain.remove(ci);
				continue;
			}

			//ũ���� ���԰� �ڽ����� ũ�ų� �۴ٸ� �ڽ� �ű�� ũ���� a�� �ٲٰ� i�� �״��
			if( crain.get(ci) >= box.get(bi)) {
				box.remove(bi);
				ci++;
				continue;
			}
			
			//�ڽ� ���԰� ũ���� ���Ժ��� ū ���� ���� �ڽ���
			bi++;
			
		}
		//�ݺ��п��� ũ������ �� �������� �ð� +1�� ��������
		//�ڽ��� �� �Ű����� �������� �ٷ� ����Ǳ⶧���� �ð� +1�� ���� �ʴ´�. 
		//���� �ð� +1 �Ͽ� ���
		System.out.println(++min);
	}
}
