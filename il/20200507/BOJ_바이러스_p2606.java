package com.example08_20200513_2;

import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	static Computer[] computers;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//컴퓨터 댓수
		int size = sc.nextInt();
		//컴퓨터 간 연결된 선의 수
		int count = sc.nextInt();
		
		sc.nextLine();
		
		//컴퓨터 사이즈 선언
		//인덱스 번호를 컴퓨터 번호로 사용할 것임.
		computers = new Computer[size+1];
		
		for(int i=0; i<computers.length; i++) {
			computers[i] = new Computer(i);
		}
		
		for(int i=0; i<count; i++) {
			String str = sc.nextLine();
			String[] narr = str.split(" ");
			cmc(Integer.parseInt(narr[0]), Integer.parseInt(narr[1]));
		}
		
		System.out.println(searchV(computers[1])-1);
		
	}
	
	
	public static void cmc(int n1, int n2) {
		//컴퓨터간 라인 연결
		Computer com1 = computers[n1];
		Computer com2 = computers[n2];
		if(!com1.Lcoms.contains(com2)) {
			com1.Lcoms.add(com2);
		}
		if(!com2.Lcoms.contains(com1)) {
			com2.Lcoms.add(com1);
		}
	}
	
	public static int searchV(Computer start) {
		
		start.marked = true;
		int count = 1;
		
		//연결된 컴퓨터가 없으면 그대로 count 리턴
		if(start.Lcoms.isEmpty()) {
			return count;
		}
		
		//연결된 컴퓨터 수 만큼 반복하는데, marked 가 false 인것만 다시 재귀
		for(int i=0; i<start.Lcoms.size() ; i++) {
			if(!start.Lcoms.get(i).marked) {
				count += searchV(start.Lcoms.get(i));
			}
		}
		
		return count;
	}
	
}

class Computer{
	int number;
	Vector<Computer> Lcoms;	//연결된 컴퓨터들(lined computers)
	boolean marked;
	
	public Computer() {	}

	public Computer(int number) {
		super();
		this.number = number;
		Lcoms = new Vector<Computer>();
		this.marked = false;
	}
	
}



