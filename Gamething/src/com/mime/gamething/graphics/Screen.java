package com.mime.gamething.graphics;

import java.util.Random;

public class Screen extends Render {

	private Render render;

	public Screen(int width, int height) {
		super(width, height);
		Random random = new Random();
		render = new Render(1920, 1200);
		for (int j = 0; j < 1920 * 1200; j++) {
			render.pixels[j] = random.nextInt();
		}

	}

	public void render() {
		// where the box is drawn
		for (int i = 0; i < width * height; i++) {
			pixels[i] = 0;
		}
		for (int i = 0; i < 80; i++) {
			int anim = (int) (Math.sin((System.currentTimeMillis()+i * 20) % 8000.0
					/ 4000 * Math.PI) * 350);
		   int anim2 = (int) (Math.cos((System.currentTimeMillis()+i * 20) % 8000.0
					/ 4000 * Math.PI) * 350);
			draw(render, (width - 200) / 2 - anim, (height - 200) / 2 - anim2);
		}
	}
}
