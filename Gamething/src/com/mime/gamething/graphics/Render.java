package com.mime.gamething.graphics;

public class Render {
	public int width;
	public int height;
	public int[] pixels;
	public boolean animation = true;

	public Render(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	} 
//the x/yOffset is called by the render function in screen
	public void draw(Render render, int xOffset, int yOffset) {
		while (animation = true) {
			 try {
				Thread.sleep(1000);
				for (int y = 0; y < render.height - 500; y++) {
					int yPix = y + yOffset;
					
					for (int x = 0; x < render.height - 500; x++) {
						int xPix = x + xOffset;
						
						pixels[xPix + yPix * width] = render.pixels[x + y * render.width];
					}

				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	
		}
	
	}
}