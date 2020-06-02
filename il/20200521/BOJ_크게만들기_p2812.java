package com.example11_p2812_last;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		//�ڸ���
		int n = Integer.parseInt(st.nextToken());
		//�� ���� ����
		int k = Integer.parseInt(st.nextToken());
		int x = k;
		//�Է¹޴� ����
		String num = reader.readLine();
		//���� ������ char�迭
		char[] number = new char[n];
		char c;
		int top = 0;
		for(int i=0; i<num.length(); i++) {
			c = num.charAt(i);
			//k�� 0�̻�, top�� 0�̻�, ���� �迭�� ����Ű�� ���� c���� ������쿡 while�� ��� ����.
			while( k > 0 && top > 0 && number[top-1] < c ) {	
				k--;
				top--;
			}
			number[top] = c;
			top++;
		}
		//����ؾ��ϴ� ������ŭ ���� ���
		for(int i=0; i<n-x; i++) {
			System.out.print(number[i]);
		}
	}
}
