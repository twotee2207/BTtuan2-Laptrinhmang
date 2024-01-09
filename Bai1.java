package Tuan2;

public class Bai1 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Luong dang chay");
	}
	public static void main (String[] args) {
		Bai1 th=new Bai1();
		th.start();
	}
}
