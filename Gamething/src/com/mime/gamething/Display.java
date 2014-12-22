package com.mime.gamething;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.mime.gamething.graphics.Render;
import com.mime.gamething.graphics.Screen;

/**
 * 
 * Responsible for drawing to the screen
 * 
 * @author Joshua
 *
 */
public class Display extends Canvas implements Runnable {

	public static final int width = 1920;
	public static final int height = 1200;
	public static final String TITLE = "Gamething";

	private Thread thread;
	private Screen screen;
	private BufferedImage bufferedImg;
	private boolean running = false;
	private int[] pixels;
	private boolean drawTimerBool = true;
	private int drawTimerInt = 0;
	int frames = 0;
	private static JLabel frameRate;
	public Display() {
		screen = new Screen(width, height);
		bufferedImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) bufferedImg.getRaster().getDataBuffer())
				.getData();
	}

	private void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();

		System.out.println("Thou'st program hath commenced, my liege.");
	}

	private void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void run() {
		
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		double secondsPerTick = 1 / 60.0;
		int tickCount = 0;
		boolean ticked = false;
		while (running) {
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unprocessedSeconds += passedTime / 1000000000.0;
			
			while (unprocessedSeconds > secondsPerTick) {
				tick();
				unprocessedSeconds -= secondsPerTick;
				ticked = true;
				tickCount++;
				if (tickCount % 60 == 0) {
					System.out.println(frames + "fps");
					previousTime += 1000;
					frames = 0;
				}
			}
			if (ticked) {
				render();
				frames++;
			}
			render();
			frames++;
		}
	}

	private void tick() {

	}

	private void drawTimer() {
		for (int i = 0; i < 99999; i++) {
			try {
				Thread.sleep(10);
				drawTimerInt = drawTimerInt + 1;
			} catch (InterruptedException e) {
			}

		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.render();

		for (int i = 0; i < width * height; i++) {
			pixels[i] = screen.pixels[i];
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(bufferedImg, 0, 0, width - drawTimerInt, height
				- drawTimerInt, null);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Display game = new Display();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.setSize(1920, 1200);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setTitle(TITLE);
		game.start();
		game.drawTimer();
		frameRate = new JLabel("How many sides does this polygon have?");
		frameRate.setHorizontalAlignment(SwingConstants.NORTH_WEST);
		frame.getContentPane().add(frameRate, BorderLayout.NORTH);
	}
}
