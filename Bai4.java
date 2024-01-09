//Tinh tong mang 
package Tuan2;

public class Bai4 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int numThreads = 2;
		Thread[] ths = new Thread[numThreads];
		SumCalculator[] cals = new SumCalculator[numThreads];
		for (int i = 0; i < numThreads; i++) {
			cals[i] = new SumCalculator(array, i, numThreads);
			ths[i] = new Thread(cals[i]);
			ths[i].start();
		}
		for (int i = 0; i < numThreads; i++) {
			try {
				ths[i].join();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		int totalSum = 0;
		for (SumCalculator c : cals) {
			totalSum += c.getTong1Phan();
			
		}
		System.out.println("Tong la" + totalSum);
	}
}

class SumCalculator implements Runnable {
	private int[] array;
	private int starIndex;
	private int chia;
	private int tong1phan;

	public SumCalculator(int[] array, int startIndex, int chia) {
		this.array = array;
		this.starIndex = startIndex;
		this.chia = chia;
		this.tong1phan = 0;
	}

	public void run() {
		for (int i = starIndex; i < array.length; i += chia) {
			tong1phan += array[i];

		}
	}

	public int getTong1Phan() {
		return tong1phan;
	}

}
