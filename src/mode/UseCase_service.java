package mode;

import java.awt.event.MouseEvent;

import object.Object_base;
import object.Object_usecase;

public class UseCase_service extends Service{
	
	private Object_usecase obj = new Object_usecase(100, 70);

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object_base tempBase;
        this.obj.set_pos(e.getX(), e.getY());
        tempBase = this.obj.deepCopy();

        this.canvas.addItem(tempBase);
        System.out.println(this.canvas.item_lists.size());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
