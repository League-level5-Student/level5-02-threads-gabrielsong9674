package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot blue = new Robot(500, 400);
		Robot black = new Robot(800, 400);
		Robot red = new Robot(1100, 400);
		Robot yellow = new Robot(650, 600);
		Robot green = new Robot(950, 600);
		
		
		Thread blueThread = new Thread(()->{
			drawRing(blue, Color.blue);
		});
		Thread blackThread = new Thread(()->{
			drawRing(black, Color.black);
		});
		Thread redThread = new Thread(()->{
			drawRing(red, Color.red);
		});
		Thread yellowThread = new Thread(()->{
			drawRing(yellow, Color.yellow);
		});
		Thread greenThread = new Thread(()->{
			drawRing(green, Color.green);
		});
		blueThread.start();
		blackThread.start();
		redThread.start();
		yellowThread.start();
		greenThread.start();
	}
	
	public static void drawRing(Robot r, Color c) {
		r.setSpeed(10);
		r.penUp();
		r.move(100);
		r.turn(90);
		r.setPenColor(c);
		r.penDown();
		for(int i = 0; i < 180; i ++) {
			r.move(5);
			r.turn(2);
		}
		r.hide();
	}
}

