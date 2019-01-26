package control;

import java.util.Random;

public class World extends Thread{
	public int nRow;
	public int nColumn;
	private double[][] grass;
	private double grassGrowingSpeed = 0.1;
	public static long TIME_STEP = 5000;
	Random ran;
	public Animal animal;
	public World(int row, int column) {
		this.nRow = row;
		this.nColumn = column;
		ran = new Random();
		grass = new double[row][column];
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				grass[i][j] = ran.nextDouble();
			}
		}
	}
	public double getGrass(int i, int j) {
		return grass[i][j];
	}
	public void run() {
		while (true) {
			grow();
			try {
				Thread.sleep(World.TIME_STEP);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void grow() {
		for(int i=0; i<nRow; i++) {
			for(int j=0; j<nColumn; j++) {
				grass[i][j] += ran.nextDouble() * grassGrowingSpeed;
				/*if(grass[i][j]>1) {
					grass[i][j] = 1;
				}*/
				grass[i][j] = (grass[i][j]>1) ? 1 : grass[i][j];
			}
		}
	}
}