package com.mime.gamething;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.mime.gamething.graphics.Render;
import com.mime.gamething.graphics.Screen;

public class Display extends Canvas implements Runnable {

	public static final int width = 1920;
	public static final int height = 1200;
	public static final String TITLE = "Gamething";

	private Thread thread;
	private Screen screen;
	private BufferedImage img;
	private boolean running = false;
	private Render render;
	private int[] pixels;
	
	public Display() {
		screen = new Screen(width, height);
		img = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	}

	private void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();

		System.out.println("I'M WORKING");
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
		while (running) {
			tick();
			render();
		}
	}

	private void tick() {

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.render();
		
		for (int i = 0; i<width * height; i++) {
			pixels[i] = screen.pixels[i];
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, width, height, null);
		g.dispose();
		bs.show();
	}
	
	

	public static void main(String[] args) {
		Display game = new Display();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setTitle(TITLE);

		game.start();
	}
}
