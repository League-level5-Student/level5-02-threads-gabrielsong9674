package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	static boolean haveWon = false;
	static int winner;
	public static void main(String[] args) {
		Robot[] robotArray = new Robot[3];
		for (int i = 0; i < robotArray.length; i++) {
			robotArray[i] = new Robot();
			// 4. make each robot start at the bottom of the screen, side by side, facing up
			robotArray[i].setY(800);
			robotArray[i].setX(200*i+500);
			robotArray[i].setSpeed(10);
		}
		Thread robot1 = new Thread(()->{
			moveRobot(robotArray[0]);
		});
		Thread robot2 = new Thread(()->{
			moveRobot(robotArray[1]);

		});
		Thread robot3 = new Thread(()->{
			moveRobot(robotArray[2]);
		});
		
		robot1.start();
		robot2.start();
		robot3.start();
		System.out.println("Robot " +checkWin(robotArray)+" wins!");

		

	}
	public static void moveRobot(Robot r) {
		Random rand;
		int robotMove;
		while(r.getY() > 0) {
			rand = new Random();
			robotMove = rand.nextInt(100);
			r.move(robotMove);
		}	
		haveWon = true;
		
	}
	public static int checkWin(Robot r[]) {
		while(!haveWon) {  
			for (int i = 0; i < r.length;i++) { 
				if(r[i].getY()<=0) { 
					winner = i; 
					haveWon =true;
				} 
			} 	
		}
		return winner;
	}
}
