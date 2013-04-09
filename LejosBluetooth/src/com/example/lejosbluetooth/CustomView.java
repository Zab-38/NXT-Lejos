package com.example.lejosbluetooth;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View{

	
	private Point point = null;

	public CustomView(Context context) {
		super(context);
	}
	
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public CustomView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}



	@Override
	protected void onDraw(Canvas canvas) {
		if(point!=null)
		{
			int originx = getWidth()/2;
			int originy = getHeight()/2;
			
			canvas.drawLine(originx, originy, originx+point.x, originy+point.y, new Paint());
			point = null;
		}
	}
	
	public void drawLineToPoint(Point point)
	{
		this.point = point;
		invalidate();
	}

}
