package org.josh.gui.polygons;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Picture {
	int x = 100;
	int y = 100;

	private BufferedImage bufferedImage;

	public Picture() {
		InputStream istream = this.getClass().getResourceAsStream(
				"download.jpg");
		try {
			bufferedImage = ImageIO.read(istream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setXY(int _x, int _y) {
		x = _x;
		y = _y;
	}

	public void move(int _x, int _y) {
		x = x + _x;
		y = y + _y;
	}

	public void drawPicture(Graphics g) {
		g.drawImage(bufferedImage, x, y, null);
	}
}
