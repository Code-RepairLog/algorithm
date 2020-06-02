package com.example08_20200513_2;

import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	static Computer[] computers;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//��ǻ�� ���
		int size = sc.nextInt();
		//��ǻ�� �� ����� ���� ��
		int count = sc.nextInt();
		
		sc.nextLine();
		
		//��ǻ�� ������ ����
		//�ε��� ��ȣ�� ��ǻ�� ��ȣ�� ����� ����.
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
		//��ǻ�Ͱ� ���� ����
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
		
		//����� ��ǻ�Ͱ� ������ �״�� count ����
		if(start.Lcoms.isEmpty()) {
			return count;
		}
		
		//����� ��ǻ�� �� ��ŭ �ݺ��ϴµ�, marked �� false �ΰ͸� �ٽ� ���
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
	Vector<Computer> Lcoms;	//����� ��ǻ�͵�(lined computers)
	boolean marked;
	
	public Computer() {	}

	public Computer(int number) {
		super();
		this.number = number;
		Lcoms = new Vector<Computer>();
		this.marked = false;
	}
	
}



