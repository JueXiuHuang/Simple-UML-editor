package mode;

import java.awt.event.MouseEvent;

import object.Arrow_asso;
import object.Arrow_base;
import object.Arrow_comp;
import object.Object_base;

public class Composition_service extends Service{
	
	Arrow_base arr = new Arrow_comp();

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(this.canvas.unsure_relation.size() != 0){
			this.canvas.unsure_relation.get(0).set_end(e.getX(), e.getY());
			this.canvas.repaint();
        }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		canvas.selected_item.clear();
        for(Object_base item : canvas.item_lists){
            if(item.contains(e.getX(), e.getY())){
            	canvas.selected_item.add(item);
            }
        }
        if(canvas.selected_item.size()>0){
            System.out.println("Item selected!");
            Object_base item = canvas.selected_item.get(0);

            canvas.unsure_relation.add(this.arr.deepCopy());
            
            if(item.line_slash(e.getX(), e.getY()) && item.line_backslash(e.getX(), e.getY())){
            	canvas.unsure_relation.get(0).set_parent(canvas.selected_item.get(0), 0, canvas.selected_item.get(0).getH()/2);
            } else if(item.line_slash(e.getX(), e.getY()) && !item.line_backslash(e.getX(), e.getY())){
            	canvas.unsure_relation.get(0).set_parent(canvas.selected_item.get(0), canvas.selected_item.get(0).getW()/2, 0);
            } else if(!item.line_slash(e.getX(), e.getY()) && item.line_backslash(e.getX(), e.getY())){
            	canvas.unsure_relation.get(0).set_parent(canvas.selected_item.get(0), canvas.selected_item.get(0).getW()/2, canvas.selected_item.get(0).getH());
            } else if(!item.line_slash(e.getX(), e.getY()) && !item.line_backslash(e.getX(), e.getY())){
            	canvas.unsure_relation.get(0).set_parent(canvas.selected_item.get(0), canvas.selected_item.get(0).getW(), canvas.selected_item.get(0).getH()/2);
            }
        }
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(canvas.unsure_relation.size()!=0){
			canvas.selected_item.clear();
            for(Object_base item : canvas.item_lists){
                if(item.contains(e.getX(), e.getY())){
                	canvas.selected_item.add(item);
                }
            }
            if(canvas.selected_item.size() == 0){
            	canvas.unsure_relation.clear();
            	canvas.repaint();
            } else{
                Object_base item = canvas.selected_item.get(0);

                if(item.line_slash(e.getX(), e.getY()) && item.line_backslash(e.getX(), e.getY())){
                	canvas.unsure_relation.get(0).set_child(canvas.selected_item.get(0), 0, canvas.selected_item.get(0).getH()/2);
                } else if(item.line_slash(e.getX(), e.getY()) && !item.line_backslash(e.getX(), e.getY())){
                	canvas.unsure_relation.get(0).set_child(canvas.selected_item.get(0), canvas.selected_item.get(0).getW()/2, 0);
                } else if(!item.line_slash(e.getX(), e.getY()) && item.line_backslash(e.getX(), e.getY())){
                	canvas.unsure_relation.get(0).set_child(canvas.selected_item.get(0), canvas.selected_item.get(0).getW()/2, canvas.selected_item.get(0).getH());
                } else if(!item.line_slash(e.getX(), e.getY()) && !item.line_backslash(e.getX(), e.getY())){
                	canvas.unsure_relation.get(0).set_child(canvas.selected_item.get(0), canvas.selected_item.get(0).getW(), canvas.selected_item.get(0).getH()/2);
                }

                canvas.relationship.add(canvas.unsure_relation.get(0));
                canvas.unsure_relation.clear();

                canvas.repaint();
            }
        }
	}

}
