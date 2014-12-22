package com.mime.gamething.graphics;

import com.mime.gamething.Display;

/**
 * stores an array of pixels
 * 
 * @author Joshua
 *
 */
public class Render {
	public int width;
	public int height;
	public int[] pixels;
	public boolean animation = true;
	
private Display display;

	public Render(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	// the x yOffset is called by the render function in screen
	public void draw(Render render, int xOffset, int yOffset) {
		// storing random coloured pixes into the array 'pixels'
		for (int y = 0; y < render.height - 900; y++) {
			int yPix = y + yOffset;
			if (yPix < 0 || yPix >= display.height) {
				continue;
			}

			for (int x = 0; x < render.height - 900; x++) {
				int xPix = x + xOffset;
				if (xPix < 0 || xPix >= display.width) {
					continue;
				}
				pixels[xPix + yPix * width] = render.pixels[x + y
						* render.width];
			}

		}
	}
}