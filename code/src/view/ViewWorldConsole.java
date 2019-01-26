package view;

import control.Animal;
import control.Sheep;
import control.World;

public class ViewWorldConsole {
	public static void main(String[] args) {
		World world1 = new World(5,7);
		Animal animal = new Sheep(10, 1, world1, 0, 0);
		world1.animal = animal;
		animal.start();
		world1.start();
		while (true) {
			double[][] view = new double[world1.nRow][world1.nColumn];
			for(int i = 0; i<world1.nRow; i++) {
				for(int j=0; j<world1.nColumn; j++) {
					view[i][j] = world1.getGrass(i,j);
				}
			}
			view[animal.getCurrentRow()][animal.getCurrentColumn()] = 2;
			for(int i =0; i<world1.nRow; i++) {
				for(int j=0; j<world1.nColumn; j++) {
					System.out.print( String.format( "%.2f ", view[i][j] ) );
				}
				System.out.println();
			}
			try {
				Thread.sleep(World.TIME_STEP);
			} catch (Exception e) {
			
			}
		}
	}
}