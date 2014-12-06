package com.mime.gamething.graphics;

import java.util.Random;

public class Screen extends Render {

	private Render render;

	public Screen(int width, int height) {
		super(width, height);
		Random random = new Random();
		render = new Render(1920, 1200);
		for (int j = 0; j < 1920*1200; j++) {
			render.pixels[j] = random.nextInt(); 
		}
		
	}

	public void render() {
//where the box is drawn
		draw(render, (width - 700) / 2, (height - 700) / 2);
	}
}
