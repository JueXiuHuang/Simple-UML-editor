package mode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import panel.New_canvas;

public abstract class Service {
	
	protected New_canvas canvas = New_canvas.get_canvas();

	public abstract void mouseDragged(MouseEvent e);

	public abstract void mouseClicked(MouseEvent e);

	public abstract void mousePressed(MouseEvent e);

	public abstract void mouseReleased(MouseEvent e);

}
