package com.mime.gamething.graphics;

import java.util.Random;

public class Screen extends Render {

	private Render test;

	public Screen(int width, int height) {
		super(width, height);
		Random random = new Random();
		test = new Render(1920, 1200);
		for (int j = 0; j < 1920*1200; j++) {
			test.pixels[j] = random.nextInt(); 
		}
		
	}

	public void render() {
//where the box is drawn
		draw(test, (width - 700) / 2, (height - 700) / 2);
	}
}
