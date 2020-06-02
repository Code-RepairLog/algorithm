package com.example11_p2812_last;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		//자리수
		int n = Integer.parseInt(st.nextToken());
		//뺄 숫자 갯수
		int k = Integer.parseInt(st.nextToken());
		int x = k;
		//입력받는 숫자
		String num = reader.readLine();
		//숫자 정렬할 char배열
		char[] number = new char[n];
		char c;
		int top = 0;
		for(int i=0; i<num.length(); i++) {
			c = num.charAt(i);
			//k는 0이상, top도 0이상, 만일 배열속 가리키는 값이 c보다 작을경우에 while문 계속 실행.
			while( k > 0 && top > 0 && number[top-1] < c ) {	
				k--;
				top--;
			}
			number[top] = c;
			top++;
		}
		//출력해야하는 갯수만큼 숫자 출력
		for(int i=0; i<n-x; i++) {
			System.out.print(number[i]);
		}
	}
}
